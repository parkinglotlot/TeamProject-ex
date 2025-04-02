package model;

import java.nio.channels.ClosedByInterruptException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import vodto.Friend;
import vodto.FriendDTO;

public class FriendDAOImpl implements FriendDAO {

	private static FriendDAOImpl instance = null;
	
	private FriendDAOImpl() { }
	
	public static FriendDAOImpl getInstance() {
		if (instance == null) {
			instance = new FriendDAOImpl();
		}
		return instance;
	}
	
	
	@Override
	public List<Friend> selectFriendByName(String searchName) throws NamingException, SQLException {

		List<Friend> result = new ArrayList<>();

		Connection con = DBConn.getConnection();

		if (con != null) {

			String query = "select * from Friends where FriendName like ?";

			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, "%" + searchName + "%");

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				result.add(new Friend(rs.getInt("FriendNo"), rs.getString("FriendName"), rs.getString("Mobile"),
						rs.getString("Addr")));
			}
			DBConn.closeDB(rs, pstmt, con);;
		}

		return result;
	}

	
}
