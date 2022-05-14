package com.mjs.YummyPizzaRestaurant.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity

public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int paymentId;
    double paymentAmount;
    String paymentType;
    Date paymentDate;
}
