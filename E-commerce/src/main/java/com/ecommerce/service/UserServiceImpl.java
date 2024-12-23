package com.ecommerce.service;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.dao.UserDao;
import com.ecommerce.dto.ApiResponse;
import com.ecommerce.dto.UserReqDTO;
import com.ecommerce.pojos.User;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private UserDao udao;
	

	@Override
	public ApiResponse addUser(UserReqDTO dto) {

		try {
			
			User user=mapper.map(dto, User.class);
			udao.save(user);
			return new ApiResponse("user added with id " + user.getId());
			
		} catch (Exception e) {
			
			return new ApiResponse("user addition failed ");
			
		}
		
	}
	

}
