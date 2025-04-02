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
	public int insertFriend(FriendDTO friendDTO) throws NamingException, SQLException {
		
		int result = 0;
		
		Connection con = DBConn.getConnection();
		
		if (con != null) {
			String query = "insert into friends(friendName, mobile, addr) "
					+ "values(?, ?, ?)";
			
			PreparedStatement pstmt = con.prepareStatement(query);
			
			// 매개변수 세팅
			pstmt.setString(1, friendDTO.getFriendName());
			pstmt.setString(2, friendDTO.getMobile());
			pstmt.setString(3, friendDTO.getAddr());
			
			// 실행
			result = pstmt.executeUpdate();
			
			DBConn.closeDB(pstmt, con);
		}
		
		return result;
	}
}
