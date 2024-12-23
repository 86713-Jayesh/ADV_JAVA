package com.cdac.dao;

import com.cdac.entities.Team;

import com.cdac.entities.Team;

import org.hibernate.*;


import static com.cdac.utils.HibernateUtils.getSessionFactory;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;





public class TeamDaoimpl implements TeamDao{
	@Override
	public String signUpTeam(Team team) {
		String mesg="User registration failed!!!!!!!!!!";
		// 1. Get Session from SessionFactory
		/*
		 * Method of SessionFactory public Session getCurrentSession() throws
		 * HibernateException
		 */
		Session session = getSessionFactory().getCurrentSession();
		// 2 . Begin a Transaction
		/*
		 * Method of Session 
		 * public Transaction beginTransaction() throws
		 * HibernateException
		 */
		Transaction tx=session.beginTransaction();
		try {
			/*
			 * Session API
			 * public Serializable save(Object transientEntity) throws  HibernateException
			 */
			Serializable userId = session.save(team);
			//=> success
			tx.commit();
			mesg="User signed up ! , ID "+userId;
		} catch (RuntimeException e) {
			// => failure -> rollback the Tx
			if(tx != null)
				tx.rollback();
			//re throw the same exception to the caller
			throw e;
		}
		return mesg;
	}
	
	@Override
	public List<Team> getAllTeams() {
		String jpql = "select u from Team u";
		List<Team> teams = null;
		// 1. get Session from SessionFactory
		Session session = getSessionFactory().getCurrentSession();
		// 2. Begin Tx
		Transaction tx = session.beginTransaction();
		try {
			teams = session.createQuery(jpql, Team.class).getResultList();
			// users - list of persistent entities.
			tx.commit();
		} catch (RuntimeException e) {
			// roll back the tx
			if (tx != null)
				tx.rollback();
			// re throw the same exception to the caller
			throw e;
		}

		return teams;// users - list of deatched entities.
	}
	

	@Override
	public List<Team> getSelectedTeams(int age, double batting) {
		List<Team> teams = null;
		String jpql = "select t from Team t where t.maxPlayer<:max and t.battingAvg >:average ";
		// 1. get Session from SessionFactory
		Session session = getSessionFactory().getCurrentSession();
		// 2. Begin Tx
		Transaction tx = session.beginTransaction();
		try {
			teams = session.createQuery(jpql, Team.class).setParameter("max", age).setParameter("average", batting )
					.getResultList();
			// list of persistent entities
			tx.commit();
		} catch (RuntimeException e) {
			// roll back the tx
			if (tx != null)
				tx.rollback();
			// re throw the same exception to the caller
			throw e;
		}

		return teams;// list of detached entities
	}
	@Override
	public List<Team> getTeams(int age, double batting) {
		List<Team> teams = null;
		String jpql = "select new com.cdac.entities.Team(owner,abbreviation) from Team t where t.maxPlayer<:max and t.battingAvg >:average ";
		// 1. get Session from SessionFactory
		Session session = getSessionFactory().getCurrentSession();
		// 2. Begin Tx
		Transaction tx = session.beginTransaction();
		try {
			teams = session.createQuery(jpql, Team.class).setParameter("max", age).setParameter("average", batting )
					.getResultList();
			// list of persistent entities
			tx.commit();
		} catch (RuntimeException e) {
			// roll back the tx
			if (tx != null)
				tx.rollback();
			// re throw the same exception to the caller
			throw e;
		}

		return teams;// list of detached entities
	}


	@Override
	public Team getPlayerDetails(long teamId) {
		Team team = null;
		//String jpql = "select c from Category c where c.categoryName = :nm";
		//String jpql = "select c from team c left join fetch c.teamID  where c.playerName = :nm";
		
		// 1. get session from SF (getCurrentSession)
		Session session = getSessionFactory().getCurrentSession();
		// 2. Begin a Tx
		Transaction tx = session.beginTransaction();
		try {
			team=session.get(Team.class, teamId);//select - categories
			//category - persistent
			//access un fetched data(proxy) from within session scope , before commit
	//		category.getBlogPosts().size();//select - posts
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			// re throw the exc to the caller
			throw e;
		}
		return team;// detached

	}

	@Override
	public String UpdateAgeMaxTeam(String teamName, int age) {
		// TODO Auto-generated method stub
		String msg = "update failed";
		Team team = null;
		String jpql = "select t from Team t where t.name = :nm";
		//String jpql = "select c from team c left join fetch c.teamID  where c.playerName = :nm";
		
		// 1. get session from SF (getCurrentSession)
		Session session = getSessionFactory().getCurrentSession();
		// 2. Begin a Tx
		Transaction tx = session.beginTransaction();
		try {
			team=session.createQuery(jpql,Team.class)
					.setParameter("nm", teamName)
					.getSingleResult();
			
				team.setMaxPlayer(age);
			
			//select - categories
			//category - persistent
			//access un fetched data(proxy) from within session scope , before commit
	//		category.getBlogPosts().size();//select - posts
			tx.commit();
			msg = "Success";
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			// re throw the exc to the caller
			throw e;
		}
		return msg;
	}
	
	@Override
	public String deleteTeamDetail(long teamId) {
		String mesg="Deletion failed!!!!!!";
		Team team=null;
		// 1. get Session from SessionFactory
		Session session=getSessionFactory().getCurrentSession();
		//2. Begin Tx
		Transaction tx=session.beginTransaction();
		try {
			//get 
			team=session.get(Team.class, teamId);
			if(team != null)
			{
				//user - persistent
				session.delete(team);
				mesg="deleted team details !";
			}
			tx.commit();
		} catch (RuntimeException e) {
			//roll back the tx
			if(tx != null)
				tx.rollback();
			//re throw the same exception to the caller
			throw e;
		}
	
		return mesg;
	}

}
