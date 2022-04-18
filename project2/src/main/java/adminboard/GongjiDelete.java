package adminboard;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AdminBoardDAO;


@WebServlet("/admin/board/delete")
public class GongjiDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public GongjiDelete() {
        super();
     
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int uid = Integer.parseInt(request.getParameter("uid"));
		
		AdminBoardDAO dao = new AdminBoardDAO();
		dao.outNotice(uid);
		
		response.sendRedirect("/admin/board/gongji_list");
	}

}
