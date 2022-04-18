package recipe;

import java.awt.Image;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.sun.jimi.core.Jimi;
import com.sun.jimi.core.JimiUtils;

import dao.RecipeDAO;
import model.Recipe;


@WebServlet("/recipe/recipe_insert")
@MultipartConfig(
		fileSizeThreshold=0,
		location = "C:\\jsp\\project2\\src\\main\\webapp\\upload"
	)
public class RecipeWriteInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public RecipeWriteInsert() {
        super();
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		//���� ���ε�
		Part part = request.getPart("file1");
		
		String contentDisposition = part.getHeader("content-disposition");
		String uploadFileName = getUploadFileName(contentDisposition);		
		
		HttpSession session = request.getSession();
		
		//���� �ð�
		Date nowTime = new Date();
		SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddhhmmss");
		String today = sf.format(nowTime);
		
		//�ߺ� ���� ����
		String uploadFileName2 = today+"_"+uploadFileName; //������
		part.write(uploadFileName2); //��ο� ���� ���� ó��
		System.out.println("===============:"+uploadFileName2);
		
		//�����
		String file1_s = "";		
		
		if(uploadFileName2 != "") {
			String filePath ="C:\\jsp\\project2\\src\\main\\webapp\\upload\\";	
			
			String orgImg = filePath+uploadFileName2; //��������
			file1_s = "thum_"+uploadFileName2; //���������
			String thumbImg = filePath+"thum_"+uploadFileName2;
			int thumbWidth = 60; //����� ����
			int thumbHeight = 60; //����� ����
			
			try {
				Image thumbnail = JimiUtils.getThumbnail(orgImg, thumbWidth, thumbHeight, Jimi.IN_MEMORY);// ����� ����

	        	Jimi.putImage(thumbnail, thumbImg);// ����� ����
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		Recipe r = new Recipe();
		
		r.setId((String)session.getAttribute("id"));
		r.setName((String)session.getAttribute("name"));
		r.setSubject(request.getParameter("subject"));
		r.setComment(request.getParameter("comment"));
		r.setSigndate(today);
		r.setQuantity(request.getParameter("quantity"));
		r.setCooktime(request.getParameter("cooktime"));
		r.setCooklevel(request.getParameter("cooklevel"));
		r.setIngredient(request.getParameter("ingredient"));
		r.setFile1(uploadFileName);
		r.setFile1_o(uploadFileName2);
		r.setFile1_s(file1_s);
		
		System.out.println(r.toString());
		
		RecipeDAO dao = new RecipeDAO();
		
		dao.insertRecipe(r);
		
		response.sendRedirect("recipe_list");
		
		
	}
	
	//Chrome ������ �϶�
	private String getUploadFileName(String contentDisposition) {
		String uploadFileName = null;
		String[] contentSplitStr = contentDisposition.split(";");
		int firstQutosIndex = contentSplitStr[2].indexOf("\"");
		int lastQutosIndex = contentSplitStr[2].lastIndexOf("\"");
		uploadFileName = contentSplitStr[2].substring(firstQutosIndex + 1, lastQutosIndex);
		return uploadFileName;
	}
}
