package mypage;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDAO;
import model.Member;


@WebServlet("/member/my/my_sellok_update")
public class SellGoUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public SellGoUpdate() {
        super();
       
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		
		Member m = new Member();
		
		m.setId(request.getParameter("id"));
		m.setLevel(request.getParameter("level"));
		m.setPro_manuname(request.getParameter("pro_manuname"));
		m.setPro_salname(request.getParameter("pro_salname"));
	
		System.out.println(m.toString());
		
		MemberDAO dao = new MemberDAO();
		dao.sellOk(m);
		
		
		response.setContentType("text/html; charset=utf-8"); PrintWriter out =
		response.getWriter();
		 
		out.print("<script>");
		out.print("alert('신청 처리 되었습니다.');");
		out.print("location.href='/member/my/mypage';");
		out.print("</script>");
	}

}
