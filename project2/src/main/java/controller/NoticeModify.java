package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ListDAO;
import model.List;


@WebServlet("/bbs/notice_modify")
public class NoticeModify extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public NoticeModify() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		int uid = Integer.parseInt(request.getParameter("uid"));
		
		ListDAO dao = new ListDAO();
		List l = dao.oneNoticeModify(uid);
		
		request.setAttribute("list",l);
		RequestDispatcher dis = request.getRequestDispatcher("notice_modify.jsp");
		dis.forward(request, response);
	}

}
