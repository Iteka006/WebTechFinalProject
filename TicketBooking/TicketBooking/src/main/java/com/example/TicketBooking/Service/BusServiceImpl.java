package com.example.TicketBooking.Service;

import java.io.IOException;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.TicketBooking.Domain.Bus;
import com.example.TicketBooking.Repository.BusRepository;


import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;



@Service
public class BusServiceImpl implements BusService {
    @Autowired
    private BusRepository busRepository;

    @Override
public String registerBus(Bus bus) {
    List<Bus> buses = new ArrayList<>();
    for (int i = 1; i <= 16; i++) {
        Bus newBus = new Bus(null, bus.getbusNo(), bus.getDate(), i,
                bus.getOrigin(), bus.getDestination(), "unbooked", bus.getHour(), bus.getPrice());
        buses.add(newBus);
    }

    // Save all buses to the database
    busRepository.saveAll(buses);

    return "Successfully registered";
}


@Override
public String updateBus(String busNo, Bus updatedBus) {
    List<Bus> existingBuses = busRepository.findByBusNo(busNo);
    if (!existingBuses.isEmpty()) {
        for (Bus existingBus : existingBuses) {
            // Update only the specified properties if they are not null
            if (updatedBus.getDate() != null) {
                existingBus.setDate(updatedBus.getDate());
            }
            if (updatedBus.getSeats() != null) {
                existingBus.setSeats(updatedBus.getSeats());
            }
            if (updatedBus.getOrigin() != null) {
                existingBus.setOrigin(updatedBus.getOrigin());
            }
            if (updatedBus.getDestination() != null) {
                existingBus.setDestination(updatedBus.getDestination());
            }
            if (updatedBus.getStatus() != null) {
                existingBus.setStatus(updatedBus.getStatus());
            } else {
                // If status is not specified, set it to "unbooked"
                existingBus.setStatus("unbooked");
            }
            if (updatedBus.getHour() != null) {
                existingBus.setHour(updatedBus.getHour());
            }
            if (updatedBus.getPrice() != null) {
                existingBus.setPrice(updatedBus.getPrice());
            }

            // Save the updated bus to the database
            busRepository.save(existingBus);
        }
        return "Successfully updated all buses with busNo: " + busNo;
    } else {
        return "Buses not found with busNo: " + busNo;
    }
}



@Override
    public String deleteBusByBusNo(String busNo) {
        List<Bus> buses = busRepository.findByBusNo(busNo);
        if (!buses.isEmpty()) {
            busRepository.deleteAll(buses);
            return "Successfully deleted all buses with busNo: " + busNo;
        } else {
            return "Buses not found with busNo: " + busNo;
        }
    }

    @Override
    public List<Bus> getAllBuses() {
        return busRepository.findAll();
    }

    @Override
public Bus getBusByBusNo(String busNo) {
    List<Bus> existingBuses = busRepository.findByBusNo(busNo);
    if (!existingBuses.isEmpty()) {
        // Assuming you want to return the first bus found with the specified busNo
        return existingBuses.get(0);
    } else {
        return null;
    }
}



    @Override
    public List<Bus> findByBusNo(String busNo) {
        return busRepository.findByBusNo(busNo);
    }

    @Override
    public List<Bus> getBusesByOriginDestinationAndDate(String origin, String destination, Date date) {
        return busRepository.findByOriginAndDestinationAndDate(origin, destination, date);
    }


    @Override
    public String updateBusStatus(String busNo, String seatNumber) {
        try {
            List<Bus> existingBuses = busRepository.findByBusNo(busNo);
            if (!existingBuses.isEmpty()) {
                for (Bus existingBus : existingBuses) {
                    // Check if the seat number matches the one being booked
                    if (existingBus.getSeats().toString().equals(seatNumber)) {
                        // Update only the status to "booked"
                        existingBus.setStatus("booked");
                        busRepository.save(existingBus);
                        return "Successfully updated the status of bus with busNo: " + busNo + ", seatNumber: " + seatNumber;
                    }
                }
                return "Seat not found with seatNumber: " + seatNumber + " for busNo: " + busNo;
            } else {
                return "Buses not found with busNo: " + busNo;
            }
        } catch (Exception e) {
            // Handle any exceptions appropriately
            throw new RuntimeException("Error updating bus status", e);
        }
    }


    @Override
public String uploadDocument(String busNo, MultipartFile file) {
    try {
        List<Bus> existingBuses = busRepository.findByBusNo(busNo);
        if (!existingBuses.isEmpty()) {
            for (Bus bus : existingBuses) {
                bus.setDocument(file.getBytes());
                busRepository.save(bus);
            }
            return "Document uploaded successfully for all buses with busNo: " + busNo;
        } else {
            return "Buses not found with busNo: " + busNo;
        }
    } catch (IOException e) {
        return "Error uploading document: " + e.getMessage();
    }
}
 @Override
    public ResponseEntity<Resource> downloadDocument(String busNo) {
        try {
            List<Bus> existingBuses = busRepository.findByBusNo(busNo);

            if (!existingBuses.isEmpty()) {
                Bus bus = existingBuses.get(0);
                ByteArrayResource resource = new ByteArrayResource(bus.getDocument());

                return ResponseEntity.ok()
                        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=document.pdf")
                        .contentLength(bus.getDocument().length)
                        .contentType(MediaType.APPLICATION_PDF)
                        .body(resource);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
        } catch (Exception e) {
            // Handle any exceptions appropriately
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
    }

   

    
    



