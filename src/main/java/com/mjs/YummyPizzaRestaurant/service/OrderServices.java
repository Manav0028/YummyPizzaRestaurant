package com.mjs.YummyPizzaRestaurant.service;

import com.mjs.YummyPizzaRestaurant.model.CartItem;
import com.mjs.YummyPizzaRestaurant.model.CustomerOrder;
import com.mjs.YummyPizzaRestaurant.model.OrderItem;
import com.mjs.YummyPizzaRestaurant.model.enums.OrderType;
import com.mjs.YummyPizzaRestaurant.repo.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Service
public class OrderServices {

    @Autowired
    private OrderRepo orderRepo;

    public CustomerOrder saveOrder(CustomerOrder order) {
        return this.orderRepo.save(order);
    }

    public CustomerOrder saveOrder(Map<String, CartItem> cartItems, OrderRepo orderRepo) {
        CustomerOrder order = new CustomerOrder();
        order.setCustomerId(1);
        order.setOrderDate(new Date());
        order.setOrderType(OrderType.counterOrder.getDescription());
        order.setEatingOption("Dine In");
        order.setDiscountType("NONE");
        Set<OrderItem> items = new HashSet<>();
        cartItems.forEach((s, cartItem) -> {
            items.add(new OrderItem(cartItem.getProductId(), cartItem.getQuantity(), cartItem.getProductPrice(), cartItem.getToppingId(), order));
            order.setTotalAmount(order.getTotalAmount() + cartItem.getProductPrice());
        });
        order.setOrderItems(items);

        return orderRepo.save(order);
    }

    public OrderServices(OrderRepo orderRepo) {
        this.orderRepo = orderRepo;
    }

    public OrderServices() {
    }

    public void deleteAll(){
        orderRepo.deleteAll();
    }
}
