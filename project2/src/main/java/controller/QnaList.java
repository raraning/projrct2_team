package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.QnaDAO;
import model.Qna;


@WebServlet("/qna/list")
public class QnaList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public QnaList() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		QnaDAO dao = new QnaDAO();
		
		//�˻���
		String field = request.getParameter("field");
		String search = request.getParameter("search");
		
		
		//�������� ������ �Խñ��� ����
	    int pageSize = 3;
	    
	    //���� �������� �������� �ѹ� �� ó��
	    int pageNum = 1;
	    if(request.getParameter("pageNum") != null) {
	    	pageNum = Integer.parseInt(request.getParameter("pageNum"));
	    }
	    
	    //��ü �Խñ� ��
	    int count = dao.getAllQna(field, search); //QnaList ����
	    
	    //������ ������ ������ �ѹ��� ���� ó�� �ʱ�ȭ
	    int number = 0;
	    
	    //���� ������ ������ limit �� ���� //qna list.jsp ����
	    int startRow = (pageNum - 1) * pageSize;
	    int endRow = pageSize;
	    
	    ArrayList<Qna> v = dao.getAllQna(startRow,endRow,field,search); //QnaList ����
	    
	    //�ѹ��� ����
	    number = count - (pageNum - 1) *pageSize;
	    
	    request.setAttribute("field", field);
	    request.setAttribute("search", search);
	    request.setAttribute("number", number);
	    request.setAttribute("count", count);
	    request.setAttribute("pageSize", pageSize);
	    request.setAttribute("pageNum", pageNum);
	    request.setAttribute("v", v);
	    
		RequestDispatcher dis = request.getRequestDispatcher("/qna/list.jsp");
		dis.forward(request, response);
	}

}
