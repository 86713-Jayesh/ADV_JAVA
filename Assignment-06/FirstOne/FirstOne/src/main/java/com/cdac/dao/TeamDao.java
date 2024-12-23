package com.cdac.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cdac.entities.Team;



public interface TeamDao extends JpaRepository<Team, Long> {
   
}
