package com.cdac.dao;

import java.time.LocalDate;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.cdac.entities.Player;
import com.cdac.entities.Team;

import static com.cdac.utils.HibernateUtils.getSessionFactory;
public class PlayerDaoImpl implements PlayerDao{
	@Override
	public String addNewPlayer(Long teamId, Player player) {
		String mesg = "adding player failed !";
		// 1. get session from SF (getCurrentSession)
		Session session = getSessionFactory().getCurrentSession();
		// 2. Begin a Tx
		Transaction tx = session.beginTransaction();
		try {
			Team team = session.get(Team.class, teamId);
			
			
			//mesg = "added new player with id=" + player.teamId();
		
			//Object team;
			if (team != null)
			team.addNewPlayer(player);
			session.persist(player);
			tx.commit();
			mesg = "Adding Player Sucess";
		}
		catch(RuntimeException e) {
			if(tx != null)
				tx.rollback();
			throw e;
		}
			// re throw the exc to the caller
		return mesg;
	}		
}