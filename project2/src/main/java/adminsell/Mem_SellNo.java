package adminsell;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AdminMemberDAO;


@WebServlet("/admin/sell/sellno")
public class Mem_SellNo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Mem_SellNo() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		
		AdminMemberDAO dao = new AdminMemberDAO();
		dao.sellMemberNo(id);
		
		response.sendRedirect("/admin/sell/memberok_list");
		
	}

	

}
