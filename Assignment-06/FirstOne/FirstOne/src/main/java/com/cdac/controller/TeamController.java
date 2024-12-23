package com.cdac.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.cdac.entities.Team;
import com.cdac.services.TeamServices;

@RestController
@RequestMapping("/getall")
@CrossOrigin(origins = "http://localhost:3000")
public class TeamController {

	@Autowired
	private TeamServices teamservices ;
	
	@GetMapping
	public ResponseEntity<?> getCategories() {
		System.out.println("get all");
		List<Team> teams = teamservices.getAllTeams();
		if (teams.isEmpty())
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		return ResponseEntity.ok(teams);
	}
	
	@PostMapping
	public ResponseEntity<?> addNewteam(@RequestBody 
			Team team) {
		System.out.println("in add team " + team);
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(teamservices.addNewTeam(team));
	}

}

