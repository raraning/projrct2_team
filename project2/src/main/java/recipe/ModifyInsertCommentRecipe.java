package recipe;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.RecipeCommentDAO;
import model.RecipeComment;


@WebServlet("/recipe/recipe_comment_modify_insert")
public class ModifyInsertCommentRecipe extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ModifyInsertCommentRecipe() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		RecipeComment rc = new RecipeComment();
		
		int uid = Integer.parseInt(request.getParameter("uid"));
		
		rc.setRecipe_comment(request.getParameter("recipe_comment"));
		
		RecipeCommentDAO dao = new RecipeCommentDAO();
		dao.updateRecipeComment(rc);
		
		response.sendRedirect("recipe_view?uid="+uid);
	}

}
