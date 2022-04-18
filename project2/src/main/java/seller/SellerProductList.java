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
		
		//�˻���
		String field = request.getParameter("field");
		String search = request.getParameter("search");
		String pro_class = request.getParameter("pro_class");
		String category = request.getParameter("category");
		
		//�������� ������ �Խñ��� ����
		int pageSize = 5;
		
		//���� �������� �������� �ѹ� �� ó��
		int pageNum = 1;
		if(request.getParameter("pageNum") != null) {
			pageNum = Integer.parseInt(request.getParameter("pageNum"));
		}
		
		//��ü �Խñ� ��
		int count = dao.getAllProduct(field, search);  //seller_product_list ����
						
		//������ ������ ������ �ѹ��� ���� ó�� �ʱ�ȭ
		int number = 0;
		
		//���� ������ ������ limit �� ���� //seller_product_list ����
		int startRow = (pageNum - 1) * pageSize;
		int endRow = pageSize;
		
		ArrayList<Product> v = dao.getAllProduct(startRow, endRow, field, search, pro_class, category);
		
		//�ѹ��� ����
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
