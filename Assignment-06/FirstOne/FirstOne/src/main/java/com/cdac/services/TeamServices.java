package com.cdac.services;

import java.util.List;

import com.cdac.entities.Team;

public interface TeamServices {
	List<Team> getAllTeams();
	String addNewTeam(Team team);
}
