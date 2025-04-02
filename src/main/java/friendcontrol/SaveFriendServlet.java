package friendcontrol;

import java.io.IOException;
import java.sql.SQLException;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.FriendDAO;
import model.FriendDAOImpl;
import vodto.FriendDTO;

@WebServlet("/save.do")
public class SaveFriendServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SaveFriendServlet() {
        super();
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("친구 저장 post 요청됨");
		
		FriendDTO newFriend = new FriendDTO(
				request.getParameter("friendName"), 
				request.getParameter("mobile"), 
				request.getParameter("addr"));
		
		System.out.println("dto : " + newFriend);
		
		FriendDAO dao = FriendDAOImpl.getInstance();
		
		try {
			int result = dao.insertFriend(newFriend);
			
			if (result == 1) {
				// 저장 성공
				response.sendRedirect(request.getContextPath() + "/getFriend.do?isSave=true");
			}
		} catch (NamingException | SQLException e) {
			e.printStackTrace();
			response.sendRedirect(request.getContextPath() + "/getFriend.do?isSave=false");
		}
		
	}

}
