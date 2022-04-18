package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ListDAO;


@WebServlet("/bbs/notice_delete")
public class NoticeDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public NoticeDelete() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int uid = Integer.parseInt(request.getParameter("uid"));
		
		ListDAO dao = new ListDAO();
		dao.deleteNotice(uid);
		
		response.sendRedirect("/bbs/list");
	}

}
