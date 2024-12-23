package com.ecommerce.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ecommerce.dto.ProductRespDTO;

@SpringBootTest
public class ProductServiceTest {
	
	@Autowired
	private ProductService pservice;
	
	@Test
	void testGetAllProducts()
	{
		List<ProductRespDTO> pdto=pservice.getAllProducts();
		
		assertEquals(2, pdto.size());		
	}
	
	

}

/*
 * package com.blogs.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.blogs.dto.AddressDTO;
import com.blogs.dto.ApiResponse;


@SpringBootTest// to tell the spring boot test container to scan all spring beans controllers,service , DAO n entities
class AddressServiceTest {

	@Autowired
	private AddressService addressService;
	
	@Test
	void testAssignAddress() {
		
		AddressDTO dto = new AddressDTO("line12","line22","pune","MH","India","413102");
		ApiResponse resp=addressService.assignAddress(dto,2l);
		assertEquals(true,resp.getMessage().contains("Assigned"));
		
		//more rigirous Testing

		

	}

}
*/
 