package cart;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CartDAO;
import dao.ProSaveDAO;
import dao.ProductDAO;
import model.Cart;
import model.Prosave;

@WebServlet("/buyer/cart_insert")
public class CartInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CartInsert() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int pro_uid = Integer.parseInt(request.getParameter("pro_uid"));
		String pro_type = request.getParameter("pro_type"); //c: cart , z: zzip
		
		HttpSession session = request.getSession();
		String session_id = (String)session.getAttribute("id");
		
		ProductDAO dso = new ProductDAO();
		
		
		int cart_num = 0;
		int zzim_num = 0;
		
		String pro_name = request.getParameter("pro_name");
		String pro_id = request.getParameter("pro_id");
		String id = request.getParameter("id");
		String cart_session = request.getParameter("cart_session");
		int pro_price = Integer.parseInt(request.getParameter("pro_price"));
		int pro_count = Integer.parseInt(request.getParameter("pro_count"));
		int pro_point = Integer.parseInt(request.getParameter("pro_point"));
		String pay_ok = request.getParameter("pay_ok");
		
		int sum = dso.loginSelect(session_id);
		
		if(sum == 1){
			if(pro_type.equals("c")) { // c : 장바구니 
				cart_num = dso.cartSelectCheck(pro_uid,session_id,cart_session);
				
				if(cart_num == 0) {
					
					//insert
					Cart c = new Cart();
					
					c.setPro_uid(pro_uid);
					c.setCart_session(cart_session);
					c.setPro_id(pro_id);
					c.setId(id);
					c.setPro_name(pro_name);
					c.setPro_price(pro_price);
					c.setPro_point(pro_point);
					c.setPro_count(pro_count);
					c.setPay_ok(pay_ok);
					
					System.out.println(c.toString());
					
					CartDAO dao = new CartDAO();
					dao.insertCart(c);
				}else {	//수정됨
					
					//기존 수량 가져오기
					CartDAO dao = new CartDAO();
					int num = dao.oneCartSelect(pro_uid, id, cart_session);
					
					//추가할 수량 : pro_count
					int result = num + pro_count;
					
					//update					
					dao.updateCart(result, pro_uid, cart_session, session_id);
					
				}
				response.sendRedirect("/");
			}else{ // z : 찜하기
				zzim_num = dso.zzipSelectCheck(pro_uid,session_id);
				
				if(zzim_num == 0) {
					//insert
					Prosave p = new Prosave();
					
					p.setPro_uid(pro_uid);
					p.setCart_session(cart_session);
					p.setPro_id(pro_id);
					p.setId(id);
					p.setPro_name(pro_name);
					p.setPro_price(pro_price);
					p.setPro_point(pro_point);
					p.setPro_count(1);
					p.setPro_point(pro_point);
					p.setPay_ok(pay_ok);
					
					System.out.println(p.toString());
					
					ProSaveDAO dao = new ProSaveDAO();
					dao.proSave(p);
					response.sendRedirect("/");
				}else {
					response.setContentType("text/html; charset=utf-8");
					PrintWriter out = response.getWriter();
					
					out.print("<script>");
					out.print("alert('이미 찜하기 해 논 제품입니다.');");
					out.print("history.back();");
					out.print("</script>");
					out.close();
				}
			}
			
		}else {
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			
			out.print("<script>");
			out.print("alert('로그인 후 사용가능합니다');");
			out.print("history.back();");
			out.print("</script>");
			out.close();
		}
		
	}

}
