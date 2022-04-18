package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import model.Cart;
import model.CartFile;
import model.ProsaveFile;

public class MyDAO {

	Statement stmt;
	PreparedStatement pstmt;
	ResultSet rs;
	
	DAO d = new DAO(); //d.getCon()
	
	//아이디 존재여부
	public int loginSelect(String session_id) {
		d.getCon();
		
		int num = 0;
		try {
			String sql = "select count(*) from member where id = ? and none = '1'";
			pstmt = d.conn.prepareStatement(sql);
			
			pstmt.setString(1, session_id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {		
				num = rs.getInt(1);
		
			}
			
			rs.close();
			pstmt.close();
			d.conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return num;
	}
	
	
	//찜 목록
	public ArrayList<ProsaveFile> getAllMySave(String session_id, int startRow, int endRow){
		d.getCon();
		
		ArrayList<ProsaveFile> m = new ArrayList<ProsaveFile>();
		
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
				s.setPro_count(rs.getInt("pro_count"));
				s.setFile1(rs.getString("file1"));
				
				m.add(s);
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
		return m;
	}
	
	//my페이지 전체 목록 수
	public int getAllCount(String session_id) {
		d.getCon();
		
		int num = 0;
		try {
			String sql = "select count(*) as total_count from cart where id = ?";
			
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
	
	//찜 목록 삭제
	public void myDelete (int pro_uid) {
		d.getCon();
		
		try {
			String sql = "delete from prosave where pro_uid = ?";
			pstmt = d.conn.prepareStatement(sql);
			
			pstmt.setInt(1, pro_uid);
			
			pstmt.executeUpdate();
			
			pstmt.close();
			d.conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//장바구니 담기
	public void insertMyCart(Cart c,int pro_uid) {
		d.getCon();
		
		try {
			String sql = "insert into cart(pro_uid,pro_name, pro_id, id, cart_session, pro_price, pro_point,pro_count, pay_ok)"
						+"select pro_uid, pro_name, pro_id, id, cart_session, pro_price, pro_point,pro_count,"
					    +"pay_ok from prosave where pro_uid="+pro_uid;
			pstmt = d.conn.prepareStatement(sql);
			
			pstmt.executeUpdate();
			
			pstmt.close();
			d.conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//장바구니 목록 수정
	public void updateMyCart(Cart u, int pro_uid) {
		d.getCon();
		
		try {
			String sql = "update cart as c, (select pro_uid,pro_name, pro_id, id, "
						+"cart_session, pro_price, pro_point,pro_count, pay_ok from prosave) as p\r\n"
						+ "set c.pro_uid=p.pro_uid, c.pro_name=p.pro_name, c.pro_id=p.pro_id, c.id=p.id, c.cart_session=p.cart_session, c.pro_price=p.pro_price, "
						+"c.pro_point=p.pro_point, c.pro_count=p.pro_count, c.pay_ok=p.pay_ok where c.pro_uid = p.pro_uid;";
			pstmt = d.conn.prepareStatement(sql);
			
			pstmt.executeUpdate();
			
			pstmt.close();
			d.conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	////////////////////////////  내가 구매한 제품  ///////////////////////////////////////
	
	//구매 목록
	public ArrayList<CartFile> getAllMyBuy(String session_id, int startRow, int endRow){
		d.getCon();
		ArrayList<CartFile> o = new ArrayList<CartFile>();
		try {
			String sql = "select *,(select file1 from product where cart.pro_uid = product.pro_uid) as file1 from cart where id=? and (pay_ok='1' or pay_ok='2' or pay_ok='4') order by uid desc limit ?,?";
			pstmt = d.conn.prepareStatement(sql);
			
			pstmt.setString(1, session_id);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				CartFile s = new CartFile();
				
				s.setPro_uid(rs.getInt("pro_uid"));
				s.setPro_name(rs.getString("pro_name"));
				s.setPro_id(rs.getString("pro_id"));
				s.setId(rs.getString("id"));
				s.setCart_session(rs.getString("cart_session"));
				s.setPro_price(rs.getInt("pro_price"));
				s.setPro_price(rs.getInt("pro_point"));
				s.setPro_count(rs.getInt("pro_count"));
				s.setPay_ok(rs.getString("pay_ok"));
				s.setFile1(rs.getString("file1"));
				
				o.add(s);
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
		return o;
	}
	
	//cart 존재여부 Check
	public int cartSelectCheck(int pro_uid,String session_id, String pay_ok) {
		d.getCon();
		int cart_num = 0;
		try {
			String sql= "select * from cart where pro_uid=? and id = ? and pay_ok = ?";
			pstmt = d.conn.prepareStatement(sql);
			
			pstmt.setInt(1, pro_uid);
			pstmt.setString(2, session_id);
			pstmt.setString(3, pay_ok);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				cart_num = rs.getInt(1);
				
			}
			rs.close();
			pstmt.close();
			d.conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cart_num;
	}
	
	//장바구니 담기
	public void insertCart(Cart c) {
		d.getCon();
		
		try {
			String sql = "insert into cart (pro_uid, pro_name, pro_id, id, cart_session, pro_price, pro_point, pro_count,pay_ok) values (?,?,?,?,?,?,?,?,?)";
			pstmt = d.conn.prepareStatement(sql);
			
			pstmt.setInt(1, c.getPro_uid());
			pstmt.setString(2, c.getPro_name());
			pstmt.setString(3, c.getPro_id());
			pstmt.setString(4, c.getId());
			pstmt.setString(5, c.getCart_session());
			pstmt.setInt(6, c.getPro_price());
			pstmt.setInt(7, c.getPro_point());
			pstmt.setInt(8, c.getPro_count());
			pstmt.setString(9, c.getPay_ok());
			
			pstmt.executeUpdate();
			
			pstmt.close();
			d.conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
}






















