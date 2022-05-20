package com.mjs.YummyPizzaRestaurant;

import com.mjs.YummyPizzaRestaurant.gui.HomeUI;
import com.mjs.YummyPizzaRestaurant.gui.PizzaMenu;
import com.mjs.YummyPizzaRestaurant.gui.MakeGroupBooking;
import com.mjs.YummyPizzaRestaurant.model.Booking;
import com.mjs.YummyPizzaRestaurant.model.Customer;
import com.mjs.YummyPizzaRestaurant.model.CustomerOrder;
import com.mjs.YummyPizzaRestaurant.model.Topping;
import com.mjs.YummyPizzaRestaurant.repo.*;
import com.mjs.YummyPizzaRestaurant.service.BookingService;
import org.hibernate.hql.internal.ast.tree.SearchedCaseNode;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import java.util.Date;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.util.Iterator;
import java.util.List;

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

	private void setupBooking() {
		Booking booking;

		booking = new Booking(20200825, 13, 123, "Jennifer Chan", true);
		booking = new Booking(20201225, 10, 121, "Mark Wingman", true);

		bookingRepo.save(booking);


	}

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
