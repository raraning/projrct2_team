package adminsell;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AdminMemberDAO;


@WebServlet("/admin/sell/sellok")
public class Mem_SellOk extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Mem_SellOk() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		
		AdminMemberDAO dao = new AdminMemberDAO();
		dao.sellMemberOk(id);
		
		response.sendRedirect("/admin/sell/memberok_list");
	}


}
