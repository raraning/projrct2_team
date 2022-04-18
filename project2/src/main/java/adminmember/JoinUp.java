package adminmember;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AdminMemberDAO;
import model.Member;


@WebServlet("/admin/member/join_up")
public class JoinUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public JoinUp() {
        super();
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("id");
		
		AdminMemberDAO dao = new AdminMemberDAO();
		Member m = dao.selectMember(id);
			
		request.setAttribute("mem", m);
		RequestDispatcher dis = request.getRequestDispatcher("/admin/member/join_up.jsp");
		dis.forward(request, response);
				
	}
}


