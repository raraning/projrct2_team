package member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDAO;


@WebServlet("/member/member_pass_found_ok")
public class PassFoundOk extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	
    public PassFoundOk() {
        super();
      
    }

    

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("id");
		String email = request.getParameter("email");
		
		MemberDAO dao = new MemberDAO();
		String pass = dao.passSearch(id, email);
		
		request.setAttribute("found", pass);
		RequestDispatcher dis = request.getRequestDispatcher("/member/pass_foundok.jsp");
		dis.forward(request, response);
	}

}
