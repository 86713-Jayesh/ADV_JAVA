package com.ecommerce.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.ecommerce.dao.OrdersDao;
import com.ecommerce.dao.UserDao;
import com.ecommerce.pojos.Orders;

@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
public class OrderDaoTest {
	
	@Autowired
	private UserDao udao;
	@Autowired
	private OrdersDao odao;
	
	@Test
	public void testFindOrdersWithinPeriod()
	{
		
		LocalDate startDate=LocalDate.of(2024,12,12);
		LocalDate endDate=LocalDate.of(2024,12,20);
		List<Orders> orderList=odao.findOrdersWithinPeriod(startDate,endDate);
		
		assertEquals(4, orderList.size());
			
	}
	
}
