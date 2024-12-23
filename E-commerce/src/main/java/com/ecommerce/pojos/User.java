package com.ecommerce.pojos;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User extends BaseEntity {
	
	@Column(name = "first_name",length = 30)
	private String firstName;
	@Column(name = "last_name",length = 30)
	private String lastName;
	@Column(name = "email",length = 30)
	private String email;
	@Column(name = "password",length = 30)
	private String password;
	@Column(name = "dob",length = 30)
	private LocalDate dob;
	@Column(name = "role",length = 30)
	@Enumerated(EnumType.STRING)
	private UserRole role;
}


/*
Scenario - Placing an order in eCommerce (a small part of eCommerce)
Entities - user(admin|customer) , products , orders
Identify the associations correctly.
*/