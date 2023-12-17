package com.example.TicketBooking.Controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.TicketBooking.Domain.Bus;
import com.example.TicketBooking.Service.BusService;
import org.springframework.http.MediaType;
import org.springframework.http.HttpHeaders;
@RestController
@RequestMapping("/bus")
@CrossOrigin(origins = "http://localhost:8080")
public class BusController {
    @Autowired
    private BusService busService;

    @PostMapping("/register")
    public ResponseEntity<String> registerBus(@RequestBody Bus bus) {
        String result = busService.registerBus(bus);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
    @PostMapping("/uploadDocument/{busNo}")
    public ResponseEntity<String> uploadDocument(@PathVariable String busNo, @RequestParam("file") MultipartFile file) {
        String result = busService.uploadDocument(busNo, file);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
    // @PostMapping("/register")
    // public ResponseEntity<String> registerMultipleBuses(@RequestBody Bus bus) {
    //     String result = busService.registerMultipleBuses(bus);
    //     return ResponseEntity.status(HttpStatus.OK).body(result);
    // }

    @GetMapping("/getByBusNo/{busNo}")
    public ResponseEntity<List<Bus>> getBusesByBusNo(@PathVariable String busNo) {
        List<Bus> buses = busService.findByBusNo(busNo);
        return ResponseEntity.status(HttpStatus.OK).body(buses);
    }
    @PutMapping("/update/{busNo}")
public ResponseEntity<String> updateBus(@PathVariable String busNo, @RequestBody Bus updatedBus) {
    String result = busService.updateBus(busNo, updatedBus);
    return ResponseEntity.status(HttpStatus.OK).body(result);
}

    @DeleteMapping("/{busNo}")
    public ResponseEntity<String> deleteBus(@PathVariable String busNo) {
        String result = busService.deleteBusByBusNo(busNo);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Bus>> getAllBuses() {
        List<Bus> buses = busService.getAllBuses();
        return ResponseEntity.status(HttpStatus.OK).body(buses);
    }

    @GetMapping("/{busNo}")
    public ResponseEntity<Bus> getBusByBusNo(@PathVariable String busNo) {
        Bus bus = busService.getBusByBusNo(busNo);
        if (bus != null) {
            return ResponseEntity.ok(bus);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

     @GetMapping("/search")
    public ResponseEntity<List<Bus>> getBusesByOriginDestinationAndDate(
            @RequestParam String origin,
            @RequestParam String destination,
            @RequestParam Date date) {
        List<Bus> buses = busService.getBusesByOriginDestinationAndDate(origin, destination, date);
        return ResponseEntity.status(HttpStatus.OK).body(buses);
    }

    @PutMapping("/updateStatus/{busNo}/{seatNumber}")
    public ResponseEntity<String> updateBusStatus(@PathVariable String busNo, @PathVariable String seatNumber) {
        try {
            String result = busService.updateBusStatus(busNo, seatNumber);

            // Handle the result accordingly
            if (result.contains("Successfully updated")) {
                return ResponseEntity.ok(result);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(result);
            }
        } catch (Exception e) {
            // Handle any exceptions appropriately
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating bus status");
        }
    }

     @GetMapping("/download/{busNo}")
    public ResponseEntity<Resource> downloadDocument(@PathVariable String busNo) {
        try {
            List<Bus> existingBuses = busService.findByBusNo(busNo);

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
