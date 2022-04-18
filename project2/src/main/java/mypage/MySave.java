package mypage;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MyDAO;
import model.ProsaveFile;


@WebServlet("/member/my/my_save")
public class MySave extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MySave() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		String session_id = (String)session.getAttribute("id");
		MyDAO dao = new MyDAO();
		
		int pageSize = 3;
		
		int pageNum = 1;
		if(request.getParameter("pageNum") != null) {
			pageNum = Integer.parseInt(request.getParameter("pageNum"));
		}
		
		int count = dao.getAllCount(session_id);
			
		int number = 0;
		
		int startRow = (pageNum - 1) * pageSize;
		int endRow = pageSize;
		
		ArrayList<ProsaveFile> m = dao.getAllMySave(session_id, startRow, endRow);
		
		number = count - (pageNum - 1) * pageSize;
		
		request.setAttribute("pageSize", pageSize);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("count", count);
		request.setAttribute("number", number);	
		request.setAttribute("m_list", m);
		RequestDispatcher dis = request.getRequestDispatcher("/member/my/my_save.jsp");
		dis.forward(request, response);
		
	}


}
