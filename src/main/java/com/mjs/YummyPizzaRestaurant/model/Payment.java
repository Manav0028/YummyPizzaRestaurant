package com.mjs.YummyPizzaRestaurant.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Payment {

    @Id
    int paymentId;
    double paymentAmount;
    String paymentType;
    Date paymentDate;
}
