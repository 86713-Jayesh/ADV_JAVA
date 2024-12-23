package com.cdac.entities;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;



@Entity
@Table(name="player")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)

public class Player extends BaseEntity {
	
	@Column(length = 20)//varchar(100)
	private String first_name;
	@Column(length = 20)//varchar(100)
	private String last_name;
	private LocalDate dob;
	private Double batting_avg;
	
	@Column(name="wickets_taken")
	private int wicket;
	
	
	@ManyToOne
	@JoinColumn(name = "team_id")
	Team team;


	public Player(String first_name, String last_name, LocalDate dob, Double batting_avg, int wicket) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.dob = dob;
		this.batting_avg = batting_avg;
		this.wicket = wicket;
	}
	

	
}
