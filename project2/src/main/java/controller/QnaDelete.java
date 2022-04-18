package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.QnaDAO;


@WebServlet("/qna/delete")
public class QnaDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public QnaDelete() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int uid = Integer.parseInt(request.getParameter("uid"));
		
		HttpSession session = request.getSession();
		
		String id = (String)session.getAttribute("id");
		
		QnaDAO dao = new QnaDAO();
		dao.qnaDelete(uid);
		response.sendRedirect("/qna/list");
	}

}
