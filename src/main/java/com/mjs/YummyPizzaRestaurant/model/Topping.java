package com.mjs.YummyPizzaRestaurant.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Topping {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int toppingId;
    String toppingName; // enum
    String toppingType; // enum
    int productId;

    public Topping() {
    }

    public Topping(int toppingId, String toppingName, String toppingType, int productId) {
        this.toppingId = toppingId;
        this.toppingName = toppingName;
        this.toppingType = toppingType;
        this.productId = productId;
    }

    public int getToppingId() {
        return toppingId;
    }

    public void setToppingId(int toppingId) {
        this.toppingId = toppingId;
    }

    public String getToppingName() {
        return toppingName;
    }

    public void setToppingName(String toppingName) {
        this.toppingName = toppingName;
    }

    public String getToppingType() {
        return toppingType;
    }

    public void setToppingType(String toppingType) {
        this.toppingType = toppingType;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    @Override
    public String toString() {
        return "Topping{" +
                "toppingId=" + toppingId +
                ", toppingName='" + toppingName + '\'' +
                ", toppingType='" + toppingType + '\'' +
                ", productId=" + productId +
                '}';
    }
}
