package adminboard;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AdminBoardDAO;
import model.Notice;


@WebServlet("/admin/board/gongji_modify")
public class ModifyUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ModifyUpdate() {
        super();
      
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		//현재 시간
		Date nowTime = new Date();
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		String today = sf.format(nowTime);
		
		Notice n = new Notice();
		
		n.setUid(Integer.parseInt(request.getParameter("uid")));
		n.setPro_uid(Integer.parseInt(request.getParameter("pro_uid")));
		n.setId(request.getParameter("id"));
		n.setName(request.getParameter("name"));
		n.setSubject(request.getParameter("subject"));
		n.setComment(request.getParameter("comment"));
		n.setSigndate(today);
		
		System.out.println(n.toString());
		AdminBoardDAO dao = new AdminBoardDAO();
		dao.updateModify(n);
		
		response.sendRedirect("/admin/board/gongji_list");
	}

}
