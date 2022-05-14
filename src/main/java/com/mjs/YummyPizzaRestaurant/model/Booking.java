package com.mjs.YummyPizzaRestaurant.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int bookingID;

    private int numberOfPerson;
    private Date bookingDate;
    private int customerID;
    private String customerName;
    private boolean groupBooking;

    private Booking() {

    }

    public Booking(int bookingID, Date bookingDate, int numberOfPerson,
                   int customerID, String customerName, boolean groupBooking){
        this.bookingID = bookingID;
        this.bookingDate = bookingDate;
        this.numberOfPerson = numberOfPerson;
        this.customerID = customerID;
        this.customerName = customerName;
        this.groupBooking = groupBooking;
    }

    public int getBookingID() {
        return bookingID;
    }
    public void setBookingID(int bookingID) {
        this.bookingID = bookingID;
    }

    public Date getBookingDate() {
        return bookingDate;
    }
    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    public int getNumberOfPerson() {
        return numberOfPerson;
    }
    public void setNumberOfPerson(int numberOfPerson) {
        this.numberOfPerson = numberOfPerson;
    }

    public int getCustomerID() {
        return customerID;
    }
    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getCustomerName() {
        return customerName;
    }
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public boolean isGroupBooking() {
        return groupBooking;
    }
    public void setGroupBooking(boolean groupBooking) {
        this.groupBooking = groupBooking;
    }

    public void groupBookingDeclined() {
        if (this.numberOfPerson > 20 || this.numberOfPerson < 6 ) {
            System.out.println("Group booking only accept a party size of 6 - 20, Please adjust the size.");
        }
    }
}
