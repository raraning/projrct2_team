package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.QnaDAO;
import model.Qna;


@WebServlet("/qna/qna_update")
public class QnaModifyUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public QnaModifyUpdate() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		Qna q = new Qna();
		
		q.setSubject(request.getParameter("subject"));
		q.setComment(request.getParameter("comment"));
		q.setGongji(request.getParameter("gongji"));
		q.setUid(Integer.parseInt(request.getParameter("uid")));
		
		QnaDAO dao = new QnaDAO();
		dao.updateNotice(q); 
		
		response.sendRedirect("/qna/list");
	}

}
