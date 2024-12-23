package com.ecommerce.service;

import java.util.List;

import com.ecommerce.dto.ApiResponse;
import com.ecommerce.dto.ProductDTO;
import com.ecommerce.dto.ProductRespDTO;

public interface ProductService {
	
	ApiResponse addNewProduct(ProductDTO product,Long adminId);
	ApiResponse deleteProduct(Long userId,Long productId);
	List<ProductRespDTO> getAllProducts();
	

}
