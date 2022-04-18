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
		
		//�˻���
		String field = request.getParameter("field");
		String search = request.getParameter("search");
		String pro_class = request.getParameter("pro_class");
		String category = request.getParameter("category");
		
		//�������� ������ �Խñ��� ����
		int pageSize = 15;
		
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
	    
	    //class �� category ����
  		if(pro_class != null && !pro_class.equals("")) {
  			request.setAttribute("pro_cate",pro_class);
  		}
  		
  		if(category != null && !category.equals("") && (category.equals("����") || category.equals("ä��/��/���") || category.equals("���/���"))) {
  			request.setAttribute("pro_cate", "1");
  			request.setAttribute("category",category);
  		}else if(category != null && !category.equals("") && (category.equals("����/�õ�/����丮") || category.equals("���깰/�õ�����") || category.equals("����/����"))) {
  			request.setAttribute("pro_cate", "2");
  			request.setAttribute("category",category);
  		}else if(category != null && !category.equals("") && (category.equals("����ǰ/���̽�ũ��") || category.equals("��/�ҽ�/�巹��/����") || category.equals("����/���ݸ�/�ø���"))) {
  			request.setAttribute("pro_cate", "3");
  			request.setAttribute("category",category);
  		}
		
		RequestDispatcher dis = request.getRequestDispatcher("buyer_product_list.jsp");
		dis.forward(request, response);
	}
	
}
