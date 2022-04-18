package adminboard;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/admin/board/write")
public class Write extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public Write() {
        super();
    
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		String session_id = (String)session.getAttribute("id");
		String session_name = (String)session.getAttribute("name");
		String session_level = (String)session.getAttribute("level");
		
		RequestDispatcher dis = request.getRequestDispatcher("/admin/board/write.jsp");
		dis.forward(request, response);
	}


}
