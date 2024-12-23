package com.ecommerce.service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.dao.OrdersDao;
import com.ecommerce.dao.ProductsDao;
import com.ecommerce.dao.UserDao;
import com.ecommerce.dto.ApiResponse;
import com.ecommerce.dto.OrderDTO;
import com.ecommerce.dto.ProductDTO;
import com.ecommerce.dto.ProductRespDTO;
import com.ecommerce.exceptions.ResourceNotFoundException;
import com.ecommerce.pojos.Orders;
import com.ecommerce.pojos.Products;
import com.ecommerce.pojos.User;
import com.ecommerce.pojos.UserRole;

import jakarta.persistence.criteria.Order;
import jakarta.transaction.Transactional;


@Service
@Transactional
public class OrderServiceImpl  implements OrderService{
	
	@Autowired
	private ProductsDao pdao;
	@Autowired
	private UserDao udao;
	@Autowired
	private OrdersDao odao;
	@Autowired
	private ModelMapper mapper;
	

	@Override
	public OrderDTO placeOrder(Long CustomerId, Long ProductId, int quantity) {
		
		User user=udao.findById(CustomerId).orElseThrow(()-> new ResourceNotFoundException("resource not found "));
		
		OrderDTO map=null;
		Products products=pdao.findById(ProductId).orElseThrow(()-> new ResourceNotFoundException("resource not found "));
		
		Double total_price=quantity*products.getPPrice();
		
		if(user.getRole().equals(UserRole.CUSTOMER))
		{
			if(products!=null)
			{
				Orders order=new Orders();
				order.setProduct(products);
				order.setUser(user);
				order.setPQuantity(quantity);
				order.setTotal_price(total_price);
				
				odao.save(order);
				
				 map = mapper.map(order, OrderDTO.class);	
			}
			
		}
		
       return map;
	}


	@Override
	public List<OrderDTO> getAllOrdersWithinPeriod(LocalDate startDate, LocalDate endDate, Long userId) {
		
		User user=udao.findById(userId).orElseThrow(()-> new ResourceNotFoundException("no user found"));
		
		if(user.getRole().equals(UserRole.ADMIN))
		{
				
			return odao.findOrdersWithinPeriod(startDate, endDate).stream()
					.map(order -> mapper.map(order, OrderDTO.class))
					.collect(Collectors.toList());
		}
		else
		{
			throw new ResourceNotFoundException("onnly admin can see all the orders within specefic period");
		}
	}
}
