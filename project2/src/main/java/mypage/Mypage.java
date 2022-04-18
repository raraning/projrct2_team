package mypage;

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


@WebServlet("/member/my/mypage")
public class Mypage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Mypage() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		
		String session_id = (String)session.getAttribute("id");
		
		MemberDAO dao = new MemberDAO();
		int num = dao.loginSelect(session_id);
		
		if(num == 1) {
			Member m = dao.oneMember(session_id);	
			
			request.setAttribute("member", m);
			RequestDispatcher dis = request.getRequestDispatcher("/member/my/mypage.jsp");
			dis.forward(request, response);
		}else {
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			
			out.print("<script>");
			out.print("alert('로그인  후 이용가능 합니다');");
			out.print("history.back();");
			out.print("</script>");
			out.close();
		}	
		
	}

}
