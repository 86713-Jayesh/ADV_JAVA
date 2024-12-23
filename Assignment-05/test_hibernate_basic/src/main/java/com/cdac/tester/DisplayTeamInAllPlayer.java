package com.cdac.tester;

import static com.cdac.utils.HibernateUtils.getSessionFactory;

import java.util.List;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.cdac.dao.TeamDao;
import com.cdac.dao.TeamDaoimpl;
import com.cdac.entities.Player;
import com.cdac.entities.Team;



public class DisplayTeamInAllPlayer {
	public static void main(String[] args) {
		try (SessionFactory sf = getSessionFactory(); Scanner sc = new Scanner(System.in)) {
			// create category dao instance
			TeamDao dao = new TeamDaoimpl();
			System.out.println("Enter team Id");
			//Long team_id=sc.nextLong();
			Team team = dao.getPlayerDetails(sc.nextLong());
			
			System.out.println(team.getName());
			
			System.out.println("All Player details ");
			List<Player> player=null;
			player = team.getPlayers();
			//team.getPlayers().forEach(System.out::println);
			System.out.println(player);
		} // JVM : sc.close() , sf.close() -> DBCP will be cleaned up !
		catch (Exception e) {
			e.printStackTrace();
		}

	}
}
