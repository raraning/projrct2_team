package recipe;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.RecipeDAO;
import model.Recipe;


@WebServlet("/recipe/recipe_modify")
public class ModifyRecipe extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ModifyRecipe() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int uid = Integer.parseInt(request.getParameter("uid"));
		
		RecipeDAO dao = new RecipeDAO();
		Recipe r = dao.oneRecipeModify(uid);
		
		request.setAttribute("list", r);
		RequestDispatcher dis = request.getRequestDispatcher("recipe_modify.jsp");
		dis.forward(request, response);
	}
}
