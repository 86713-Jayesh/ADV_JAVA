package com.ecommerce.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ecommerce.dto.OrderDTO;

@SpringBootTest
public class OrderServiceTest {
	
	@Autowired
	private OrderService oservice;

	
	@Test
	void testplaceOrder()
	{
		
		Long customerId=2l;
		Long productId=1l;
		int quantity=4;
		
		OrderDTO dto=oservice.placeOrder(customerId, productId, quantity);
		
		assertNotNull(dto, "dto should not be null");
		assertEquals(4, dto.getPQuantity());
		assertNotNull(dto.getTotal_price(),"total price should not be null");
		
		
	
//		assertEquals(null, null);
		
		
		
	}
}


