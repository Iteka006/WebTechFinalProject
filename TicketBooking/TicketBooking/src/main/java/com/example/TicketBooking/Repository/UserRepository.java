package com.example.TicketBooking.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.TicketBooking.Domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> findByPhoneNumberAndPassword(String phoneNumber, String password);
}
