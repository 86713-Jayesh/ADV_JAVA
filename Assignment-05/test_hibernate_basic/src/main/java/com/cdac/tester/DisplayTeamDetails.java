package com.cdac.tester;

import static com.cdac.utils.HibernateUtils.getSessionFactory;

import org.hibernate.SessionFactory;

import com.cdac.dao.TeamDao;
import com.cdac.dao.TeamDaoimpl;

public class DisplayTeamDetails {
	public static void main(String[] args) {
		try (SessionFactory sf = getSessionFactory()) {
			// create user dao instance
			TeamDao userDao = new TeamDaoimpl();
			userDao.getAllTeams().forEach(System.out::println);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}


}
