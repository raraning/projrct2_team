package member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDAO;


@WebServlet("/member/member_id_found_ok")
public class IdFoundOk extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public IdFoundOk() {
        super();

    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		
		//System.out.println("=========name=========:"+name);
		//System.out.println("=========email=========:"+email);
		
		MemberDAO dao = new MemberDAO();
		String id = dao.idSearch(name , email);
		
		//System.out.println("=========id=========:"+id);
		
		request.setAttribute("found", id);
		RequestDispatcher dis = request.getRequestDispatcher("id_foundok.jsp");
		dis.forward(request, response);
		
	}

}
