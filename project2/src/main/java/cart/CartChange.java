package cart;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CartDAO;


@WebServlet("/cart/cart_count_change")
public class CartChange extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public CartChange() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int pro_uid = Integer.parseInt(request.getParameter("pro_uid"));
		int pro_count = Integer.parseInt(request.getParameter("pro_count"));
		String cart_session = request.getParameter("cart_session");
		
		HttpSession session = request.getSession();
		String session_id = (String)session.getAttribute("id");
		
		
		CartDAO dao = new CartDAO();
		dao.pointChange(pro_uid, pro_count, session_id, cart_session);
		
		
		RequestDispatcher dis = request.getRequestDispatcher("/cart/list.jsp");
		dis.forward(request, response);
	}

}