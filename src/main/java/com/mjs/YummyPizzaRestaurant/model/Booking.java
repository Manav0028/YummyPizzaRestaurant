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

    private Date bookingDate; //Need booking date?
    private int numberOfPerson;
    private Date diningDateTime;
    private int customerID;
    private boolean groupBooking;

    private Booking() {

    }

    public Booking(int bookingID, Date bookingDate, int numberOfPerson,
                   Date diningDateTime, int customerID, boolean groupBooking){
        this.bookingID = bookingID;
        this.bookingDate = bookingDate;
        this.numberOfPerson = numberOfPerson;
        this.diningDateTime = diningDateTime;
        this.customerID = customerID;
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

    public Date getDiningDateTime() {
        return diningDateTime;
    }

    public void setDiningDateTime(Date diningDateTime) {
        this.diningDateTime = diningDateTime;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public boolean isGroupBooking() {
        return groupBooking;
    }

    public void setGroupBooking(boolean groupBooking) {
        this.groupBooking = groupBooking;
    }
}
