package com.cdac.tester;

import static com.cdac.utils.HibernateUtils.getSessionFactory;

import java.time.LocalDate;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.cdac.dao.TeamDao;
import com.cdac.dao.TeamDaoimpl;

public class GetAgeTeam {
	public static void main(String[] args) {
		try (SessionFactory sf = getSessionFactory();
				Scanner sc=new Scanner(System.in)) {
			//create user dao instance
			TeamDao teamDao=new TeamDaoimpl();
			System.out.println("Enter user age n batting average");			
			teamDao.getTeams(
					sc.nextInt(), sc.nextDouble()).forEach(System.out::println);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
