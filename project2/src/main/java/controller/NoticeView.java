package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ListDAO;
import model.List;


@WebServlet("/bbs/notice_view")
public class NoticeView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public NoticeView() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int uid = Integer.parseInt(request.getParameter("uid"));
		//System.out.println("==============uid : "+uid);
		ListDAO dao = new ListDAO();
		
		//조회수 + 1 처리
		dao.noticeRef(uid);
		
		List l = dao.oneNotice(uid);
		//System.out.println(l.toString());
		request.setAttribute("list", l);
		RequestDispatcher dis = request.getRequestDispatcher("notice_view.jsp");
		dis.forward(request, response);
	}
}
