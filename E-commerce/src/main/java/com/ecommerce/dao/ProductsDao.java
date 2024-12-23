package com.ecommerce.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.pojos.Products;

public interface ProductsDao extends JpaRepository<Products, Long>{

}