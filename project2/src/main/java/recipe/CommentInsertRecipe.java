package recipe;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.RecipeCommentDAO;
import model.RecipeComment;


@WebServlet("/recipe/recipe_comment_insert")
public class CommentInsertRecipe extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public CommentInsertRecipe() {
        super();
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		RecipeCommentDAO dao = new RecipeCommentDAO();
		
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		String name = (String)session.getAttribute("name");

		//현재 시간
		Date nowTime = new Date();
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String today = sf.format(nowTime);
		
		RecipeComment rc = new RecipeComment();
		
		int uid = Integer.parseInt(request.getParameter("uid"));			

		rc.setRecipe_table(request.getParameter("recipe_table"));
		rc.setRecipe_uid(uid);
		rc.setRecipe_id(id);
		rc.setRecipe_name(name);
		rc.setRecipe_comment(request.getParameter("commentText"));
		rc.setRecipe_date(today);

		System.out.println(rc.toString());
		dao.insertRecipeComment(rc);
		
		response.sendRedirect("recipe_view?uid="+uid);
	}

}
