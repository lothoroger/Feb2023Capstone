package com.fds.FoodDelivery;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fds.FoodDelivery.controller.CuisinesController;

@SpringBootTest
class FoodDeliveryApplicationTests {


	
	@Autowired
	CuisinesController cController;
	
	Integer ref;
	@Test
	void contextLoads() {
		assertThat(cController).isNotNull();
		
	
	}

}
