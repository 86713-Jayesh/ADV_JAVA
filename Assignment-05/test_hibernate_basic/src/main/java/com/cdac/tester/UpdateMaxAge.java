package com.cdac.tester;

import static com.cdac.utils.HibernateUtils.getSessionFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.cdac.dao.TeamDao;
import com.cdac.dao.TeamDaoimpl;


public class UpdateMaxAge {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try (SessionFactory sf = getSessionFactory(); Scanner sc = new Scanner(System.in)) {
			// create user dao instance
			TeamDao teamDao = new TeamDaoimpl();
			System.out.println("Enter ipl team name and updated age");
			System.out.println(teamDao.
					UpdateAgeMaxTeam(sc.next(), sc.nextInt()));
		} catch (Exception e) {
			e.printStackTrace();
		}

	

	}

}
