package controller;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.QnaDAO;
import model.Qna;


@WebServlet("/qna/write_insert")
public class QnaWriteInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public QnaWriteInsert() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		Qna q = new Qna();
		
		HttpSession session = request.getSession();
		
		//현재 시간
		java.util.Date nowTime = new java.util.Date();
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String today = sf.format(nowTime);
		
		q.setId((String)session.getAttribute("id"));
		q.setName((String)session.getAttribute("name"));
		q.setGongji(request.getParameter("gongji"));
		q.setSubject(request.getParameter("subject"));
		q.setComment(request.getParameter("comment"));
		q.setSigndate(today);
		
		QnaDAO qdao = new QnaDAO();
		
		qdao.insertBoard(q);
		
		response.sendRedirect("list");
		
		//System.out.println(q.toString());
	}

}
