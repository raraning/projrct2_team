package member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MemberDAO;
import model.Member;


@WebServlet("/member/member_join_up")
public class JoinUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public JoinUp() {
        super();
      
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		String session_id = (String)session.getAttribute("id");
		
		if(session_id == null) {
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			
			out.print("<script>");
			out.print("alert('로그인 후 입력해 주세요.');");
			out.print("location.href='/';");
			out.print("</script>");
			out.close();
			
		}else {
			MemberDAO dao = new MemberDAO();
			Member m = dao.oneMember(session_id);
			
			request.setAttribute("mem", m);
			RequestDispatcher dis = request.getRequestDispatcher("/member/join_up.jsp");
			dis.forward(request, response);
				
		}
	}

}
