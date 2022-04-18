package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import model.Prosave;
import model.ProsaveFile;

public class ProSaveDAO {

	Statement stmt;
	PreparedStatement pstmt;
	ResultSet rs;
	
	DAO d = new DAO(); //d.getCon()
	

	//제품 찜하기
	public void proSave(Prosave p) {
		d.getCon();
		
		try {
			String sql = "insert into prosave (pro_uid, pro_name, pro_id, id, cart_session, pro_price, pro_point, pro_count,pay_ok) values (?,?,?,?,?,?,?,?,?)";
			pstmt = d.conn.prepareStatement(sql);
			
			pstmt.setInt(1, p.getPro_uid());
			pstmt.setString(2, p.getPro_name());
			pstmt.setString(3, p.getPro_id());
			pstmt.setString(4, p.getId());
			pstmt.setString(5, p.getCart_session());
			pstmt.setInt(6, p.getPro_price());
			pstmt.setInt(7, p.getPro_point());
			pstmt.setInt(8, p.getPro_count());
			pstmt.setString(9, p.getPay_ok());
			
			pstmt.executeUpdate();
			
			pstmt.close();
			d.conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//찜 목록
	
	public ArrayList<ProsaveFile> getAllProSave(String session_id, int startRow, int endRow){
		d.getCon();
		
		ArrayList<ProsaveFile> p = new ArrayList<ProsaveFile>();
		
		try {
			String sql = "select *,(select file1 from product where prosave.pro_uid = product.pro_uid) as file1 from prosave where id=? order by uid desc limit ?,?";
			pstmt = d.conn.prepareStatement(sql);
			
			pstmt.setString(1, session_id);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				ProsaveFile s = new ProsaveFile();
				
				s.setPro_uid(rs.getInt("pro_uid"));
				s.setPro_name(rs.getString("pro_name"));
				s.setPro_id(rs.getString("pro_id"));
				s.setId(rs.getString("id"));
				s.setCart_session(rs.getString("cart_session"));
				s.setPro_price(rs.getInt("pro_price"));
				s.setPro_point(rs.getInt("pro_point"));
				s.setPro_count(rs.getInt("pro_count"));
				s.setFile1(rs.getString("file1"));
				
				p.add(s);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				pstmt.close();
				d.conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return p;
	}
	
	//전체 장바구니 수
	public int getAllCount(String session_id) {
		d.getCon();
		
		int num = 0;
		try {
			String sql = "select count(*) as total_count from prosave where id = ?";
			
			pstmt = d.conn.prepareStatement(sql);
			
			pstmt.setString(1, session_id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				num = rs.getInt(1);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				pstmt.close();
				d.conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return num;
	}
}





















