package com.ecommerce.service;

import java.time.LocalDate;
import java.util.List;

import com.ecommerce.dto.ApiResponse;
import com.ecommerce.dto.OrderDTO;

public interface OrderService {
	
	OrderDTO placeOrder(Long CustomerId,Long ProductId,int quantity);
	
	List<OrderDTO> getAllOrdersWithinPeriod(LocalDate startDate, LocalDate endDate,Long userId);
	

}
