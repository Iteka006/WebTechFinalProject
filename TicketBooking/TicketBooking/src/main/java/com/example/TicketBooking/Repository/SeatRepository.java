package com.example.TicketBooking.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.TicketBooking.Domain.Seat;

@Repository
public interface SeatRepository extends JpaRepository<Seat, Integer>  {
    
}
