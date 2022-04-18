package recipe;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.RecipeCommentDAO;
import dao.RecipeDAO;
import model.Recipe;
import model.RecipeComment;


@WebServlet("/recipe/recipe_view")
public class ViewRecipe extends HttpServlet {
	private static final long serialVersionUID = 1L;      

    public ViewRecipe() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int uid = Integer.parseInt(request.getParameter("uid"));
		//System.out.println("==========uid : "+uid);
		RecipeDAO dao = new RecipeDAO();
		
		RecipeCommentDAO rdao = new RecipeCommentDAO();
		
		ArrayList<RecipeComment> listrc = rdao.oneRecipeComment(uid);
		
		//��ȸ�� + 1 ó��
		dao.recipeRef(uid);
		
		Recipe r = dao.oneRecipe(uid); 
		
		//System.out.println(r.toString());
		request.setAttribute("list", r); //������ ������
		request.setAttribute("listrc", listrc); //���� ��� ���
		RequestDispatcher dis = request.getRequestDispatcher("recipe_view.jsp");
		dis.forward(request, response);
	}
}
