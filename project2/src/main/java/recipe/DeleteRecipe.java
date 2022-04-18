package recipe;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.RecipeDAO;

@WebServlet("/recipe/recipe_delete")
public class DeleteRecipe extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public DeleteRecipe() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int uid = Integer.parseInt(request.getParameter("uid"));
		
		HttpSession session = request.getSession();
		
		String id = (String)session.getAttribute("id");
		
		RecipeDAO dao = new RecipeDAO();
		dao.deleteRecipe(uid);
		response.sendRedirect("/recipe/recipe_list");
	}
}
