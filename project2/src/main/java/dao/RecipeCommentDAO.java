package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import model.RecipeComment;

public class RecipeCommentDAO {
	Statement stmt;
	PreparedStatement pstmt;
	ResultSet rs;
	
	DAO d = new DAO(); //d.getCon()
	
	public void insertRecipeComment(RecipeComment rc) {  //댓글 등록하기
		d.getCon();
		
		try {
			String sql = "insert into recipe_comment (recipe_table,recipe_uid,recipe_id,recipe_name,recipe_comment,recipe_date) values (?,?,?,?,?,?)";
			pstmt = d.conn.prepareStatement(sql);
			
			pstmt.setString(1, rc.getRecipe_table());
			pstmt.setInt(2, rc.getRecipe_uid());
			pstmt.setString(3, rc.getRecipe_id());
			pstmt.setString(4, rc.getRecipe_name());
			pstmt.setString(5, rc.getRecipe_comment());
			pstmt.setString(6, rc.getRecipe_date());
			
			pstmt.executeUpdate();
			
			pstmt.close();
			d.conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//게시물에 댓글 수
	public int getAllRecipeComment(){
		d.getCon();
		
		int num = 0;
		
		try {
			String sql = "select count(*) as count from recipe_comment where uid=?";
			
			pstmt = d.conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				num = rs.getInt("count");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return num;
	}
	
	//목록
	public ArrayList<RecipeComment> oneRecipeComment(int uid){
		d.getCon();
		
		ArrayList<RecipeComment> listrc = new ArrayList<RecipeComment>();
		
		try {
			String sql = "select * from recipe_comment where recipe_uid=?";
			pstmt = d.conn.prepareStatement(sql);
			
			pstmt.setInt(1, uid);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				RecipeComment rc = new RecipeComment();
				
				rc.setUid(rs.getInt("uid"));
				rc.setRecipe_table(rs.getString("recipe_table"));
				rc.setRecipe_uid(rs.getInt("recipe_uid"));
				rc.setRecipe_id(rs.getString("recipe_id"));
				rc.setRecipe_name(rs.getString("recipe_name"));
				rc.setRecipe_comment(rs.getString("recipe_comment"));
				rc.setRecipe_date(rs.getString("recipe_date")); 
				
				listrc.add(rc);
			}
			rs.close();
			pstmt.close();
			d.conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listrc;
	}
	
	//수정할 댓글 불러오기
	public RecipeComment oneRecipeCommentModify(int uid) {
		d.getCon();
		
		RecipeComment rc = new RecipeComment();
		
		try {
			String sql = "select * from recipe_comment where uid=?";
			pstmt = d.conn.prepareStatement(sql);
			
			pstmt.setInt(1, uid);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				rc.setUid(rs.getInt("uid"));
				rc.setRecipe_comment(rs.getString("recipe_comment"));
			}
			rs.close();
			pstmt.close();
			d.conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rc;
	}
	
	//댓글 수정하고 업데이트하기
	public void updateRecipeComment(RecipeComment rc) {
		d.getCon();
		try {
			String sql = "update recipe_comment set uid=?;recipe_comment=?";
			pstmt = d.conn.prepareStatement(sql);
			
			pstmt.setInt(1, rc.getUid());
			pstmt.setString(2, rc.getRecipe_comment());
			
			pstmt.executeUpdate();
			
			pstmt.close();
			d.conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//댓글 삭제하기
	public void deleteRecipeComment(int uid) {
		d.getCon();
		
		try {
			String sql = "delete * from recipe_comment where uid=?";
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
