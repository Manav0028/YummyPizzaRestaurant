//Jen-Wei Lo 14347367

package com.mjs.YummyPizzaRestaurant.repo;

import com.mjs.YummyPizzaRestaurant.model.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepo extends CrudRepository<Customer, Integer> {
}
