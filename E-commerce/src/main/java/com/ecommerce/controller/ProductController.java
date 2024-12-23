package com.ecommerce.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.dto.ApiResponse;
import com.ecommerce.dto.ProductDTO;
import com.ecommerce.dto.ProductRespDTO;
import com.ecommerce.service.ProductService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;




@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductService pservice;
	
	@PostMapping("/add/{adminId}")
	public ResponseEntity<?> addProduct(@RequestBody ProductDTO dto, @PathVariable Long adminId) {
		//TODO: process POST request
		System.out.println("inside add product controller " + dto);
		
		try {
			
			return ResponseEntity.status(HttpStatus.CREATED).body(pservice.addNewProduct(dto, adminId));
			
		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.FAILED_DEPENDENCY).body(new ApiResponse("adding product failed"));
		}
		
	}
	
	@DeleteMapping("/{userId}/{productId}")
	public ResponseEntity<?> deleteProduct(@PathVariable Long userId,@PathVariable Long productId) {
		
		try {
			
			System.out.println("inside delete product  ");
			
			return ResponseEntity.status(HttpStatus.OK).body(pservice.deleteProduct(userId, productId));
			
		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.FAILED_DEPENDENCY).body(e.getMessage());
		}
		
	}
	
	@GetMapping
	public ResponseEntity<?> getAllProducts() {
		
		System.out.println("inside get all products");
		
		List<ProductRespDTO> productList=pservice.getAllProducts();
		
		if(productList.isEmpty())
		{
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		
		return ResponseEntity.ok(productList);
		
	}

	/*
	 * 	@PostMapping
	public ResponseEntity<?> addBlogPost(@RequestBody BlogPostDTO dto)
	{
		System.out.println("in add blog post "+dto);
		try {
			return ResponseEntity.status(HttpStatus.CREATED)
					.body(blogPostService.addBlogPost(dto));
					
		} catch (RuntimeException e) {
			System.out.println(e);
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(new ApiResponse(e.getMessage()));
		}
	}*/

}
