package com.mjs.YummyPizzaRestaurant;

import com.mjs.YummyPizzaRestaurant.gui.HomeUI;
import com.mjs.YummyPizzaRestaurant.model.JobVacancy;
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
	private JobVacancyRepo vacancies;


	private void setupJobVacancies() {
		JobVacancy vacancy ;

		vacancy = new JobVacancy(123, "Kitchen Staff", "Prepares food for customers", 2, null);
		vacancies.save(vacancy);

		vacancy = new JobVacancy(124, "Host", "Interacting with customers directly and provide excellent service.", 2, null);
		vacancies.save(vacancy);

	}
	public static void main(String[] args) {
//		SpringApplication.run(YummyPizzaRestaurantApplication.class, args);
		SpringApplicationBuilder builder = new SpringApplicationBuilder(YummyPizzaRestaurantApplication.class);
		builder.headless(false).run(args);
	}



	@Override
	public void afterPropertiesSet() throws Exception {

		setupJobVacancies();
		new HomeUI(menuRepo, toppingRepo, orderRepo, vacancies);
	}
}
