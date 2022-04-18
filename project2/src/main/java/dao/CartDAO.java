package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import model.Cart;
import model.CartFile;

public class CartDAO {
	Statement stmt;
	PreparedStatement pstmt;
	ResultSet rs;
	
	DAO d = new DAO(); //d.getCon()
	
	//아이디 존재여부
	public int loginSelect(String session_id) {
		d.getCon();
		
		int sum = 0;
		try {
			String sql = "select count(*) from member where id = ? and none = '1'";
			pstmt = d.conn.prepareStatement(sql);
			
			pstmt.setString(1, session_id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {		
				sum = rs.getInt(1);
		
			}
			
			rs.close();
			pstmt.close();
			d.conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sum;
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
	
	//한건의 장바구니 정보
	public int oneCartSelect(int pro_uid, String id, String cart_session) {
		d.getCon();
		
		int result = 0;
		
		try {
			String sql = "select * from cart where pro_uid = ? and id = ? and cart_session=?";
			pstmt = d.conn.prepareStatement(sql);
			
			pstmt.setInt(1, pro_uid);
			pstmt.setString(2, id);
			pstmt.setString(3, cart_session);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = rs.getInt("pro_count");
			}
			
			rs.close();
			pstmt.close();
			d.conn.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return result;
	}
	
	//장바구니 수정
	public void updateCart(int pro_count, int pro_uid, String cart_session, String session_id) {
		d.getCon();
		
		try {
			String sql = "update cart set pro_count=? where pro_uid = ? and cart_session=? and id = ?";
			pstmt = d.conn.prepareStatement(sql);
			
			
			pstmt.setInt(1, pro_count);
			pstmt.setInt(2, pro_uid);
			pstmt.setString(3, cart_session);
			pstmt.setString(4, session_id);	
			
			pstmt.executeUpdate();
			
			pstmt.close();
			d.conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	//장바구니 목록	
	public ArrayList<CartFile> getAllCart(String session_id, int startRow, int endRow){
		d.getCon();
		
		ArrayList<CartFile> c = new ArrayList<CartFile>();
		
		try {
			String sql = "select *,(select file1 from product where cart.pro_uid = product.pro_uid) as file1 from cart where id=? and pay_ok = '3' order by uid desc limit ?,?";
			pstmt = d.conn.prepareStatement(sql);
			
			pstmt.setString(1, session_id);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				CartFile p = new CartFile();
				
				p.setPro_uid(rs.getInt("pro_uid"));
				p.setPro_name(rs.getString("pro_name"));
				p.setPro_id(rs.getString("pro_id"));
				p.setId(rs.getString("id"));
				p.setCart_session(rs.getString("cart_session"));
				p.setPro_price(rs.getInt("pro_price"));
				p.setPro_point(rs.getInt("pro_point"));
				p.setPro_count(rs.getInt("pro_count"));
				p.setFile1(rs.getString("file1"));
				p.setPay_ok(rs.getString("pay_ok"));
				
				c.add(p);
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
		return c;
	}
	
	//전체 장바구니 수
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
	
	//카트 목록 삭제
	public void deleteCart(int pro_uid) {
		d.getCon();
		try {
			String sql = "delete from cart where pro_uid = ?";
			pstmt = d.conn.prepareStatement(sql);
			
			pstmt.setInt(1, pro_uid);
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
				d.conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
	}
	
	//카트 목록 전체삭제
	public void allDelete(String session_id) {
		d.getCon();
		try {
			String sql = "delete from cart where id = ?";
			pstmt = d.conn.prepareStatement(sql);
			
			pstmt.setString(1, session_id);
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
				d.conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
	}
	
	//카트 수량변경
	public void pointChange(int pro_uid,int pro_count, String session_id, String session_cart) {
		d.getCon();
		try {
			String sql = "update cart set pro_count = ? where pro_uid = ? , cart_session = ? , id=? ";
			pstmt = d.conn.prepareStatement(sql);
			
			pstmt.setInt(1, pro_count);
			pstmt.setInt(2, pro_uid);
			pstmt.setString(3, session_cart);
			pstmt.setString(4, session_id);
			
			pstmt.executeUpdate();
			
			pstmt.close();
			d.conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}




























