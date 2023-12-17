package com.example.TicketBooking.Service;

import java.util.List;

import com.example.TicketBooking.Domain.User;

public interface UserService {
    String registerUser(User user);

    String updateUser(User user);

    String deleteUser(User user);

    List<User> getAllUsers();

    User getUserById(Integer id);

    List<User> retrieveUser(String phoneNumber, String password);
    
}
