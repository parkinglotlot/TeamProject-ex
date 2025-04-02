package model;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import vodto.Friend;
import vodto.FriendDTO;

public interface FriendDAO {
	// 친구 저장
		int insertFriend(FriendDTO friendDTO) throws NamingException, SQLException;
	
}
