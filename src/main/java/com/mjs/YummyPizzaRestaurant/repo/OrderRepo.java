package com.mjs.YummyPizzaRestaurant.repo;

import com.mjs.YummyPizzaRestaurant.model.CustomerOrder;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepo extends CrudRepository<CustomerOrder, Integer> {
}
