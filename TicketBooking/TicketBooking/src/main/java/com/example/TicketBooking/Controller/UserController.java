package com.example.TicketBooking.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.TicketBooking.Domain.User;
import com.example.TicketBooking.Service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User user) {
        String result = userService.registerUser(user);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
    

    @PutMapping("/update")
    public ResponseEntity<String> updateUser(@RequestBody User user) {
        String result = userService.updateUser(user);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteUser(@RequestBody User user) {
        String result = userService.deleteUser(user);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Integer id) {
        User user = userService.getUserById(id);
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return ResponseEntity.status(HttpStatus.OK).body(users);
    }

    @GetMapping("/retrieve")
    public ResponseEntity<List<User>> retrieveUser(
            @RequestParam(name = "phoneNumber") String phoneNumber,
            @RequestParam(name = "password") String password) {
        List<User> userList = userService.retrieveUser(phoneNumber, password);
        return ResponseEntity.status(HttpStatus.OK).body(userList);
    }
    
}
