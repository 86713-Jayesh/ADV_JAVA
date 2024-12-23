package com.cdac.tester;

import static com.cdac.utils.HibernateUtils.getSessionFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.cdac.dao.TeamDao;
import com.cdac.dao.TeamDaoimpl;



public class DeleteTeamDetail {
	public static void main(String[] args) {
		try (SessionFactory sf = getSessionFactory();
				Scanner sc=new Scanner(System.in)) {
			//create user dao instance
			TeamDao teamDao=new TeamDaoimpl();
			System.out.println("Enter user id to un delete");			
			System.out.println(teamDao.deleteTeamDetail(sc.nextLong()));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
