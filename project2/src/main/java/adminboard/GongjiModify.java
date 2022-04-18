package adminboard;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AdminBoardDAO;
import model.Notice;


@WebServlet("/admin/board/modify")
public class GongjiModify extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public GongjiModify() {
        super();

    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int uid = Integer.parseInt(request.getParameter("uid"));
		
		AdminBoardDAO dao = new AdminBoardDAO();
		Notice n = dao.selectNotice(uid);
		
		request.setAttribute("l", n);
		RequestDispatcher dis = request.getRequestDispatcher("/admin/board/modify.jsp");
		dis.forward(request, response);
	}

}
