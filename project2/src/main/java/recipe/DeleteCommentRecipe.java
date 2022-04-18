package recipe;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.RecipeCommentDAO;


@WebServlet("/DeleteCommentRecipe")
public class DeleteCommentRecipe extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public DeleteCommentRecipe() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int uid = Integer.parseInt(request.getParameter("uid"));
		
		HttpSession session = request.getSession();
		
		String id = (String)session.getAttribute("id");
		
		RecipeCommentDAO dao = new RecipeCommentDAO();
		dao.deleteRecipeComment(uid);
		response.sendRedirect("/recipe/recipe_view");
	}

}
