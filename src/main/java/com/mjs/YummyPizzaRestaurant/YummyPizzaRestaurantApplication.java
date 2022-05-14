package com.mjs.YummyPizzaRestaurant;

import com.mjs.YummyPizzaRestaurant.gui.HomeUI;
import com.mjs.YummyPizzaRestaurant.gui.PizzaMenu;
import com.mjs.YummyPizzaRestaurant.model.CustomerOrder;
import com.mjs.YummyPizzaRestaurant.model.Topping;
import com.mjs.YummyPizzaRestaurant.repo.*;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

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

	public static void main(String[] args) {
//		SpringApplication.run(YummyPizzaRestaurantApplication.class, args);
		SpringApplicationBuilder builder = new SpringApplicationBuilder(YummyPizzaRestaurantApplication.class);
		builder.headless(false).run(args);
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		new HomeUI(menuRepo, toppingRepo, orderRepo);
	}
}
