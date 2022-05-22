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

		booking = new Booking(20221225, 10, 121, "Mark Wingman", true);
		bookingRepo.save(booking);

		booking = new Booking(20220821, 7, 122, "John Wick", true);
		bookingRepo.save(booking);

		booking = new Booking(20220930, 9, 123, "Jane Austin", true);
		bookingRepo.save(booking);

		booking = new Booking(20220611, 5, 124, "Angela Olsen", false);
		bookingRepo.save(booking);

		booking = new Booking(20220703, 13, 125, "Tim Oh", true);
		bookingRepo.save(booking);

		booking = new Booking(20220905, 4, 126, "Tom Hank", false);
		bookingRepo.save(booking);

		booking = new Booking(20221117, 7, 127, "Ronald Lin", true);
		bookingRepo.save(booking);

		booking = new Booking(20220928, 3, 128, "Ray Holland", false);
		bookingRepo.save(booking);

		booking = new Booking(20221221, 13, 129, "Norman Harvey", true);
		bookingRepo.save(booking);

		booking = new Booking(20220617, 19, 130, "Sandra Oh", true);
		bookingRepo.save(booking);


	}
	//Jen-Wei Lo 14347367
	private void setupCustomer() {
		Customer customer;

		customer = new Customer(101, "Jack", "Swing", "JL@uts.com", 0411122234, "Anzac Parade 320");
		customerRepo.save(customer);

		customer = new Customer(102, "Sully", "Prudhomme", "SP@uts.com", 0411122235, "Abbotsbury 123");
		customerRepo.save(customer);

		customer = new Customer(103, "Theodor", "Mommsen", "TM@uts.com", 0411122221, "Busby 321");
		customerRepo.save(customer);

		customer = new Customer(104, "Svante", "Arrhenius", "SA@uts.com", 0411122324, "Cabarita 578");
		customerRepo.save(customer);

		customer = new Customer(105, "Philipp", "Lenard", "PL@uts.com", 0411124353, "Daceyville 320");
		customerRepo.save(customer);

		customer = new Customer(106, "Eduard", "Buchner", "EB@uts.com", 0411122000, "Eagle Vale 320");
		customerRepo.save(customer);

		customer = new Customer(107, "Wilhelm", "Ostwald", "WO@uts.com", 041111111, "Eveleigh 320");
		customerRepo.save(customer);

		customer = new Customer(108, "Otto", "Wallach", "OW@uts.com", 0411112345, "Fairfield 165");
		customerRepo.save(customer);

		customer = new Customer(109, "Alexis", "Carrel", "AC@uts.com", 041154321, "Freshwater 320");
		customerRepo.save(customer);

		customer = new Customer(110, "Elihu", "Root", "ER@uts.com", 041165432, "Jordan Springs 543");
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
