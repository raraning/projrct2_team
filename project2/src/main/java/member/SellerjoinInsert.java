package member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDAO;
import model.Member;


@WebServlet("/member/seller_join_insert")
public class SellerjoinInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public SellerjoinInsert() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		/*
		 * Calendar current = Calendar.getInstance(); int currentYear =
		 * current.get(Calendar.YEAR); //���� �⵵
		 * 
		 * String birth = "2000";//���� �⵵
		 * 
		 * String age= currentYear - birth; //����
		 */		
		Member m = new Member();
		
		
		
		  m.setId(request.getParameter("id")); m.setPass(request.getParameter("pass"));
		  m.setName(request.getParameter("name"));
		  m.setBirth(request.getParameter("birth"));
		  m.setGender(request.getParameter("gender"));
		  m.setEmail(request.getParameter("email"));
		  m.setZipcode(request.getParameter("zipcode"));
		  m.setZipcode1(request.getParameter("zipcode1"));
		  m.setZipcode2(request.getParameter("zipcode2"));
		  m.setZipcode3(request.getParameter("zipcode3"));
		  m.setZipcode4(request.getParameter("zipcode4"));
		  m.setPhone(request.getParameter("phone"));
		 
		
		System.out.println(m.toString());
		
		MemberDAO dao = new MemberDAO();
		dao.insertMamber(m);
		
		
		/*
		 * HttpSession session = request.getSession(); session.setAttribute("id",
		 * m.getId()); session.setAttribute("name", m.getName());
		 * session.setAttribute("level", m.getLevel()); session.setAttribute("name",
		 * m.getNone());
		 */
		
		response.sendRedirect("/");		
	}

}
