package adminmember;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AdminMemberDAO;
import model.Member;


@WebServlet("/admin/member/list")
public class List extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public List() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AdminMemberDAO dao = new AdminMemberDAO();
		
		String field = request.getParameter("field");
		String search = request.getParameter("search");
		
		int pageSize = 9;
		
		int pageNum = 1;
		if(request.getParameter("pageNum") != null) {
			pageNum = Integer.parseInt(request.getParameter("pageNum"));
		}
		
		int count = dao.getAllCount(field,search);
		
		
		int number = 0;
		
		
		int startRow = (pageNum - 1) * pageSize;
		int endRow = pageSize;
		
		ArrayList<Member> v = dao.getAllMember(startRow, endRow, field,search);
		
		number = count - (pageNum - 1) * pageSize;
		
		request.setAttribute("pageSize", pageSize);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("count", count);
		request.setAttribute("number", number);
		request.setAttribute("field", field);
		request.setAttribute("search", search);
		request.setAttribute("m_list", v);
		RequestDispatcher dis = request.getRequestDispatcher("/admin/member/list.jsp");
		dis.forward(request, response);
	}


}
