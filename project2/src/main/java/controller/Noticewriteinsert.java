package controller;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ListDAO;
import model.List;


@WebServlet("/bbs/notice_write_insert")
public class Noticewriteinsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public Noticewriteinsert() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		//String id = (String)session.getAttribute("id");
		//String name = (String)session.getAttribute("name");
		
		request.setCharacterEncoding("utf-8");
		
		//현재 시간
		java.util.Date nowTime = new java.util.Date();
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String today = sf.format(nowTime);
		
		List l = new List();
		
		//l.setName(name);
		//l.setId(id);
		l.setId((String)session.getAttribute("id"));
		l.setName((String)session.getAttribute("name"));
		l.setSubject(request.getParameter("subject"));
		l.setComment(request.getParameter("comment"));
		l.setGongji(request.getParameter("gongji"));
		l.setSigndate(today);
		
		ListDAO dao = new ListDAO();
		dao.insertNotice(l); //게시글 등록 완료
		//System.out.println(l.toString());
		//게시판 리스트로 보내자
		response.sendRedirect("list");
	}

}
