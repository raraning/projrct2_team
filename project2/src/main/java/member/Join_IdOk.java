package member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDAO;


@WebServlet("/member/idok")
public class Join_IdOk extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Join_IdOk() {
        super();
      
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String id = request.getParameter("id");
	
	String msg = "";
	
	MemberDAO dao = new MemberDAO();
	
	int num = dao.loginSelect(id);
	
	if(id.length() < 6) {
		msg = "<font color=red>아이디는 6자 이상 입력하세요</font>";
	}else if(num == 1) {
		msg = "<font color=red> 이미 존재하는 아이디 입니다.</font>";
	}else {
		msg = "<font color=blue> 사용 가능한 아이디 입니다.</font>";
	}
	response.setContentType("text/html; charset=utf-8");
	PrintWriter out = response.getWriter();
	out.print(msg);
	
	}

}
