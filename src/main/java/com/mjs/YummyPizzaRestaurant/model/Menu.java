package com.mjs.YummyPizzaRestaurant.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int productId;

    String productName;
    double productPrice;
    String productType; // enum
    double calories;
    String pizzaBase; // enum
    String pizzaSize; // enum
    String pizzaSauce; // enum

    public Menu() {
    }

    public Menu(int productId, String productName, double productPrice, String productType, double calories, String pizzaBase, String pizzaSize, String pizzaSauce) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productType = productType;
        this.calories = calories;
        this.pizzaBase = pizzaBase;
        this.pizzaSize = pizzaSize;
        this.pizzaSauce = pizzaSauce;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public double getCalories() {
        return calories;
    }

    public void setCalories(double calories) {
        this.calories = calories;
    }

    public String getPizzaBase() {
        return pizzaBase;
    }

    public void setPizzaBase(String pizzaBase) {
        this.pizzaBase = pizzaBase;
    }

    public String getPizzaSize() {
        return pizzaSize;
    }

    public void setPizzaSize(String pizzaSize) {
        this.pizzaSize = pizzaSize;
    }

    public String getPizzaSauce() {
        return pizzaSauce;
    }

    public void setPizzaSauce(String pizzaSauce) {
        this.pizzaSauce = pizzaSauce;
    }
}
