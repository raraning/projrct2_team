package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.QnaDAO;
import model.Qna;


@WebServlet("/qna/view")
public class QnaView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public QnaView() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int uid = Integer.parseInt(request.getParameter("uid"));
		
		QnaDAO dao = new QnaDAO();
		
		//게시글 조회수 +1
		dao.qnaRef(uid);
		
		Qna q = dao.oneQna(uid);
		//System.out.println("==========uid : "+uid);
		request.setAttribute("q", q);
		//System.out.println(q.toString());
		RequestDispatcher dis = request.getRequestDispatcher("view.jsp");
		dis.forward(request, response);
	}

}
