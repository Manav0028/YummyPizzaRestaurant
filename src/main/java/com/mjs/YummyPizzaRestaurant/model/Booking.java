package com.mjs.YummyPizzaRestaurant.model;

import java.time.LocalDateTime;

public class Booking {
    int bookingID;
    LocalDateTime bookingDate; //Need booking date?
    int numberOfPerson;
    LocalDateTime diningDateTime;
    int customerID;
    boolean groupBooking;

    public Booking(int bookingID, LocalDateTime bookingDate, int numberOfPerson,
                   LocalDateTime diningDateTime, int customerID, boolean groupBooking){
        this.bookingID = bookingID;
        this.bookingDate = bookingDate;
        this.numberOfPerson = numberOfPerson;
        this.diningDateTime = diningDateTime;
        this.customerID = customerID;
        this.groupBooking = groupBooking;
    }

}
