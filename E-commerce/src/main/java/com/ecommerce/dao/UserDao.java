package com.ecommerce.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.pojos.User;

public interface UserDao extends JpaRepository<User, Long>{

}
