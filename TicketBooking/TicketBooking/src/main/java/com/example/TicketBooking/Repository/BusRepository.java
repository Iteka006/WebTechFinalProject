package com.example.TicketBooking.Repository;

import java.sql.Date;
import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.example.TicketBooking.Domain.Bus;

@Repository
public interface BusRepository extends JpaRepository<Bus, Integer> {
    List<Bus> findByBusNo(String busNo);
    List<Bus> findByOriginAndDestinationAndDate(String origin, String destination, Date date);
    Bus findFirstByBusNo(String busNo);
    List<Bus> findByDocumentIsNotNull();

   
}
