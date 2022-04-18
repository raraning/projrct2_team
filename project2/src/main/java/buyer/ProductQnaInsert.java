package buyer;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ProductQnaDAO;
import model.ProductQna;

@WebServlet("/buyer/buyer_product_qna")
public class ProductQnaInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ProductQnaInsert() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("utf-8");
    	response.setContentType("text/html; charset=UTF-8");

    	PrintWriter out = response.getWriter();
    	
    	HttpSession session = request.getSession();
    	
    	//현재 시간
		Date nowTime = new Date();
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String today = sf.format(nowTime);
		
		ProductQna q = new ProductQna();
		
		int fid = 1;
		String thread = "A";
		
		q.setPro_uid(Integer.parseInt(request.getParameter("pro_uid")));
		q.setId((String)session.getAttribute("id"));
		q.setName((String)session.getAttribute("name"));
		q.setComment(request.getParameter("comment"));
		q.setSigndate(today);
		q.setQna(request.getParameter("qna"));
		q.setFid(fid);
		q.setThread(thread);
		
		System.out.println(q.toString());
		
		
		
		ProductQnaDAO dao = new ProductQnaDAO();
		
		dao.InsertQna(q);
		
		out.println("문의가 저장되었습니다.\t답변은 2일~3일정도 소요됩니다.");
		out.close();
	}


}
