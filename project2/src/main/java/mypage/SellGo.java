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


@WebServlet("/member/my/sell_go")
public class SellGo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public SellGo() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		
		String session_id = (String)session.getAttribute("id");
		
		MemberDAO dao = new MemberDAO();
		Member m = dao.oneMember(session_id);
		
		request.setAttribute("member", m);
		RequestDispatcher dis = request.getRequestDispatcher("/member/my/sell_go.jsp");
		dis.forward(request, response);
	}
}
