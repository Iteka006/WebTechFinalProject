package com.example.TicketBooking.Domain;

import java.io.Serializable;
import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Seat implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String firstname;
    private String lastname;
    private String busNo;
    private Integer seats;
    private Date date;
    private String origin;
    private String destination;
    private String hour;
    private String price;
    private String phoneNumber;
    public Seat() {
    }
    public Seat(Integer id, String firstname, String lastname, String busNo, Integer seats, Date date, String origin,
            String destination, String hour, String price, String phoneNumber) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.busNo = busNo;
        this.seats = seats;
        this.date = date;
        this.origin = origin;
        this.destination = destination;
        this.hour = hour;
        this.price = price;
        this.phoneNumber = phoneNumber;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getFirstname() {
        return firstname;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public String getBusNo() {
        return busNo;
    }
    public void setBusNo(String busNo) {
        this.busNo = busNo;
    }
    public Integer getSeats() {
        return seats;
    }
    public void setSeats(Integer seats) {
        this.seats = seats;
    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public String getOrigin() {
        return origin;
    }
    public void setOrigin(String origin) {
        this.origin = origin;
    }
    public String getDestination() {
        return destination;
    }
    public void setDestination(String destination) {
        this.destination = destination;
    }
    public String getHour() {
        return hour;
    }
    public void setHour(String hour) {
        this.hour = hour;
    }
    public String getPrice() {
        return price;
    }
    public void setPrice(String price) {
        this.price = price;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
    
    
}
