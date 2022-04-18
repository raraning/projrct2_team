package seller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDAO;


@WebServlet("/seller/seller_product_delete")
public class SellerProductDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public SellerProductDelete() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pro_num = Integer.parseInt(request.getParameter("pro_uid"));
		
		ProductDAO dao = new ProductDAO();
		dao.deleteProduct(pro_num);
		
		response.sendRedirect("/seller/seller_product_list");
	}

}
