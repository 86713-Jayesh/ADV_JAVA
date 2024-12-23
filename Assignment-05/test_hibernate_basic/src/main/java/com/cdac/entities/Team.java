package com.cdac.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Entity // mandatory cls level annoatation

@NoArgsConstructor
@Getter
@Setter

//import org.hibernate.type.BigIntegerType;
@AllArgsConstructor

@Table(name = "ipl_team") //to customize table name
@ToString(callSuper = true, exclude = "players")
public class Team extends BaseEntity{
   
	@Column(length = 100,  unique = true)//varchar(100)
	private String name;
	@Column(length = 10, unique = true)
	private String abbreviation;
	@Column(length = 20, nullable = false)
	private String owner;
	@Column(name="max_player")
	private Integer maxPlayer;
	@Column(name="batting_avg")
	private Double battingAvg;
	@Column(name="wickets_taken")
	private Double wicket;
	
	
	@OneToMany(mappedBy = "team", cascade = CascadeType.ALL)
	List<Player> players = new ArrayList<Player>();
	
	
	public void addNewPlayer(Player player) {
		this.players.add(player);
		player.setTeam(this);
	}


	public Team(String name, String abbreviation, String owner, Integer maxPlayer, Double battingAvg, Double wicket) {
		super();
		this.name = name;
		this.abbreviation = abbreviation;
		this.owner = owner;
		this.maxPlayer = maxPlayer;
		this.battingAvg = battingAvg;
		this.wicket = wicket;
	}
	
	
	
	
	
}
