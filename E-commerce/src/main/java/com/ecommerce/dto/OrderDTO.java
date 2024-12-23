package com.ecommerce.dto;

import com.ecommerce.pojos.Products;
import com.ecommerce.pojos.User;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDTO extends BaseDTO {
	
	private int pQuantity;

	private double total_price;

}
