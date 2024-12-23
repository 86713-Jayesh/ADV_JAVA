package com.cdac.dao;

import java.time.LocalDate;
import java.util.List;

import com.cdac.entities.Team;
import com.cdac.entities.Team;

import com.cdac.entities.Team;

public interface TeamDao {
	String signUpTeam(Team team);
	List<Team> getAllTeams();
	
	List<Team> getSelectedTeams(int age, double batting);
	List<Team> getTeams(int age, double batting);
	Team getPlayerDetails(long id);
	String UpdateAgeMaxTeam(String next, int age);
	String deleteTeamDetail(long nextLong);
	
}
