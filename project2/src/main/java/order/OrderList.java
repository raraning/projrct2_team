package order;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MemberDAO;
import dao.OrderDAO;
import model.CartFile;
import model.Member;


@WebServlet("/order/order_list")
public class OrderList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public OrderList() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		HttpSession session = request.getSession();
		String session_id = (String)session.getAttribute("id");
		String session_cart = (String)session.getAttribute("cart");
		
		MemberDAO mem = new MemberDAO();
		OrderDAO dao = new OrderDAO();
		
		Member m = mem.oneMember(session_id);
		ArrayList<CartFile> c = dao.getAllCart(session_id, session_cart);
		
		request.setAttribute("member", m);
		request.setAttribute("c_list", c);
		RequestDispatcher dis = request.getRequestDispatcher("/order/order_list.jsp");
		dis.forward(request, response);
		
	}
}
