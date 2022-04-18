package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import model.Recipe;
import model.RecipeComment;

public class RecipeDAO {
	Statement stmt;
	PreparedStatement pstmt;
	ResultSet rs;
	
	DAO d = new DAO(); //d.getCon()
	
	public void insertRecipe(Recipe r) { //������ ����ϱ�
		d.getCon();
		
		try {
			String sql = "insert into recipe (uid,id,name,subject,comment,signdate,quantity,cooktime,cooklevel,ingredient,file1,file1_o,file1_s) values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
			pstmt = d.conn.prepareStatement(sql);
			
			pstmt.setInt(1, r.getUid());
			pstmt.setString(2, r.getId());
			pstmt.setString(3, r.getName());
			pstmt.setString(4, r.getSubject());
			pstmt.setString(5, r.getComment());
			pstmt.setString(6, r.getSigndate());
			pstmt.setString(7, r.getQuantity());
			pstmt.setString(8, r.getCooktime());
			pstmt.setString(9, r.getCooklevel());
			pstmt.setString(10, r.getIngredient());
			pstmt.setString(11, r.getFile1());
			pstmt.setString(12, r.getFile1_o());
			pstmt.setString(13, r.getFile1_s());
			
			pstmt.executeUpdate();
			
			pstmt.close();
			d.conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//������ �Խ��ǿ� �Խù� ����ϱ� - ArrayList ������� �����ϱ� ����� ������� ���̱�
	public ArrayList<Recipe> getAllRecipe(int startRow, int endRoW, String field, String search){
		d.getCon();
		
		ArrayList<Recipe> v = new ArrayList<Recipe>();
		
		try {
			String sql = "";
			if(search != null && search.equals("")) {
				sql = "select * from recipe where "+field+" like '%"+search+"%' order by uid desc limit ?,?";
			}else {
				sql = "select * from recipe order by uid desc limit ?,?";
			}
			pstmt = d.conn.prepareStatement(sql);
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRoW);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Recipe r = new Recipe();
				
				r.setUid(rs.getInt("uid"));
				r.setId(rs.getString("id"));
				r.setName(rs.getString("name"));
				r.setSubject(rs.getString("subject"));
				r.setComment(rs.getString("comment"));
				r.setSigndate(rs.getString("signdate"));
				r.setRef(rs.getInt("ref"));
				r.setQuantity(rs.getString("quantity"));
				r.setCooktime(rs.getString("cooktime"));
				r.setCooklevel(rs.getString("cooklevel"));
				r.setIngredient(rs.getString("ingredient"));
				r.setFile1(rs.getString("file1"));
				r.setFile1_o(rs.getString("file1_o"));
				r.setFile1_s(rs.getString("file1_s"));
				r.setFid(rs.getInt("fid"));
				r.setThread(rs.getString("thread"));
				
				v.add(r);
			}
			rs.close();
			pstmt.close();
			d.conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return v;
	}
	
	//��ü �Խñ� �� 
	public int getAllRecipe(String field, String search) {
		d.getCon();
		
		int num = 0;
		
		try {
			String sql = "";
			
			if(search != null && search.equals("")) { //�˻�� �ִٸ�
				sql = "select count(*) from recipe where "+field+" like '%"+search+"%'";
			}else {
				sql = "select count(*) from recipe";
			}
			
			pstmt = d.conn.prepareStatement(sql);
			
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
	
	//�Խñ� ��ȸ�� ����
	public void recipeRef(int ref) {
		d.getCon();
		
		try {
			String sql = "update recipe set ref = ref + 1 where uid=?";
			pstmt = d.conn.prepareStatement(sql);
			
			pstmt.setInt(1, ref);
			
			pstmt.executeUpdate();
			
			pstmt.close();
			d.conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//����� ����� �̸��� �´� �Խñ��� ������ ��������
	public Recipe recipeSelect(String subject, String comment, String name) {
		d.getCon();
		
		Recipe r = new Recipe();
		
		try {
			String sql = "select * from recipe where subject=? and comment=? and name=?";
			pstmt = d.conn.prepareStatement(sql);
			
			pstmt.setString(3, subject);
			pstmt.setString(4, comment);
			pstmt.setString(2, name);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				r.setUid(rs.getInt("uid"));
				r.setId(rs.getString("id"));
				r.setName(rs.getString("name"));
				r.setSubject(rs.getString("subject"));
				r.setComment(rs.getString("comment"));
				r.setSigndate(rs.getString("signdate"));
				r.setRef(rs.getInt("ref"));
				r.setQuantity(rs.getString("quantity"));
				r.setCooktime(rs.getString("cooktime"));
				r.setCooklevel(rs.getString("cooklevel"));
				r.setIngredient(rs.getString("ingredient"));
				r.setFile1(rs.getString("file1"));
				r.setFile1_o(rs.getString("file1_o"));
				r.setFile1_s(rs.getString("file1_s"));
				r.setFid(rs.getInt("fid"));
				r.setThread(rs.getString("thread"));
			}
			rs.close();
			pstmt.close();
			d.conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return r;
	}
	
	//�Խñ� �����ϱ� - ������ �� �ҷ����� 
	public Recipe oneRecipeModify(int uid){
		d.getCon();
		
		Recipe r = new Recipe();
		
		try {
			String sql = "select * from recipe where uid=?";
			pstmt = d.conn.prepareStatement(sql);
			
			pstmt.setInt(1, uid);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				r.setUid(rs.getInt("uid"));
				r.setSubject(rs.getString("subject"));
				r.setComment(rs.getString("comment"));
				r.setSigndate(rs.getString("signdate"));
				r.setQuantity(rs.getString("quantity"));
				r.setCooktime(rs.getString("cooktime"));
				r.setCooklevel(rs.getString("cooklevel"));
				r.setIngredient(rs.getString("ingredient"));
				r.setFile1(rs.getString("file1"));
				r.setFile1_o(rs.getString("file1_o"));
				r.setFile1_s(rs.getString("file1_s"));
			}
			rs.close();
			pstmt.close();
			d.conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return r;
	}
	
	//�Խñ� �����ϱ� - �����ϰ� ������Ʈ�ϱ�
	public void updateRecipe(Recipe r) {
		d.getCon();
		
		try {
			String sql = "update recipe set subject=?,comment=?,quantity=?,cooktime=?,cooklevel=?,ingredient=? where uid=?";
			pstmt = d.conn.prepareStatement(sql);			
			
			pstmt.setString(1, r.getSubject());
			pstmt.setString(2, r.getComment());
			pstmt.setString(3, r.getQuantity());
			pstmt.setString(4, r.getCooktime());
			pstmt.setString(5, r.getCooklevel());
			pstmt.setString(6, r.getIngredient());
			pstmt.setInt(7, r.getUid());
			
			pstmt.executeUpdate();
			
			pstmt.close();
			d.conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//�Խñ� �� ���� ����
	public Recipe oneRecipe(int uid) {
		d.getCon();
		
		Recipe r = new Recipe();
		
		try {
			String sql = "select * from recipe where uid=?";
			pstmt = d.conn.prepareStatement(sql);
			
			pstmt.setInt(1, uid);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				r.setUid(rs.getInt("uid"));
				r.setSubject(rs.getString("subject"));
				r.setComment(rs.getString("comment"));
				r.setSigndate(rs.getString("signdate"));
				r.setQuantity(rs.getString("quantity"));
				r.setCooktime(rs.getString("cooktime"));
				r.setCooklevel(rs.getString("cooklevel"));
				r.setIngredient(rs.getString("ingredient"));
				r.setFile1(rs.getString("file1"));
				r.setFile1_o(rs.getString("file1_o"));
				r.setFile1_s(rs.getString("file1_s"));
			}
			rs.close();
			pstmt.close();
			d.conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return r;
	}
	
	//�Խñ� �����ϱ�
	public void deleteRecipe(int uid) {
		d.getCon();
		
		try {
			String sql = "delete from recipe where uid=?";
			pstmt = d.conn.prepareStatement(sql);
			
			pstmt.setInt(1, uid);
			
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
}
