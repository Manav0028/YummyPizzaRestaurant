package com.mjs.YummyPizzaRestaurant.model;

public class Customer {
    int customerID;
    String firstName;
    String lastName;
    String email;
    Long phoneNumber;
    String deliveryAddress;
    boolean isMember;

    public Customer (int customerID, String firstName, String lastName,
                     String email, Long phoneNumber, String deliveryAddress,
                     boolean isMember) {
        this.customerID = customerID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.deliveryAddress = deliveryAddress;
        this.isMember = isMember;
    }

    public int getCustomerID() {return customerID; }
    public String getFirstName() {return firstName; }
    public  String getLastName() {return lastName; }


}
