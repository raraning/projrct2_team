package seller;

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
import javax.servlet.http.Part;

import com.sun.jimi.core.Jimi;
import com.sun.jimi.core.JimiUtils;

import dao.ProductDAO;
import model.Product;

@WebServlet("/seller/product_register_insert")
@MultipartConfig(
		fileSizeThreshold=0,
		location = "C:\\jsp\\project2\\src\\main\\webapp\\upload"
	)
public class SellerProductRegisterInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public SellerProductRegisterInsert() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String file_01 = "";
		String file_02 = "";
		String file_03 = "";
		String thum_img1 = "";
		String thum_img2 = "";
		String thum_img3 = "";
		String uploadFileNameList = "";

		
		for(Part part : request.getParts()) {
			if((part.getName().equals("file1") || part.getName().equals("file2") || part.getName().equals("file3")) && part.getSize() > 0) {
				String contentDisposition = part.getHeader("content-disposition");
				String uploadFileName = getUploadFileName(contentDisposition);	
				
				//현재 시간
				Date nowTime = new Date();
				SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddhhmmss");
				String today = sf.format(nowTime);
				
				uploadFileName = today+"_"+uploadFileName; //session_id 추가해도됨(중복을 피하기위한 파일명에 날짜추가)
				
				if(part.getName().equals("file1")){ //리스트 목록 해당하는 이미지
					file_01 = uploadFileName;
				}else if(part.getName().equals("file2")){
					file_02 = uploadFileName;
				}else{
					file_03 = uploadFileName;
				}
				
				part.write(uploadFileName);
				uploadFileNameList += " " + uploadFileName;
				
				if(file_01 != "") {
					String uploadPath = "C:\\jsp\\project2\\src\\main\\webapp\\upload";
					String filePath = uploadPath; //저장 공간 경로 설정
				    String orgImg = filePath+"\\"+file_01; //리네임처리된 첨부파일
				    
				  //확장자 찾기
					int pos = orgImg.lastIndexOf( "." );
				 	String fileExt = orgImg.substring( pos + 1 );
				 	
				 	
				  	if(fileExt.equals("gif") || fileExt.equals("jpg") || fileExt.equals("png")){
				  		thum_img1 = "thum_"+file_01; //썸네일 파일 이름
				  	    String thumbImg = filePath+"\\"+thum_img1;//썸네일파일
				  	    int thumbWidth = 200 ;//썸네일 가로
				  	    int thumbHeight = 200 ;//썸네일 세로
				  	    
					    try {
				  	    	Image thumbnail = JimiUtils.getThumbnail(orgImg, thumbWidth, thumbHeight, Jimi.IN_MEMORY);// 썸네일 설정
					  	    Jimi.putImage(thumbnail, thumbImg);// 썸네일 생성	
						} catch (Exception e) {
							e.printStackTrace();
						} 
				  	}
				}
				
				if(file_02 != "") {
					String uploadPath = "C:\\jsp\\project2\\src\\main\\webapp\\upload";
					String filePath = uploadPath; //저장 공간 경로 설정
				    String orgImg = filePath+"\\"+file_02; //리네임처리된 첨부파일
				    
				  //확장자 찾기
					int pos = orgImg.lastIndexOf( "." );
				 	String fileExt = orgImg.substring( pos + 1 );
				 	
				 	
				  	if(fileExt.equals("gif") || fileExt.equals("jpg") || fileExt.equals("png")){
				  		thum_img2 = "thum_"+file_02; //썸네일 파일 이름
				  	    String thumbImg = filePath+"\\"+thum_img2;//썸네일파일
				  	    int thumbWidth = 200 ;//썸네일 가로
				  	    int thumbHeight = 200 ;//썸네일 세로
				  	    
					    try {
				  	    	Image thumbnail = JimiUtils.getThumbnail(orgImg, thumbWidth, thumbHeight, Jimi.IN_MEMORY);// 썸네일 설정
					  	    Jimi.putImage(thumbnail, thumbImg);// 썸네일 생성	
						} catch (Exception e) {
							e.printStackTrace();
						} 
				  	}
				}
				
				if(file_03 != "") {
					String uploadPath = "C:\\jsp\\project2\\src\\main\\webapp\\upload";
					String filePath = uploadPath; //저장 공간 경로 설정
				    String orgImg = filePath+"\\"+file_03; //리네임처리된 첨부파일
				    
				  //확장자 찾기
					int pos = orgImg.lastIndexOf( "." );
				 	String fileExt = orgImg.substring( pos + 1 );
				 	
				 	
				  	if(fileExt.equals("gif") || fileExt.equals("jpg") || fileExt.equals("png")){
				  		thum_img3 = "thum_"+file_03; //썸네일 파일 이름
				  	    String thumbImg = filePath+"\\"+thum_img3;//썸네일파일
				  	    int thumbWidth = 200 ;//썸네일 가로
				  	    int thumbHeight = 200 ;//썸네일 세로
				  	    
					    try {
				  	    	Image thumbnail = JimiUtils.getThumbnail(orgImg, thumbWidth, thumbHeight, Jimi.IN_MEMORY);// 썸네일 설정
					  	    Jimi.putImage(thumbnail, thumbImg);// 썸네일 생성	
						} catch (Exception e) {
							e.printStackTrace();
						} 
				  	}
				}
			}
		}
		
		
		Product sp = new Product();
		
		//데이터 저장하기
		sp.setPro_id(request.getParameter("pro_id"));
		sp.setPro_salname(request.getParameter("pro_salname"));
		sp.setPro_manuname(request.getParameter("pro_manuname"));
		sp.setPro_name(request.getParameter("pro_name"));
		sp.setPro_class(request.getParameter("pro_class"));
		sp.setPro_category(request.getParameter("pro_category"));
		sp.setPro_available(Integer.parseInt(request.getParameter("pro_available")));
		sp.setPro_price(Integer.parseInt(request.getParameter("pro_price")));
		sp.setPro_indate(request.getParameter("pro_indate"));
		sp.setFile1(file_01);
		sp.setFile1_o(file_01);
		sp.setFile1_s(thum_img1);
		sp.setFile2(file_02);
		sp.setFile2_o(file_02);
		sp.setFile2_s(thum_img2);
		sp.setFile3(file_03);
		sp.setFile3_o(file_03);
		sp.setFile3_s(thum_img3);
		sp.setPro_detailing(request.getParameter("pro_detailing"));
		sp.setPro_point(Integer.parseInt(request.getParameter("pro_point")));
		System.out.println(sp.toString());
		ProductDAO dao = new ProductDAO();
		
		dao.insertProduct(sp);
		

		
		
		
		response.sendRedirect("seller_product_list");		
	}
	
	//Chrome 브라우저 일때
	private String getUploadFileName(String contentDisposition) {
		String uploadFileName = null;
		String[] contentSplitStr = contentDisposition.split(";");
		int firstQutosIndex = contentSplitStr[2].indexOf("\"");
		int lastQutosIndex = contentSplitStr[2].lastIndexOf("\"");
		uploadFileName = contentSplitStr[2].substring(firstQutosIndex + 1, lastQutosIndex);
		return uploadFileName;

	}

}
