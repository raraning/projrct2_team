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
		
		//검색어
		String field = request.getParameter("field");
		String search = request.getParameter("search");
		
		//한 페이지 보여질 게시글의 갯수
		int pageSize = 5;
		
		//현재 보여지는 페이지의 넘버 값 처리
		int pageNum = 1;
		if(request.getParameter("pageNum") != null) {
			pageNum = Integer.parseInt(request.getParameter("pageNum"));
		}
		
		//전체 게시글 수
		int count = dao.getAllRecipe(field, search);
		
		//페이지 내에서 보여질 넘버링 숫자 처리 초기화
		int number = 0;
		
		//현재 보여질 페이지 limit 값 설정
		int startRow = (pageNum - 1) * pageSize;
		int endRow = pageSize;
		
		ArrayList<Recipe> v = dao.getAllRecipe(startRow, endRow, field, search);
		
		//넘버링 숫자
		number = count - (pageNum - 1) * pageSize;
		
		request.setAttribute("field", field);
		request.setAttribute("search", search);
		request.setAttribute("number", number);
		request.setAttribute("pageSize", pageSize);
		request.setAttribute("count", count);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("v", v); //리스트에 필요한 List 객체들의 모임 전달
		
		RequestDispatcher dis = request.getRequestDispatcher("recipe_list.jsp");
		dis.forward(request, response);
	}


}
