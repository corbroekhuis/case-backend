package org.eijsink;

import org.eijsink.model.*;
import org.eijsink.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDate;

@SpringBootApplication
public class BackendApplication implements CommandLineRunner {

	private static ApplicationContext applicationContext;
	@Value("${server.port}")
	String port;

	@Autowired
	OberRepository oberRepository;
	@Autowired
	MainOrderRepository mainOrderRepository;
	@Autowired
	OrderRoundRepository orderRoundRepository;
	@Autowired
	OrderRoundItemRepository orderRoundItemRepository;
	@Autowired
	ItemRepository itemRepository;
	@Autowired
	PaymentRepository paymentRepository;

	public static void main(String[] args) {

		applicationContext = SpringApplication.run(BackendApplication.class, args);
		displayAllBeans();
	}
	public static void displayAllBeans() {
		String[] allBeanNames = applicationContext.getBeanDefinitionNames();
		for(String beanName : allBeanNames) {
			System.out.println(beanName);
		}
	}
	@Override
	public void run(String... args) throws Exception {

		Ober ober = new Ober("E0000021", "Hanna van Schenk", LocalDate.of(2002, 5, 22));
		oberRepository.save(ober);

		MainOrder mainOrder = new MainOrder("", LocalDate.now(), ober);
		OrderRound orderRound = new OrderRound();

		Item item = new Item("B000123", "Pale Ale", 3.90);
		itemRepository.save( item);

		OrderRoundItem orderRoundItem = new OrderRoundItem( item, 4);
		orderRoundItemRepository.save( orderRoundItem);

		orderRound.addOrderRoundItem(orderRoundItem);
		orderRoundRepository.save( orderRound);

		mainOrder.addOrderRound( orderRound);

		Payment payment = new Payment(30.00, Payment.PAYMENT_TYPE.CARD);
		paymentRepository.save( payment);
		mainOrder.addPayment( payment);

		mainOrderRepository.save( mainOrder);

		System.out.println("http://localhost:" + port + "/swagger-ui/index.html");
		System.out.println("http://localhost:" + port + "/h2-console");

	}
}
