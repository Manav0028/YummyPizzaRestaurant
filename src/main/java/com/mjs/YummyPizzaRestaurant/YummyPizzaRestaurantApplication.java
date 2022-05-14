package com.mjs.YummyPizzaRestaurant;

import com.mjs.YummyPizzaRestaurant.gui.PizzaMenu;
import com.mjs.YummyPizzaRestaurant.model.Customer;
import com.mjs.YummyPizzaRestaurant.repo.BookingRepo;
import com.mjs.YummyPizzaRestaurant.repo.CustomerRepo;
import com.mjs.YummyPizzaRestaurant.repo.MenuRepo;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import javax.swing.*;

@SpringBootApplication
public class YummyPizzaRestaurantApplication implements InitializingBean {

	@Autowired
	private MenuRepo menuRepo;

	@Autowired
	private BookingRepo bookings;

	@Autowired
	private CustomerRepo customers;


	private void setupCustomers() {
		System.out.println("Setting up customers") ;

		Customer customer;

		customer = new Customer(1234567, "Sean", "Lo", "sl@uts.com", 041234567, "230 Kingsford", true) ;
		customers.save(customer);




	}


	public static void main(String[] args) {
//		SpringApplication.run(YummyPizzaRestaurantApplication.class, args);
		SpringApplicationBuilder builder = new SpringApplicationBuilder(YummyPizzaRestaurantApplication.class);
		builder.headless(false).run(args);
	}

	@Override
	public void afterPropertiesSet() throws Exception {

		setupCustomers();

		PizzaMenu menuGui = new PizzaMenu(menuRepo);
		menuGui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menuGui.pack();
		menuGui.setVisible(true);
	}
}
