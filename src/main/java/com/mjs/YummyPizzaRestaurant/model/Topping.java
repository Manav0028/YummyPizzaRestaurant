package com.mjs.YummyPizzaRestaurant.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Topping {

    @Id
    int toppingId;
    String toppingName; // enum
    String toppingType; // enum
    int productId;
}
