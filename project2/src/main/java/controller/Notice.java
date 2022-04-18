package controller;

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

import dao.ListDAO;
import model.List;


@WebServlet("/bbs/list")
public class Notice extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Notice() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ListDAO dao = new ListDAO();
		
		//�˻��� 
		String field = request.getParameter("field");
		String search = request.getParameter("search");
		
		//�� ������ ������ �Խñ��� ����
		int pageSize = 5;
		
		//���� �������� �������� �ѹ� �� ó��
		int pageNum = 1;
		if(request.getParameter("pageNum") != null) {
			pageNum = Integer.parseInt(request.getParameter("pageNum"));
		}
		
		//��ü �Խñ� �� 
		int count = dao.getAllNotice(field, search);
		
		//������ ������ ������ �ѹ��� ���� ó�� �ʱ�ȭ
		int number = 0;
		
		//���� ������ ������ limit �� ����
		int startRow = (pageNum - 1) * pageSize;
		int endRow = pageSize;
		
		ArrayList<List> v = dao.getAllPost(startRow, endRow, field, search);
		
		//�ѹ��� ����
		number = count - (pageNum - 1) * pageSize;
		
		request.setAttribute("field", field);
		request.setAttribute("search", search);
		request.setAttribute("number", number);
		request.setAttribute("pageSize", pageSize);
		request.setAttribute("count", count);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("v", v); //����Ʈ�� �ʿ��� List ��ü���� ���� ����
		
		RequestDispatcher dis = request.getRequestDispatcher("list.jsp");
		dis.forward(request, response);
	}
}
