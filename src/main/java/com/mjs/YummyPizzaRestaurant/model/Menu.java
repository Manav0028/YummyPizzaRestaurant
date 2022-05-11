package com.mjs.YummyPizzaRestaurant.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Menu {

    @Id
    int productId;

    String productName;
    double productPrice;
    String productType; // enum
    double calories;
    String pizzaBase; // enum
    String pizzaSize; // enum
    String pizzaSauce; // enum

}
