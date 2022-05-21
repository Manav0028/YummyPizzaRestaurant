package com.mjs.YummyPizzaRestaurant;

import com.mjs.YummyPizzaRestaurant.gui.HomeUI;
import com.mjs.YummyPizzaRestaurant.model.Booking;
import com.mjs.YummyPizzaRestaurant.model.Customer;
import com.mjs.YummyPizzaRestaurant.repo.*;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class YummyPizzaRestaurantApplication  implements InitializingBean {

	@Autowired
	private MenuRepo menuRepo;

	@Autowired
	private ToppingRepo toppingRepo;

	@Autowired
	private OrderRepo orderRepo;

	@Autowired
	private CustomerRepo customerRepo;

	@Autowired
	private BookingRepo bookingRepo;

	//Jen-Wei Lo 14347367
	private void setupBooking() {
		Booking booking;

		booking = new Booking(20200825, 13, 123, "Jennifer Chan", true);
		booking = new Booking(20201225, 10, 121, "Mark Wingman", true);

		bookingRepo.save(booking);


	}
	//Jen-Wei Lo 14347367
	private void setupCustomer() {
		Customer customer;

		customer = new Customer(101, "Jack", "Swing", "JL@uts.com", 0411122234, "Anzac Parade 320");

		customerRepo.save(customer);

	}

	public static void main(String[] args) {
		//SpringApplication.run(YummyPizzaRestaurantApplication.class, args);
		SpringApplicationBuilder builder = new SpringApplicationBuilder(YummyPizzaRestaurantApplication.class);
		builder.headless(false).run(args);
	}

	@Override
	public void afterPropertiesSet() throws Exception {

		setupCustomer();
		setupBooking();

		new HomeUI(menuRepo, toppingRepo, orderRepo);

	}
}
