package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import model.Product;

public class ProductDAO {
	Statement stmt;
	PreparedStatement pstmt;
	ResultSet rs;
	
	DAO d = new DAO(); //d.getCon()
	
	public void insertProduct(Product sp) {
		d.getCon(); //�ȶ� �ε���ش�
		
		try {
			String sql = "insert into product (pro_id,pro_uid,pro_manuname,pro_salname,pro_name,pro_class,pro_category,pro_available,pro_price,pro_indate,file1,file1_o,file1_s,file2,file2_o,file2_s,file3,file3_o,file3_s,pro_detailing,pro_point) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			pstmt = d.conn.prepareStatement(sql);
			
			pstmt.setString(1, sp.getPro_id());
			pstmt.setInt(2, sp.getPro_uid());
			pstmt.setString(3, sp.getPro_manuname());
			pstmt.setString(4, sp.getPro_salname());
			pstmt.setString(5, sp.getPro_name());
			pstmt.setString(6, sp.getPro_class());
			pstmt.setString(7, sp.getPro_category());
			pstmt.setInt(8, sp.getPro_available());
			pstmt.setInt(9, sp.getPro_price());
			pstmt.setString(10, sp.getPro_indate());
			pstmt.setString(11, sp.getFile1());
			pstmt.setString(12, sp.getFile1_o());
			pstmt.setString(13, sp.getFile1_s());
			pstmt.setString(14, sp.getFile2());
			pstmt.setString(15, sp.getFile2_o());
			pstmt.setString(16, sp.getFile2_s());
			pstmt.setString(17, sp.getFile3());
			pstmt.setString(18, sp.getFile3_o());
			pstmt.setString(19, sp.getFile3_s());
			pstmt.setString(20, sp.getPro_detailing());
			pstmt.setInt(21, sp.getPro_point());
			
			pstmt.executeUpdate();
			
			pstmt.close();
			d.conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//��ǰ����Ʈ, ī�װ��� ����Ʈ ���
	public ArrayList<Product> getAllProduct(int startRow, int endRow, String field, String search, String pro_class, String category){
		d.getCon();
		
		ArrayList<Product> v = new ArrayList<Product>();
		
		try {
			String sql = "";
			
			if(search != null && !search.equals("")) {
				if(category != null && !category.equals("")) {
					sql = "select * from product where "+field+" like '%"+search+"%' and pro_category='"+category+"' order by pro_uid desc limit ?,?";
				}else if(pro_class != null && !pro_class.equals("")) {
					sql = "select * from product where "+field+" like '%"+search+"%' and pro_class='"+pro_class+"' order by pro_uid desc limit ?,?";
				}else {
					sql = "select * from product where "+field+" like '%"+search+"%' order by pro_uid desc limit ?,?";
				}
			}else {
				if(category != null && !category.equals("")) {
					sql = "select * from product where pro_category='"+category+"' order by pro_uid desc limit ?,?";
				}else if(pro_class != null && !pro_class.equals("")) {
					sql = "select * from product where pro_class='"+pro_class+"' order by pro_uid desc limit ?,?";
				}else {
					sql = "select * from product order by pro_uid desc limit ?,?";
				}
			}
			pstmt = d.conn.prepareStatement(sql);
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Product sp = new Product();
				
				sp.setPro_id(rs.getString("pro_id"));
				sp.setPro_uid(rs.getInt("pro_uid"));
				sp.setPro_manuname(rs.getString("pro_manuname"));
				sp.setPro_salname(rs.getString("pro_salname"));
				sp.setPro_name(rs.getString("pro_name"));
				sp.setPro_class(rs.getString("pro_class"));
				sp.setPro_category(rs.getString("pro_category"));
				sp.setPro_available(rs.getInt("pro_available"));
				sp.setPro_price(rs.getInt("pro_price"));
				sp.setPro_indate(rs.getString("pro_indate"));
				sp.setFile1(rs.getString("file1"));
				sp.setFile1_o(rs.getString("file1_o"));
				sp.setFile1_s(rs.getString("file1_s"));
				sp.setFile2(rs.getString("file2"));
				sp.setFile2_o(rs.getString("file2_o"));
				sp.setFile2_s(rs.getString("file2_s"));
				sp.setFile3(rs.getString("file3"));
				sp.setFile3_o(rs.getString("file3_o"));
				sp.setFile3_s(rs.getString("file3_s"));
				sp.setPro_detailing(rs.getString("pro_detailing"));
				sp.setPro_point(rs.getInt("pro_point"));
				
				v.add(sp);
			}
			
			rs.close();
			pstmt.close();
			d.conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return v;
	}
	
	
	//�������ݼ� buyer_product_list ���
	public ArrayList<Product> getHighPriceProduct(int startRow, int endRow, String field, String search, String pro_class, String category){
		d.getCon();
		
		ArrayList<Product> highprice = new ArrayList<Product>();
		
		try {
			String sql = "";
			
			if(search != null && !search.equals("")) {
				if(category != null && !category.equals("")) {
					sql = "select * from product where "+field+" like '%"+search+"%' and pro_category='"+category+"' order by pro_price desc limit ?,?";
				}else if(pro_class != null && !pro_class.equals("")) {
						sql = "select * from product where "+field+" like '%"+search+"%' and pro_class='"+pro_class+"' order by pro_price desc limit ?,?";
				}else {
					sql = "select * from product where "+field+" like '%"+search+"%' order by pro_price desc limit ?,?";
				}
			}else {
				if(category != null && !category.equals("")) {
					sql = "select * from product where pro_category='"+category+"' order by pro_price desc limit ?,?";
				}else if(pro_class != null && !pro_class.equals("")) {
					sql = "select * from product where pro_class='"+pro_class+"' order by pro_price desc limit ?,?";
				}else {
					sql = "select * from product order by pro_price desc limit ?,?";
				}
			}
			
			pstmt = d.conn.prepareStatement(sql);
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Product sp = new Product();
				
				sp.setPro_id(rs.getString("pro_id"));
				sp.setPro_uid(rs.getInt("pro_uid"));
				sp.setPro_manuname(rs.getString("pro_manuname"));
				sp.setPro_salname(rs.getString("pro_salname"));
				sp.setPro_name(rs.getString("pro_name"));
				sp.setPro_class(rs.getString("pro_class"));
				sp.setPro_category(rs.getString("pro_category"));
				sp.setPro_available(rs.getInt("pro_available"));
				sp.setPro_price(rs.getInt("pro_price"));
				sp.setPro_indate(rs.getString("pro_indate"));
				sp.setFile1(rs.getString("file1"));
				sp.setFile1_o(rs.getString("file1_o"));
				sp.setFile1_s(rs.getString("file1_s"));
				sp.setFile2(rs.getString("file2"));
				sp.setFile2_o(rs.getString("file2_o"));
				sp.setFile2_s(rs.getString("file2_s"));
				sp.setFile3(rs.getString("file3"));
				sp.setFile3_o(rs.getString("file3_o"));
				sp.setFile3_s(rs.getString("file3_s"));
				sp.setPro_detailing(rs.getString("pro_detailing"));
				sp.setPro_point(rs.getInt("pro_point"));
				
				highprice.add(sp);
			}
			
			rs.close();
			pstmt.close();
			d.conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return highprice;
	}


	//�������ݼ� buyer_product_list ���
		public ArrayList<Product> getLowPriceProduct(int startRow, int endRow, String field, String search, String pro_class, String category){
			d.getCon();
			
			ArrayList<Product> lowprice = new ArrayList<Product>();
			
			try {
				String sql = "";
				
				if(search != null && !search.equals("")) {
					if(category != null && !category.equals("")) {
						sql = "select * from product where "+field+" like '%"+search+"%' and pro_category='"+category+"' order by pro_price asc limit ?,?";
					}else if(pro_class != null && !pro_class.equals("")) {
							sql = "select * from product where "+field+" like '%"+search+"%' and pro_class='"+pro_class+"' order by pro_price asc limit ?,?";
					}else {
						sql = "select * from product where "+field+" like '%"+search+"%' order by pro_price asc limit ?,?";
					}
				}else {
					if(category != null && !category.equals("")) {
						sql = "select * from product where pro_category='"+category+"' order by pro_price asc limit ?,?";
					}else if(pro_class != null && !pro_class.equals("")) {
						sql = "select * from product where pro_class='"+pro_class+"' order by pro_price asc limit ?,?";
					}else {
						sql = "select * from product order by pro_price asc limit ?,?";
					}
				}
				pstmt = d.conn.prepareStatement(sql);
				
				pstmt.setInt(1, startRow);
				pstmt.setInt(2, endRow);
				
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					Product sp = new Product();
					
					sp.setPro_id(rs.getString("pro_id"));
					sp.setPro_uid(rs.getInt("pro_uid"));
					sp.setPro_manuname(rs.getString("pro_manuname"));
					sp.setPro_salname(rs.getString("pro_salname"));
					sp.setPro_name(rs.getString("pro_name"));
					sp.setPro_class(rs.getString("pro_class"));
					sp.setPro_category(rs.getString("pro_category"));
					sp.setPro_available(rs.getInt("pro_available"));
					sp.setPro_price(rs.getInt("pro_price"));
					sp.setPro_indate(rs.getString("pro_indate"));
					sp.setFile1(rs.getString("file1"));
					sp.setFile1_o(rs.getString("file1_o"));
					sp.setFile1_s(rs.getString("file1_s"));
					sp.setFile2(rs.getString("file2"));
					sp.setFile2_o(rs.getString("file2_o"));
					sp.setFile2_s(rs.getString("file2_s"));
					sp.setFile3(rs.getString("file3"));
					sp.setFile3_o(rs.getString("file3_o"));
					sp.setFile3_s(rs.getString("file3_s"));
					sp.setPro_detailing(rs.getString("pro_detailing"));
					sp.setPro_point(rs.getInt("pro_point"));
					
					lowprice.add(sp);
				}
				
				rs.close();
				pstmt.close();
				d.conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return lowprice;
		}
		
	//��ü �Խñ� �� 
	public int getAllProduct(String field, String search) {
		d.getCon();
		
		int num = 0; //�ʱ�ȭ
		
		try {
			String sql = "";
			if(search != null && search.equals("")) {
				sql = "select count(*) from product where "+field+" like '%"+search+"%'";
			}else {
				sql = "select count(*) from product";
			}
			
			pstmt = d.conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				num = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return num;
	}	
	
	//��ǰ �Խñ� �����ϱ� - ������ �� �ҷ�����
	public Product oneProductModify(int pro_uid) {
		d.getCon();
		
		Product sp = new Product();
		
		try {
			String sql = "select * from product where pro_uid=?";
			pstmt = d.conn.prepareStatement(sql);
			
			pstmt.setInt(1, pro_uid);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				sp.setPro_id(rs.getString("pro_id"));
				sp.setPro_uid(rs.getInt("pro_uid"));
				sp.setPro_manuname(rs.getString("pro_manuname"));
				sp.setPro_salname(rs.getString("pro_salname"));
				sp.setPro_name(rs.getString("pro_name"));
				sp.setPro_class(rs.getString("pro_class"));
				sp.setPro_category(rs.getString("pro_category"));
				sp.setPro_available(rs.getInt("pro_available"));
				sp.setPro_price(rs.getInt("pro_price"));
				sp.setPro_indate(rs.getString("pro_indate"));
				sp.setFile1(rs.getString("file1"));
				sp.setFile1_s(rs.getString("file1_s"));
				sp.setFile2(rs.getString("file2"));
				sp.setFile2_s(rs.getString("file2_s"));
				sp.setFile3(rs.getString("file3"));
				sp.setFile3_s(rs.getString("file3_s"));
				sp.setPro_detailing(rs.getString("pro_detailing"));
				sp.setPro_point(rs.getInt("pro_point"));
				
			}
			rs.close();
			pstmt.close();
			d.conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sp;
	}
	
	//��ǰ �Խñ� �����ϱ� - �����ϰ� ������Ʈ�ϱ�
	public void updateProduct(Product sp) {
		d.getCon();
		
		try {
			String sql = "";
			String file1 = sp.getFile1();
			String file2 = sp.getFile2();
			String file3 = sp.getFile3();
			
			sql = "update product set pro_id=?,pro_manuname=?,pro_salname=?,pro_name=?,"
					+"pro_class=?,pro_category=?,pro_available=?,pro_price=?,"
					+"pro_indate=?,pro_detailing=?,pro_point=? where pro_uid= ?";
			pstmt = d.conn.prepareStatement(sql);
			
			pstmt.setString(1, sp.getPro_id());
			pstmt.setString(2, sp.getPro_manuname());
			pstmt.setString(3, sp.getPro_salname());
			pstmt.setString(4, sp.getPro_name());
			pstmt.setString(5, sp.getPro_class());
			pstmt.setString(6, sp.getPro_category());
			pstmt.setInt(7, sp.getPro_available());
			pstmt.setInt(8, sp.getPro_price());
			pstmt.setString(9, sp.getPro_indate());
			pstmt.setString(10, sp.getPro_detailing());
			pstmt.setInt(11, sp.getPro_point());
			pstmt.setInt(12, sp.getPro_uid());
			
			pstmt.executeUpdate();
			
			if(file1 != null && file1 != "") {				
				sql = "update product set file1=?,file1_o=?,file1_s=? where pro_uid= ?";
				pstmt = d.conn.prepareStatement(sql);
				
				pstmt.setString(1, sp.getFile1());
				pstmt.setString(2, sp.getFile1_o());
				pstmt.setString(3, sp.getFile1_s());
				pstmt.setInt(4, sp.getPro_uid());
				
				pstmt.executeUpdate();
			}
			
			if(file2 != null && file2 != "") {
				sql = "update product set file2=?,file2_o=?,file2_s=? where pro_uid= ?";
				pstmt = d.conn.prepareStatement(sql);
				
				pstmt.setString(1, sp.getFile2());
				pstmt.setString(2, sp.getFile2_o());
				pstmt.setString(3, sp.getFile2_s());
				pstmt.setInt(4, sp.getPro_uid());
				
				pstmt.executeUpdate();
			}
			
			if(file3 != null && file3 != "") {
				sql = "update product set file3=?,file3_o=?,file3_s=? where pro_uid= ?";
				pstmt = d.conn.prepareStatement(sql);
				
				pstmt.setString(1, sp.getFile3());
				pstmt.setString(2, sp.getFile3_o());
				pstmt.setString(3, sp.getFile3_s());
				pstmt.setInt(4, sp.getPro_uid());
				
				pstmt.executeUpdate();
			}
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
	
	
	//��ǰ �Խñ� ����
	public void deleteProduct(int pro_uid) {
		d.getCon();
		
		try {
			String sql = "delete from product where pro_uid=?";
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
	
	//������ ��ǰ �� ������ 
	public Product oneProductDetailing(int pro_uid) {
		d.getCon();
		
		Product sp = new Product();
		
		try {
			String sql = "select * from product where pro_uid=?";
			pstmt = d.conn.prepareStatement(sql);
			
			pstmt.setInt(1, pro_uid);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				sp.setPro_id(rs.getString("pro_id"));
				sp.setPro_uid(rs.getInt("pro_uid"));
				sp.setPro_manuname(rs.getString("pro_manuname"));
				sp.setPro_salname(rs.getString("pro_salname"));
				sp.setPro_name(rs.getString("pro_name"));
				sp.setPro_class(rs.getString("pro_class"));
				sp.setPro_category(rs.getString("pro_category"));
				sp.setPro_available(rs.getInt("pro_available"));
				sp.setPro_price(rs.getInt("pro_price"));
				sp.setPro_indate(rs.getString("pro_indate"));
				sp.setFile1(rs.getString("file1"));
				sp.setFile2(rs.getString("file2"));
				sp.setFile3(rs.getString("file3"));
				sp.setPro_detailing(rs.getString("pro_detailing"));
				sp.setPro_point(rs.getInt("pro_point"));
			}
			rs.close();
			pstmt.close();
			d.conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sp;
	}
	
	
	//���̵� ���� ����(��ٱ��� ���, ���ϱ�)
	//���̵� ���翩��
	
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
	
	//cart ->���� �������� insert
	public int cartSelectCheck(int pro_uid,String session_id,String cart_session) {
		d.getCon();
		int cart_num = 0;
		try {
			String sql= "select * from cart where pro_uid=? and id = ? and cart_session = ?";
			pstmt = d.conn.prepareStatement(sql);
			
			pstmt.setInt(1, pro_uid);
			pstmt.setString(2, session_id);
			pstmt.setString(3, cart_session);
			
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
	
	
	//��ٱ��Ͽ��� �ֹ��� ��ǰ ���
	public int zzipSelectCheck(int pro_uid,String session_id) {
		d.getCon();
		int zzim_num = 0;
		try {
			String sql= "select * from prosave where pro_uid=? and id = ?";
			pstmt = d.conn.prepareStatement(sql);
			
			pstmt.setInt(1, pro_uid);
			pstmt.setString(2, session_id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				zzim_num = rs.getInt(1);
				
			}
			rs.close();
			pstmt.close();
			d.conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return zzim_num;
	}
	
	
	
	
}
