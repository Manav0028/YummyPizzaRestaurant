package com.mjs.YummyPizzaRestaurant.repo;

import com.mjs.YummyPizzaRestaurant.model.Topping;
import org.springframework.data.repository.CrudRepository;

import java.util.Iterator;
import java.util.List;

public interface ToppingRepo extends CrudRepository<Topping, Integer> {
    List<Topping> findByProductId(Integer productId);
}
