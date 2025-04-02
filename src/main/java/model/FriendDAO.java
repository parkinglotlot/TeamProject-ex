package model;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import vodto.Friend;
import vodto.FriendDTO;

public interface FriendDAO {

	// 친구 이름으로 검색
		List<Friend> selectFriendByName(String searchName) throws NamingException, SQLException;
}
