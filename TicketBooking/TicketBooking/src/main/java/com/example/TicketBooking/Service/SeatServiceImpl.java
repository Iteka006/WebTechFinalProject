package com.example.TicketBooking.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.TicketBooking.Domain.Seat;
import com.example.TicketBooking.Repository.SeatRepository;

@Service
public class SeatServiceImpl implements SeatService {
    @Autowired
    private SeatRepository seatRepository;

    @Override
    public List<Seat> getAllSeats() {
        return seatRepository.findAll();
    }

    @Override
    public Seat getSeatById(Integer id) {
        return seatRepository.findById(id).orElse(null);
    }

    @Override
    public Seat saveSeat(Seat seat) {
        return seatRepository.save(seat);
    }

    @Override
    public void deleteSeat(Integer id) {
        seatRepository.deleteById(id);
    }
    
}
