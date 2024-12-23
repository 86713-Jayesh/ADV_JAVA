package com.ecommerce.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.dao.ProductsDao;
import com.ecommerce.dao.UserDao;
import com.ecommerce.dto.ApiResponse;
import com.ecommerce.dto.ProductDTO;
import com.ecommerce.dto.ProductRespDTO;
import com.ecommerce.exceptions.ResourceNotFoundException;
import com.ecommerce.pojos.Products;
import com.ecommerce.pojos.User;
import com.ecommerce.pojos.UserRole;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductsDao pdao;
	@Autowired
	private UserDao udao;
	@Autowired
	private ModelMapper mapper;

	@Override
	public ApiResponse addNewProduct(ProductDTO product, Long adminId) {

		User admin = udao.findById(adminId)
				.orElseThrow(() -> new ResourceNotFoundException("resource not found exception"));

		if (admin.getRole() == UserRole.ADMIN) {

			Products p = new Products();
			p.setPName(product.getPName());
			p.setPPrice(product.getPPrice());
			p.setPDescription(product.getPDescription());
			p.setStatus(true);

			pdao.save(p);

			return new ApiResponse("product added succesfully");

		}
		return new ApiResponse("product addition failed");
	}

	@Override
	public ApiResponse deleteProduct(Long userId, Long productId) {

		User user = udao.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("resource not found exception"));
		
		Products product=pdao.findById(productId).orElseThrow(()-> new ResourceNotFoundException("resource not found"));

		if (user.getRole().equals(UserRole.ADMIN)) {
			if (pdao.existsById(productId)) {

//				pdao.deleteById(productId);
				product.setStatus(false);
				
				return new ApiResponse("product with ID deleted");

			}
			
			return new ApiResponse("product not found");
			
		}

		return new ApiResponse("product  deletion failed user not valid");
	}
	
	

	@Override
	public List<ProductRespDTO> getAllProducts() {
		
		
		return pdao.findAll()
				.stream()
				.filter(product -> product.isStatus())
				.map(product -> mapper.map(product, ProductRespDTO.class))
				.collect(Collectors.toList());
		}

}
