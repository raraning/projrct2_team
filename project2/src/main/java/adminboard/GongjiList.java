package adminboard;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AdminBoardDAO;
import model.Notice;


@WebServlet("/admin/board/gongji_list")
public class GongjiList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public GongjiList() {
        super();
        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AdminBoardDAO dao = new AdminBoardDAO();
		
		String field = request.getParameter("field");
		String search = request.getParameter("search");
		
		int pageSize = 3;
		
		int pageNum = 1;
		if(request.getParameter("pageNum") != null) {
			pageNum = Integer.parseInt(request.getParameter("pageNum"));
		}
		
		int count = dao.getAllCount(field,search);
		
		int number = 0;
		
		int startRow = (pageNum - 1) * pageSize;
		int endRow = pageSize;
		
		ArrayList<Notice> g = dao.getAllNotice(startRow, endRow, field,search);
		
		number = count - (pageNum - 1) * pageSize;	
		
		request.setAttribute("pageSize", pageSize);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("count", count);
		request.setAttribute("number", number);
		request.setAttribute("field", field);
		request.setAttribute("search", search);
		request.setAttribute("list", g);
		
		RequestDispatcher dis = request.getRequestDispatcher("/admin/board/gongji_list.jsp");
		dis.forward(request, response);
	}
}
