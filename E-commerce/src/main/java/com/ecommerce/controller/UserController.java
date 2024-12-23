package com.ecommerce.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.dto.ApiResponse;
import com.ecommerce.dto.UserReqDTO;
import com.ecommerce.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService uservice;
	

	@PostMapping("/")
	public ResponseEntity<?> addUser(@RequestBody UserReqDTO dto) {
		//TODO: process POST request
		
		try {
			return ResponseEntity.status(HttpStatus.OK).body(uservice.addUser(dto));
			
		} catch (Exception e) {
			
			return ResponseEntity.status(HttpStatus.FAILED_DEPENDENCY).body(new ApiResponse("user addition failed"));
		}
		
	
	}
	
	
	
	
	

}
