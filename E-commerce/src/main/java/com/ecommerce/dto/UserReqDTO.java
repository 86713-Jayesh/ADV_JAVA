package com.ecommerce.dto;

import java.time.LocalDate;

import com.ecommerce.pojos.UserRole;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserReqDTO {
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private LocalDate dob;
	private UserRole role;
}
