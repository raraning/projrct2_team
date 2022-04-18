package cart;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CartDAO;
import model.CartFile;


@WebServlet("/cart/list")
public class CartList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public CartList() {
        super();
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		String session_id = (String)session.getAttribute("id");
		String session_cart = (String)session.getAttribute("cart");
		
		CartDAO dao = new CartDAO();
		
		int sum = dao.loginSelect(session_id);
		//System.out.println("========sum=======:"+sum);
		if(sum == 1) {
			int pageSize = 4;
			
			int pageNum = 1;
			if(request.getParameter("pageNum") != null) {
				pageNum = Integer.parseInt(request.getParameter("pageNum"));
			}
			
			int count = dao.getAllCount(session_id);
			System.out.println("========count=======:"+count);
			int number = 0;
			
			int startRow = (pageNum - 1) * pageSize;
			int endRow = pageSize;
			
			ArrayList<CartFile> c = dao.getAllCart(session_id, startRow, endRow);
			
			number = count - (pageNum - 1) * pageSize;
			
			request.setAttribute("pageSize", pageSize);
			request.setAttribute("pageNum", pageNum);
			request.setAttribute("count", count);
			request.setAttribute("number", number);	
			request.setAttribute("c_list", c);
			RequestDispatcher dis = request.getRequestDispatcher("/cart/list.jsp");
			dis.forward(request, response);
			
		}else {
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			
			out.print("<script>");
			out.print("alert('로그인  후 이용가능 합니다');");
			out.print("history.back();");
			out.print("</script>");
			out.close();
		}
		
	}


}
