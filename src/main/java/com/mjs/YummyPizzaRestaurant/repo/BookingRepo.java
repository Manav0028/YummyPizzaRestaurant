//Jen-Wei Lo 14347367

package com.mjs.YummyPizzaRestaurant.repo;

import com.mjs.YummyPizzaRestaurant.model.Booking;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface BookingRepo extends CrudRepository<Booking, Integer> {


}
