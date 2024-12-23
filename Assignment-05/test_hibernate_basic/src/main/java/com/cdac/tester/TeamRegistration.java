package com.cdac.tester;


import org.hibernate.SessionFactory;

import com.cdac.dao.TeamDao;
import com.cdac.dao.TeamDaoimpl;
import com.cdac.entities.Team;

import com.cdac.utils.HibernateUtils;
import static com.cdac.utils.HibernateUtils.getSessionFactory;

import java.time.LocalDate;
import java.util.Scanner;

public class TeamRegistration {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try (SessionFactory sf = getSessionFactory();
				Scanner sc=new Scanner(System.in)) {
			//create user dao instance
			TeamDao teamDao=new TeamDaoimpl();
			System.out.println("Enter user details - String Name,  String abbreviation, String owner, Integer max_player_age, "
					+ ", Double batting_avg" 
					+ "Wicket	");
		Team newTeam=new Team(sc.next(), sc.next(), sc.next(), sc.nextInt(),sc.nextDouble(), sc.nextDouble());
		System.out.println(teamDao.signUpTeam(newTeam));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
