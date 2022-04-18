package buyer;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDAO;
import model.Product;


@WebServlet("/buyer/buyer_product_view")
public class BuyerProductView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public BuyerProductView() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pro_uid = Integer.parseInt(request.getParameter("pro_uid"));
		String pro_class = request.getParameter("pro_class");
		String category = request.getParameter("category");
		
		//System.out.println("===========pro_uid : "+pro_uid);
		
		ProductDAO dao = new ProductDAO();
		Product sp = dao.oneProductDetailing(pro_uid);
		
		String imgTargetPath= "C:\\jsp\\project2\\src\\main\\webapp\\upload\\"+sp.getFile1();//�̹��� ���
		Image image = ImageIO.read(new File(imgTargetPath));
        int imageWidth = image.getWidth(null);
		
		request.setAttribute("list", sp);
		request.setAttribute("imageWidth", imageWidth);
		
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
  		
  		
		RequestDispatcher dis = request.getRequestDispatcher("buyer_product_view.jsp");
		dis.forward(request, response);
	}
	
}
