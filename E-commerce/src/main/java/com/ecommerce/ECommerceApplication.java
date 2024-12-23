package com.ecommerce;

import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ECommerceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ECommerceApplication.class, args);
	}
	
	// configure ModelMapper as a spring bean - so that any other
	// spring bean can use it as a dependency
	@Bean
	public ModelMapper modelMapper() {
		ModelMapper mapper = new ModelMapper(); // creating empty model mapper
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT)// prop names n data type must match
																				// between src n dest
				.setPropertyCondition(Conditions.isNotNull());// DO NOT transfer nulls from src ->dest
		return mapper;
	}

}


/*
 * Requirements
1. Admin should be able to add a product
2. Admin should be able to delete product (soft delete)
3. Customer should be able to view all available products.
4. Customer should be able to place order for a specific product.
i/p - customer id , product id  , quantity
o/p - in case of success - order should be placed n customer should be able to see the order details
including total order amount.
if the quantity is in sufficient - give suitable error message.

5. Admin should be able to check all the orders placed within a specific period
i/p - start date n end date

6. Write unit test case for 
6.1 Check all the orders placed within a specific period
i/p - start date n end date

7. Write integration (service-DAO-Entitiy-DB) test for 
Placing order
*/
 