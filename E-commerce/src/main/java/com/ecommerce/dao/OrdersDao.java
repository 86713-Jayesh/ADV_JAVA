package com.ecommerce.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ecommerce.pojos.Orders;

public interface OrdersDao extends JpaRepository<Orders, Long>{
	
@Query("SELECT o FROM Orders o WHERE o.createdOn BETWEEN :startDate AND :endDate")
List<Orders> findOrdersWithinPeriod(@Param("startDate") LocalDate startDate,@Param("endDate") LocalDate endDate);
	
}
