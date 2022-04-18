package mypage;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDAO;
import model.Member;


@WebServlet("/member/my/my_sellerjoin_update")
public class JoinSellerUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public JoinSellerUpdate() {
        super();
        
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		Member m = new Member();
		
		m.setId(request.getParameter("id"));
		m.setPass(request.getParameter("pass"));
		m.setName(request.getParameter("name"));
		m.setBirth(request.getParameter("birth"));
		m.setGender(request.getParameter("gender"));
		m.setEmail(request.getParameter("email"));
		m.setZipcode(request.getParameter("zipcode"));
		m.setZipcode1(request.getParameter("zipcode1"));
		m.setZipcode2(request.getParameter("zipcode2"));
		m.setZipcode3(request.getParameter("zipcode3"));
		m.setZipcode4(request.getParameter("zipcode4"));
		m.setLevel(request.getParameter("level"));
		m.setNone(request.getParameter("none"));
		m.setPro_manuname(request.getParameter("pro_manuname"));
		m.setPro_salname(request.getParameter("pro_salname"));
		
		System.out.println(m.toString());
		MemberDAO dao = new MemberDAO();
		dao.updateMember(m);
		
		response.sendRedirect("/member/my/mypage");
	}

}
