package com.example.TicketBooking.Service;

import java.sql.Date;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.example.TicketBooking.Domain.Bus;
import org.springframework.core.io.Resource;




public interface BusService {
    //String registerMultipleBuses(Bus bus); 
    List<Bus> findByBusNo(String busNo);

     String registerBus(Bus bus);

     String updateBus(String busNo, Bus bus);

     Bus getBusByBusNo(String busNo);
     //void updateBusStatus(String busNo);

     String updateBusStatus(String busNo, String seatNumber);
     String deleteBusByBusNo(String busNo);

    List<Bus> getAllBuses();
    List<Bus> getBusesByOriginDestinationAndDate(String origin, String destination, Date date);
     String uploadDocument(String busNo, MultipartFile file);
      ResponseEntity<Resource> downloadDocument(String busNo);

    // Method to download document
    // ResponseEntity<Resource> downloadDocument(String busNo);

}
