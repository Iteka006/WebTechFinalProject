package com.example.TicketBooking.Domain;

import java.io.Serializable;
import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
//import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;




@Entity
public class Bus implements Serializable {
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer busId;
    @Column(name = "busNo")
    private String busNo;
    //@Column(name="date")
    private Date date;
    private Integer seats;
    private String origin;
    private String destination;
    private String status;
    private String hour;
    private String price;
    @Lob
    private byte[] document;
    public Bus() {
    }
    public Bus(Integer busId, String busNo, Date date, Integer seats, String origin, String destination,
            String status, String hour, String price) {
        this.busId = busId;
        this.busNo = busNo;
        this.date = date;
        this.seats = seats;
        this.origin = origin;
        this.destination = destination;
        this.status = status;
        this.hour = hour;
        this.price = price;
    }
    public Integer getBusId() {
        return busId;
    }
    public void setBusId(Integer busId) {
        this.busId = busId;
    }
    public String getbusNo() {
        return busNo;
    }
    public void setbusNo(String bus_no) {
        this.busNo = bus_no;
    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public Integer getSeats() {
        return seats;
    }
    public void setSeats(Integer seats) {
        this.seats = seats;
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
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
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
    public byte[] getDocument() {
        return document;
    }
    
    public void setDocument(byte[] document) {
        this.document = document;
    }
   
    
    
}
