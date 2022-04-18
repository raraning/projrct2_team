package member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MemberDAO;
import model.Member;


@WebServlet("/member/member_login_ok")
public class LoginOk extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public LoginOk() {
        super();
       
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		
		MemberDAO dao = new MemberDAO();		
		
		int num = dao.loginSelect(id);
		
		if(num == 1) {
			Member m = dao.loginMemberSelect(id,pass);
			
			HttpSession session = request.getSession();
			
			session.setAttribute("id", m.getId());
			session.setAttribute("name", m.getName());
			session.setAttribute("level", m.getLevel());
			session.setAttribute("sell_buy", m.getSell_buy());
			
			
			System.out.println(m.toString());
			response.sendRedirect("/");
		}else {
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			
			out.print("<script>");
			out.print("alert('존재하지 않는 아이디이거나 비밀번호가 맞지않습니다.');");
			out.print("alert('다시 확인하신 후 로그인 해주세요.');");
			out.print("history.back();");
			out.print("</script>");
			out.close();
		}

	}
}
