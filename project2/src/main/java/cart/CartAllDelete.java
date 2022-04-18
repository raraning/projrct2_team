package cart;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CartDAO;


@WebServlet("/cart/cart_all_delete")
public class CartAllDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public CartAllDelete() {
        super();
      
    }

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		
		String session_id = (String)session.getAttribute("id");
		
		CartDAO dao = new CartDAO();
		dao.allDelete(session_id);
		
		response.sendRedirect("/cart/list");
	}


}
