package seller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDAO;
import model.Product;


@WebServlet("/seller/seller_product_modify")
public class SellerProductModify extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public SellerProductModify() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pro_uid = Integer.parseInt(request.getParameter("pro_uid"));
		
		ProductDAO dao = new ProductDAO();
		Product sp = dao.oneProductModify(pro_uid);
		
		request.setAttribute("list", sp);
		RequestDispatcher dis = request.getRequestDispatcher("seller_product_modify.jsp");
		dis.forward(request, response);
	}
}
