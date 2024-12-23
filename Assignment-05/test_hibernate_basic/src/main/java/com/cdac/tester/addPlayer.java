package com.cdac.tester;

import java.time.LocalDate;
import java.util.Scanner;
import static com.cdac.utils.HibernateUtils.getSessionFactory;
import org.hibernate.SessionFactory;

import com.cdac.dao.PlayerDao;
import com.cdac.dao.PlayerDaoImpl;
import com.cdac.entities.Player;
import com.cdac.entities.Team;

public class addPlayer {
	public static void main(String[] args) {

		try (SessionFactory sf = getSessionFactory(); Scanner sc = new Scanner(System.in)) {
			// create dao instance
			PlayerDao playerDao = new PlayerDaoImpl();
			
			System.out.println("Enter player  first name ");
			String first_name=sc.nextLine();
			System.out.println("Enter player  last name ");
			String last_name=sc.nextLine();
			System.out.println("Enter DOB");
			//LocalDate.parse(sc.next());
			LocalDate dob=LocalDate.parse(sc.next());
			System.out.println("Enter batting average");
			Double batting_avg=sc.nextDouble();
			System.out.println("Enter wickets_taken");
			Integer wickets_avg=sc.nextInt();
			System.out.println("Enter team id");
			Long teamId=sc.nextLong();
			Player player=new Player(first_name,last_name,dob,batting_avg,wickets_avg);
			
			System.out.println(playerDao.addNewPlayer(teamId, player));
		} // JVM - sf.close() => DBCP is cleaned up !
		catch (Exception e) {
			e.printStackTrace();
		}

	}
}
