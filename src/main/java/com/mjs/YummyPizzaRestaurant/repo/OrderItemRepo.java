package com.mjs.YummyPizzaRestaurant.repo;

import com.mjs.YummyPizzaRestaurant.model.OrderItem;
import org.springframework.data.repository.CrudRepository;

public interface OrderItemRepo extends CrudRepository<OrderItem, Integer> {
}
