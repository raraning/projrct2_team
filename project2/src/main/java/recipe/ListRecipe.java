package recipe;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.RecipeDAO;
import model.Recipe;

@WebServlet("/recipe/recipe_list")
public class ListRecipe extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ListRecipe() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RecipeDAO dao = new RecipeDAO();
		
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
		int count = dao.getAllRecipe(field, search);
		
		//������ ������ ������ �ѹ��� ���� ó�� �ʱ�ȭ
		int number = 0;
		
		//���� ������ ������ limit �� ����
		int startRow = (pageNum - 1) * pageSize;
		int endRow = pageSize;
		
		ArrayList<Recipe> v = dao.getAllRecipe(startRow, endRow, field, search);
		
		//�ѹ��� ����
		number = count - (pageNum - 1) * pageSize;
		
		request.setAttribute("field", field);
		request.setAttribute("search", search);
		request.setAttribute("number", number);
		request.setAttribute("pageSize", pageSize);
		request.setAttribute("count", count);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("v", v); //����Ʈ�� �ʿ��� List ��ü���� ���� ����
		
		RequestDispatcher dis = request.getRequestDispatcher("recipe_list.jsp");
		dis.forward(request, response);
	}


}
