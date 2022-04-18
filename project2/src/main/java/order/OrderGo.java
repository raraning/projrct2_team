package order;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CartDAO;
import dao.OrderDAO;
import model.Cart;
import model.Order;


@WebServlet("/order/order_go")
public class OrderGo extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public OrderGo() {
        super();
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		HttpSession session = request.getSession();
		String session_id = (String)session.getAttribute("id");
		String pay_ok = request.getParameter("pay_ok");
		
		String howpay = request.getParameter("howpay");
		String howpay_num = request.getParameter("howpay_num");
		String bank1 = request.getParameter("bank1");
		String bank1_get_name = request.getParameter("bank1_get_name");
		String bank1_give_name = request.getParameter("bank1_give_name");
		
		String cart_session = request.getParameter("cart_session");
		
		String get_name = request.getParameter("get_name");
		String get_phone = request.getParameter("get_phone");
		String get_zipcode = request.getParameter("get_zipcode");
		String get_zipcode1 = request.getParameter("get_zipcode1");
		String get_zipcode2 = request.getParameter("get_zipcode2");
		String get_zipcode3 = request.getParameter("get_zipcode3");
		String get_zipcode4 = request.getParameter("get_zipcode4");
		
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String zipcode = request.getParameter("zipcode");
		String zipcode1 = request.getParameter("zipcode1");
		String zipcode2 = request.getParameter("zipcode2");
		String zipcode3 = request.getParameter("zipcode3");
		String zipcode4 = request.getParameter("zipcode4");
		String message = request.getParameter("message");
		
		//īƮ///
		int pro_uid = Integer.parseInt(request.getParameter("pro_uid"));
		int pro_count = Integer.parseInt(request.getParameter("pro_count"));
		///////
		Order o = new Order();
		
		o.setPay_ok(pay_ok);
		
		o.setHowpay(howpay);
		o.setHowpay_num(howpay_num);
		o.setBank1(bank1);
		o.setBank1_get_name(bank1_get_name);
		o.setBank1_give_name(bank1_give_name);
		
		o.setCart_session(cart_session);
		
		o.setGet_name(get_name);
		o.setGet_phone(get_phone);
		o.setGet_zipcode(get_zipcode);
		o.setGet_zipcode1(get_zipcode1);
		o.setGet_zipcode2(get_zipcode2);
		o.setGet_zipcode3(get_zipcode3);
		o.setGet_zipcode4(get_zipcode4);
		
		o.setId(id);
		o.setName(name);
		o.setEmail(email);
		o.setPhone(phone);
		o.setZipcode(zipcode);
		o.setZipcode1(zipcode1);
		o.setZipcode2(zipcode2);
		o.setZipcode3(zipcode3);
		o.setZipcode4(zipcode4);
		o.setMessage(message);
		
		
		
		System.out.println(o.toString());
		OrderDAO dao = new OrderDAO();
		dao.insertOrder(o);
		
		//cart update
		
		int num = dao.oneCartSelect(pro_uid, id, cart_session);
		
		int result = num + pro_count;
		
		//update
		dao.updateCart(result, pro_uid, pay_ok, cart_session, session_id);
		
		
		response.sendRedirect("/");
	}

}
