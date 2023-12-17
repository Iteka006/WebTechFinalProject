package com.example.TicketBooking.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.TicketBooking.Domain.User;
import com.example.TicketBooking.Repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
     @Autowired
    private UserRepository userRepository;

    @Override
    public String registerUser(User user) {
        user.setRole("user");
        userRepository.save(user);
        return "Successfully registered";
    }

    @Override
    public String updateUser(User user) {
        userRepository.save(user);
        return "Successfully updated";
    }

    @Override
    public String deleteUser(User user) {
        userRepository.delete(user);
        return "Successfully deleted";
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Integer id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public List<User> retrieveUser(String phoneNumber, String password) {
        List<User> userList = userRepository.findByPhoneNumberAndPassword(phoneNumber, password);
    
        // Log the results
        System.out.println("User List Size: " + userList.size());
        
        return userList;
    }
    
}
