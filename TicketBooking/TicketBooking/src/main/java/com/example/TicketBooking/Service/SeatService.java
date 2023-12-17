package com.example.TicketBooking.Service;

import java.util.List;

import com.example.TicketBooking.Domain.Seat;

public interface SeatService {
    List<Seat> getAllSeats();

    Seat getSeatById(Integer id);

    Seat saveSeat(Seat seat);

    void deleteSeat(Integer id);
    
}
