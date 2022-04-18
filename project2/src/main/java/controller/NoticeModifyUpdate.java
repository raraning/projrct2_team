package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ListDAO;
import model.List;


@WebServlet("/bbs/notice_update")
public class NoticeModifyUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public NoticeModifyUpdate() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		List l = new List();
		
		l.setSubject(request.getParameter("subject"));
		l.setComment(request.getParameter("comment"));
		l.setGongji(request.getParameter("gongji"));
		l.setUid(Integer.parseInt(request.getParameter("uid")));
		
		ListDAO dao = new ListDAO();
		dao.updateNotice(l);
		
		response.sendRedirect("/bbs/list");
	}

}
