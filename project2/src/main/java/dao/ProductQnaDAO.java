package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import model.ProductQna;

public class ProductQnaDAO {
	Statement stmt;
	PreparedStatement pstmt;
	ResultSet rs;
	
	DAO d = new DAO();
	
	public void InsertQna(ProductQna pq) {
		d.getCon();
		
		try {
			String sql = "insert into productqna (pro_uid,id,name,comment,signdate,qna,fid,thread) values (?,?,?,?,?,?,?,?)";
			pstmt = d.conn.prepareStatement(sql);
			
			pstmt.setInt(1, pq.getPro_uid());
			pstmt.setString(2, pq.getId());
			pstmt.setString(3, pq.getName());
			pstmt.setString(4, pq.getComment());
			pstmt.setString(5, pq.getSigndate());
			pstmt.setString(6, pq.getQna());
			pstmt.setInt(7, pq.getFid());
			pstmt.setString(8, pq.getThread());
			
			pstmt.executeUpdate();
			
			pstmt.close();
			d.conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public ArrayList<ProductQna> getQnaList(int startRow, int endRow, String field, String search){
		d.getCon();
		
		ArrayList<ProductQna> q = new ArrayList<ProductQna>();
			
		try {
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return q;
	}

}
