package com.ecommerce.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductRespDTO extends BaseDTO{
	
	private String pName;
	private Double pPrice;
	private String pDescription;

}
