package com.mjs.YummyPizzaRestaurant.model;

import java.time.LocalDateTime;
import java.util.Date;

public class Booking {
    int bookingID;
    Date bookingDate; //Need booking date?
    int numberOfPerson;
    Date diningDateTime;
    int customerID;
    boolean groupBooking;

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