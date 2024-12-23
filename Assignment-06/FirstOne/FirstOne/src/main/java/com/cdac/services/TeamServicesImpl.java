package com.cdac.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.blogs.pojos.Category;
import com.cdac.dao.TeamDao;
import com.cdac.entities.Team;

@Service
@Transactional
public class TeamServicesImpl implements TeamServices {
	@Autowired
	private TeamDao teamdao;
	
	@Override
	public List<Team> getAllTeams() {	
		return teamdao.findAll();
	}

	
	@Override
	public String addNewTeam(Team team) {
		Team persistentTeam = teamdao.save(team);
		return "Added new Team with ID="+persistentTeam.getId();
	}

}
