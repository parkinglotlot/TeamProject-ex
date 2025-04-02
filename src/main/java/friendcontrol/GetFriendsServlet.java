package friendcontrol;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.FriendDAO;
import model.FriendDAOImpl;
import vodto.Friend;

@WebServlet("/getFriend.do")
public class GetFriendsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GetFriendsServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("GET 호출");
		
		FriendDAO dao = FriendDAOImpl.getInstance();
		
		try {
			List<Friend> result = dao.selectFriends();
			
			for(Friend f : result) {
				System.out.println(f);
			}
			
			request.setAttribute("friendList", result); // result(친구목록)
			RequestDispatcher rd = request.getRequestDispatcher("./friend/viewFriends.jsp");
			
			rd.forward(request, response);
			
		} catch (NamingException | SQLException e) {
			e.printStackTrace();
		}
	}

}
