package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import model.Cart;
import model.CartFile;
import model.Order;

public class OrderDAO {
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
	
	//cart ->구매 페이지로 insert
	public void insertOrder(Order o) {
		d.getCon();
		
		try {
			String sql = "insert into order2 (pay_ok,howpay, howpay_num, bank1, bank1_get_name, bank1_give_name, cart_session,"
						+"get_name, get_phone, get_zipcode, get_zipcode1, get_zipcode2, get_zipcode3, get_zipcode4,"
						+"id, name, email, phone, zipcode, zipcode1, zipcode2, zipcode3, zipcode4, message) values "
						+"(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			pstmt = d.conn.prepareStatement(sql);
				
			pstmt.setString(1, o.getPay_ok());
			pstmt.setString(2, o.getHowpay());
			pstmt.setString(3, o.getHowpay_num());
			pstmt.setString(4, o.getBank1());
			pstmt.setString(5, o.getBank1_get_name());
			pstmt.setString(6, o.getBank1_give_name());
			pstmt.setString(7, o.getCart_session());
			
			pstmt.setString(8, o.getGet_name());
			pstmt.setString(9, o.getGet_phone());
			pstmt.setString(10, o.getGet_zipcode());
			pstmt.setString(11, o.getGet_zipcode1());
			pstmt.setString(12, o.getGet_zipcode2());
			pstmt.setString(13, o.getGet_zipcode3());
			pstmt.setString(14, o.getGet_zipcode4());
			
			pstmt.setString(15, o.getId());
			pstmt.setString(16, o.getName());
			pstmt.setString(17, o.getEmail());
			pstmt.setString(18, o.getPhone());
			pstmt.setString(19, o.getZipcode());
			pstmt.setString(20, o.getZipcode1());
			pstmt.setString(21, o.getZipcode2());
			pstmt.setString(22, o.getZipcode3());
			pstmt.setString(23, o.getZipcode4());
			pstmt.setString(24, o.getMessage());
			
			pstmt.executeUpdate();
			
			pstmt.close();
			d.conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	//장바구니에서 주문할 제품 목록
	public ArrayList<CartFile> getAllCart(String session_id, String cart_session){
		d.getCon();
		
		ArrayList<CartFile> c = new ArrayList<CartFile>();
		
		try {
			String sql = "select *,(select file1 from product where cart.pro_uid = product.pro_uid) as file1 from cart where pay_ok='3' and cart_session = ? and id=?";
			pstmt = d.conn.prepareStatement(sql);
			
			pstmt.setString(1, cart_session);
			pstmt.setString(2, session_id);
			
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
			e.printStackTrace();
		}
		
		return result;
	}
	
	//cart -> order  pay배송처리	
	public void updateCart(int pro_count, int pro_uid, String pay_ok, String cart_session, String session_id) {
		d.getCon();
		
		try {
			String sql = "update cart set pay_ok=case when cart_session="+cart_session+" and id="+session_id+" then ? end where cart_session="+cart_session+" and id="+session_id+";";
			pstmt = d.conn.prepareStatement(sql);
			
			pstmt.setString(1, pay_ok);	
			
			pstmt.executeUpdate();
			
			pstmt.close();
			d.conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
		
}






















