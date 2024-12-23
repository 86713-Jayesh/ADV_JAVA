package com.cdac.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "Team_Details")
@NoArgsConstructor
@Getter
@Setter
@ToString 
public class Team extends BaseEntity {
    @Column(length = 100, unique = true, nullable = false)
    private String name;

    @Column(length = 10, unique = true, nullable = false)
    private String abbreviation;

    @Column(length = 20, nullable = false)
    private String owner;

    @Column(name = "max_player_age")
    private int maxPlayerAge;

    @Column(name = "batting_avg")
    private double battingAvg;

    @Column(name = "wickets_taken")
    private int wicketsTaken;


    public Team(String name, String abbreviation, String owner, int maxPlayerAge, double battingAvg,
                int wicketsTaken) {
        this.name = name;
        this.abbreviation = abbreviation;
        this.owner = owner;
        this.maxPlayerAge = maxPlayerAge;
        this.battingAvg = battingAvg;
        this.wicketsTaken = wicketsTaken;
    }

    public Team(String owner, String abbreviation) {
        this.abbreviation = abbreviation;
        this.owner = owner;
    }


}
