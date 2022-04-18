package adminmember;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AdminMemberDAO;


@WebServlet("/admin/member/joinout")
public class JoinOut1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public JoinOut1() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		
		AdminMemberDAO dao = new AdminMemberDAO();
		dao.outMember(id);
		
		response.sendRedirect("/admin/member/list");
	}


}
