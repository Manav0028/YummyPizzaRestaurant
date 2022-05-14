package com.mjs.YummyPizzaRestaurant.model;

public class CartItem {

    private Integer productId;
    private String productName;
    private String productType;
    private String pizzaBase;
    private String pizzaSize;
    private String pizzaSauce;
    private Integer quantity;
    private double productPrice;
    private String topping;

    private Integer toppingId;

    public CartItem() {
    }

    public CartItem(String productName, String productType, String pizzaBase, String pizzaSize, String pizzaSauce, String topping, double productPrice, Integer quantity) {
        this.productName = productName;
        this.productType = productType;
        this.pizzaBase = pizzaBase;
        this.pizzaSize = pizzaSize;
        this.pizzaSauce = pizzaSauce;
        this.productPrice = productPrice;
        this.topping = topping;
        this.quantity = quantity;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
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

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public String getTopping() {
        return topping;
    }

    public void setTopping(String topping) {
        this.topping = topping;
    }

    public Integer getToppingId() {
        return toppingId;
    }

    public void setToppingId(Integer toppingId) {
        this.toppingId = toppingId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getProductToppingId() {
        return "" + this.productId + this.toppingId;
    }
}
