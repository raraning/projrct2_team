package seller;

import java.awt.Image;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.jimi.core.Jimi;
import com.sun.jimi.core.JimiUtils;

import dao.ProductDAO;
import model.Product;


@WebServlet("/seller/seller_product_list")
public class SellerProductList extends HttpServlet {
	private static final long serialVersionUID = 1L;       

    public SellerProductList() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductDAO dao = new ProductDAO();
		
		//검색어
		String field = request.getParameter("field");
		String search = request.getParameter("search");
		String pro_class = request.getParameter("pro_class");
		String category = request.getParameter("category");
		
		//페이지에 보여질 게시글의 갯수
		int pageSize = 5;
		
		//현재 보여지는 페이지의 넘버 값 처리
		int pageNum = 1;
		if(request.getParameter("pageNum") != null) {
			pageNum = Integer.parseInt(request.getParameter("pageNum"));
		}
		
		//전체 게시글 수
		int count = dao.getAllProduct(field, search);  //seller_product_list 연동
						
		//페이지 내에서 보여질 넘버링 숫자 처리 초기화
		int number = 0;
		
		//현재 보여질 페이지 limit 값 설정 //seller_product_list 연동
		int startRow = (pageNum - 1) * pageSize;
		int endRow = pageSize;
		
		ArrayList<Product> v = dao.getAllProduct(startRow, endRow, field, search, pro_class, category);
		
		//넘버링 숫자
		number = count - (pageNum - 1) * pageSize;
		
		request.setAttribute("field", field);
	    request.setAttribute("search", search);
	    request.setAttribute("number", number);
	    request.setAttribute("count", count);
	    request.setAttribute("pageSize", pageSize);
	    request.setAttribute("pageNum", pageNum);
	    request.setAttribute("v", v);
		
		RequestDispatcher dis = request.getRequestDispatcher("seller_product_list.jsp");
		dis.forward(request, response);
	}

}
