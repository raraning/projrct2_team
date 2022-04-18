package recipe;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.RecipeDAO;
import model.Recipe;

@WebServlet("/recipe/recipe_modify_insert")
public class ModifyInsertRecipe extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ModifyInsertRecipe() {
        super();
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		Recipe r = new Recipe();
		
		int uid = Integer.parseInt(request.getParameter("uid"));	
		
		r.setSubject(request.getParameter("subject"));
		r.setComment(request.getParameter("comment"));
		r.setSigndate(request.getParameter("signdate"));
		r.setQuantity(request.getParameter("quantity"));
		r.setCooktime(request.getParameter("cooktime"));
		r.setCooklevel(request.getParameter("cooklevel"));
		r.setIngredient(request.getParameter("ingredient"));
		r.setFile1(request.getParameter("file1"));
		r.setFile1_o(request.getParameter("file1_o"));
		r.setFile1_s(request.getParameter("file1_s"));
		r.setUid(Integer.parseInt(request.getParameter("uid")));
		
		RecipeDAO dao = new RecipeDAO();
		dao.updateRecipe(r);
		
		response.sendRedirect("recipe_view?uid="+uid);
	}
}
