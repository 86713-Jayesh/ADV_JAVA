package com.ecommerce.controller;

import java.time.LocalDate;
import java.util.List;

import javax.imageio.spi.IIOServiceProvider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.dto.ApiResponse;
import com.ecommerce.dto.OrderDTO;
import com.ecommerce.service.OrderService;

import jakarta.validation.constraints.Positive;


@RestController
@RequestMapping("/orders")
public class OrderController {
	
	@Autowired
	private OrderService oservice;
	
	
	@PostMapping
	public ResponseEntity<?> placeOrder(Long customerId,Long productid,int quantity)
	{
		try {
			return ResponseEntity.status(HttpStatus.OK).body(oservice.placeOrder(customerId, productid, quantity));
			
		} catch (Exception e) {
			
			return ResponseEntity.status(HttpStatus.FAILED_DEPENDENCY).body(new ApiResponse(e.getMessage()));
		}
		
	}
	
	@GetMapping("/{userId}/{startDate}/{endDate}")
	public ResponseEntity<?> getOrdersWithinPeriod(@PathVariable LocalDate startDate ,@PathVariable LocalDate endDate,@PathVariable Long userId) {
		
		
		
			List<OrderDTO> orderList=oservice.getAllOrdersWithinPeriod(startDate, endDate, userId);
			
			if(orderList.isEmpty())
			{
				return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
				
			}
			return ResponseEntity.ok(orderList);
			
	}
	

}
