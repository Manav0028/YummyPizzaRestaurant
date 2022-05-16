package com.mjs.YummyPizzaRestaurant.service;

import com.mjs.YummyPizzaRestaurant.model.*;
import com.mjs.YummyPizzaRestaurant.repo.BookingRepo;
import com.mjs.YummyPizzaRestaurant.repo.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.Scanner;

@Service
public class BookingService {

    @Autowired
    private BookingRepo bookings;

    @Autowired
    private CustomerRepo customers;

//    Booking booking;
//
////    public void setupBooking(int numberOfPerson, int bookingDate, String customerName){
////        booking = new Booking();
////        System.out.println("jhdflk");
////        booking.setNumberOfPerson(numberOfPerson);
////        booking.setBookingDate(bookingDate);
////        booking.setCustomerName(customerName);
////        bookings.save(booking);
////        System.out.println("gdhf");
//    }

}



