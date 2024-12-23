package com.ecommerce.service;

import com.ecommerce.dto.ApiResponse;
import com.ecommerce.dto.UserReqDTO;

public interface UserService {
	
	public ApiResponse addUser(UserReqDTO dto);


}
