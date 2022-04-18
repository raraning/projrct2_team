package buyer;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDAO;
import model.Product;


@WebServlet("/buyer/buyer_product_list")
public class BuyerProductList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public BuyerProductList() {
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
		int pageSize = 15;
		
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
	    
	    //class 및 category 전달
  		if(pro_class != null && !pro_class.equals("")) {
  			request.setAttribute("pro_cate",pro_class);
  		}
  		
  		if(category != null && !category.equals("") && (category.equals("과일") || category.equals("채소/쌀/잡곡") || category.equals("축산/계란"))) {
  			request.setAttribute("pro_cate", "1");
  			request.setAttribute("category",category);
  		}else if(category != null && !category.equals("") && (category.equals("냉장/냉동/간편요리") || category.equals("수산물/냉동육류") || category.equals("생수/음료"))) {
  			request.setAttribute("pro_cate", "2");
  			request.setAttribute("category",category);
  		}else if(category != null && !category.equals("") && (category.equals("유제품/아이스크림") || category.equals("장/소스/드레싱/식초") || category.equals("과자/초콜릿/시리얼"))) {
  			request.setAttribute("pro_cate", "3");
  			request.setAttribute("category",category);
  		}
		
		RequestDispatcher dis = request.getRequestDispatcher("buyer_product_list.jsp");
		dis.forward(request, response);
	}
	
}
