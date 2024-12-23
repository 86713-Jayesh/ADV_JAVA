package com.ecommerce.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseDTO {
	
	private Long id;
	private LocalDate createdOn;
	private LocalDate updatedOn;

}
