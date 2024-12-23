package com.ecommerce.pojos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "product")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Products extends BaseEntity {
	
	@Column(name = "name")
	private String pName;
	@Column(name = "price")
	private Double pPrice;
	@Column(name = "description")
	private String pDescription;
	@Column(name = "status")
	private boolean status;

}
