package com.example.TicketBooking.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.TicketBooking.Domain.Seat;
import com.example.TicketBooking.Service.SeatService;

@RestController
@RequestMapping("/seats")
@CrossOrigin(origins = "http://localhost:8080")
public class SeatController {
     @Autowired
    private SeatService seatService;

    @GetMapping
    public List<Seat> getAllSeats() {
        return seatService.getAllSeats();
    }

    @GetMapping("/{id}")
    public Seat getSeatById(@PathVariable Integer id) {
        return seatService.getSeatById(id);
    }

    @PostMapping("/book")
    public Seat saveSeat(@RequestBody Seat seat) {
        return seatService.saveSeat(seat);
    }

 

    @DeleteMapping("/{id}")
    public void deleteSeat(@PathVariable Integer id) {
        seatService.deleteSeat(id);
    }
    
}
