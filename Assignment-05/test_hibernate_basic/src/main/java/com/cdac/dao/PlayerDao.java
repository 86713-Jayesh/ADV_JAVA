package com.cdac.dao;

import com.cdac.entities.Player;

public interface PlayerDao {
	String addNewPlayer(Long teamId, Player player);
}
