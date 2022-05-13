package com.mjs.YummyPizzaRestaurant.repo;

import com.mjs.YummyPizzaRestaurant.model.Menu;
import org.springframework.data.repository.CrudRepository;

public interface MenuRepo extends CrudRepository<Menu, Integer> {
}
