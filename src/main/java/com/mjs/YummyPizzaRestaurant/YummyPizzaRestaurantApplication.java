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

		customer = new Customer(100, "Sean", "Lo", "sl@uts.com", 12345678, "230 Kingsford", true) ;
		customers.save(customer);

		customer = new Customer(101, "Jennifer", "Windsor", "jw@uts.com", 23456789, "222 Waterloo", true) ;
		customers.save(customer);

		customer = new Customer(102, "Manny", "Manez", "mm@uts.com", 34567890, "121 Broadway", false) ;
		customers.save(customer);

		customer = new Customer(103, "Tommy", "Sham", "ts@uts.com", 45678901, "230 Radnwick", true) ;
		customers.save(customer);

		customer = new Customer(104, "Timothy", "Gonzalez", "tg@uts.com", 56789012, "333 Kingsford", false) ;
		customers.save(customer);

		customer = new Customer(105, "Jane", "Chen", "jc@uts.com", 67890123, "126 Kingsford", true) ;
		customers.save(customer);

		customer = new Customer(106, "Yoyo", "Wing", "yw@uts.com", 78901234, "230 Radnwick", true) ;
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
