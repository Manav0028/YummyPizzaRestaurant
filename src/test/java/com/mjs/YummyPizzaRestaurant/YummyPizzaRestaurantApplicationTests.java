package com.mjs.YummyPizzaRestaurant;

import com.mjs.YummyPizzaRestaurant.model.CustomerOrder;
import com.mjs.YummyPizzaRestaurant.model.OrderItem;
import com.mjs.YummyPizzaRestaurant.model.enums.OrderType;
import com.mjs.YummyPizzaRestaurant.repo.OrderRepo;
import com.mjs.YummyPizzaRestaurant.service.OrderServices;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.*;

@SpringBootTest
class YummyPizzaRestaurantApplicationTests {

	OrderServices orderServices;

	@Autowired
	private OrderRepo orderRepo;

	@Test
	void OrderData() {
		CustomerOrder order = new CustomerOrder();
		order = new CustomerOrder();
		order.setCustomerId(1);
		order.setOrderDate(new Date());
		order.setOrderType(OrderType.counterOrder.getDescription());
		order.setTotalAmount(123.4);
		order.setEatingOption("Dine In");
		order.setDiscountType("Student");


		Set<OrderItem> items = new HashSet<>();

		items.add(new OrderItem(1,1,22.1));
		items.add(new OrderItem(2,1,43.1));
		items.add(new OrderItem(3,1,25.1));
		items.add(new OrderItem(4,1,6.1));

		for (OrderItem i :
				items) {
			i.setCustomerOrder(order);
		}
		order.setOrderItems(items);




		CustomerOrder savedOrder = orderServices.saveOrder(order);

		Assert.isTrue(order.getCustomerId() == savedOrder.getCustomerId(),
				"Same customer, order id: " + savedOrder.getOrderId());

	}

	@BeforeEach
	void setUp() {
		orderServices = new OrderServices();
	}

	@AfterEach
	void tearDown() {
		orderServices.deleteAll();
	}
}
