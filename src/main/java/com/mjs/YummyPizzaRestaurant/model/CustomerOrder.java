package com.mjs.YummyPizzaRestaurant.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class CustomerOrder {

    @Id
    int orderId;

    int customerId;
    String orderType;
    Date orderDate;
    double totalAmount;
    String eatingOption;
    String discountType;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    private OrderItem OrderId;

    public OrderItem getOrderId() {
        return OrderId;
    }

    public void setOrderId(OrderItem orderId) {
        OrderId = orderId;
    }
}
