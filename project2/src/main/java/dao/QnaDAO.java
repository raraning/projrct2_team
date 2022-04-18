package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import model.Qna;

public class QnaDAO {
	Statement stmt;
	PreparedStatement pstmt;
	ResultSet rs;
	
	DAO d = new DAO(); //d.getCon()
	
	public void insertBoard(Qna q) {
		d.getCon();
		
		try {
			String sql = "insert into qna (id,name,subject,comment,signdate) values (?,?,?,?,?)";
			pstmt  = d.conn.prepareStatement(sql);
			
			pstmt.setString(1, q.getId());
			pstmt.setString(2, q.getName());
			pstmt.setString(3, q.getSubject());
			pstmt.setString(4, q.getComment());
			pstmt.setString(5, q.getSigndate());
			
			pstmt.executeUpdate();
			
			pstmt.close();
			d.conn.close();
		} catch (Exception e) {
			
		}
	}
	
	//게시글 목록 ArrayList 양식으로 작성하기
	public ArrayList<Qna> getAllQna(int startRow, int endRow, String field, String search) {
		d.getCon();
		
		ArrayList<Qna> v = new ArrayList<Qna>();
		
		try {
			String sql = "";
			
			if(search != null && search.equals("")) {
				sql = "select * from qna where "+field+" like '%"+search+"%' limit ?,?";
			}else {
				sql = "select * from qna limit ?,?";
			}
			
			pstmt = d.conn.prepareStatement(sql);
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Qna q = new Qna();
				
				q.setUid(rs.getInt("uid"));
				q.setId(rs.getString("id"));
				q.setName(rs.getString("name"));
				q.setSubject(rs.getString("subject"));
				q.setComment(rs.getString("comment"));
				q.setSigndate(rs.getString("signdate"));
				q.setRef(rs.getInt("ref"));
				q.setGongji(rs.getString("gongji"));
				q.setFile1(rs.getString("file1"));
				q.setFile1_o(rs.getString("file1_o"));
				q.setFile1_s(rs.getString("file1_s"));
				q.setFid(rs.getInt("fid"));
				q.setThread(rs.getString("thread"));
				
				v.add(q);
			}
			
			rs.close();
			pstmt.close();
			d.conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return v;
	}
	
	//전체 게시글 수 
	public int getAllQna(String field, String search) {
		d.getCon();
		
		int num = 0; //초기화 해준다
		
		try {
			String sql = "";
			if(search != null && search.equals("")) {
				sql = "select count(*) from qna where "+field+" like '%"+search+"%'";
			}else {
				sql = "select count(*) from qna";
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
	
	//게시글 조회수 +1
	public void qnaRef(int ref) {
		d.getCon();
		try {
			String sql = "update qna set ref = ref +1 where uid=?";
		
			pstmt = d.conn.prepareStatement(sql);
			pstmt.setFloat(1, ref);
			pstmt.executeUpdate();
			
			pstmt.close();
			d.conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//게시글 상세보기 view.jsp
	public Qna oneQna(int uid) {
		d.getCon();
		
		Qna q = new Qna();
		
		try {
			String sql = "select * from qna where uid=?";
			pstmt = d.conn.prepareStatement(sql);
			
			pstmt.setInt(1, uid);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				q.setId(rs.getString("id"));
				q.setUid(rs.getInt("uid"));
				q.setSubject(rs.getString("subject"));
				q.setComment(rs.getString("comment"));
				q.setSigndate(rs.getString("signdate"));
				q.setGongji(rs.getString("gongji"));
			}
			
			rs.close();
			pstmt.close();
			d.conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return q;
	}
	
	//수정할 게시글 불러오기 - QnaModify 연동
	public Qna oneQnaModify(int uid) {
		d.getCon();
		
		Qna q = new Qna();
		
		try {
			String sql = "select * from qna where uid=?";
			pstmt = d.conn.prepareStatement(sql);
			
			pstmt.setInt(1, uid);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				q.setSubject(rs.getString("subject"));
				q.setComment(rs.getString("comment"));
				q.setGongji(rs.getString("gongji"));
				q.setSigndate(rs.getString("signdate"));
				q.setUid(rs.getInt("uid"));
			}
			rs.close();
			pstmt.close();
			d.conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return q;
	}
	
	//게시글 수정하기
	public void updateNotice(Qna q) {
		d.getCon();
		try {
			String sql = "update qna set subject=?,comment=?,gongji=? where uid=?";
			pstmt = d.conn.prepareStatement(sql);
			
			pstmt.setString(1, q.getSubject());
			pstmt.setString(2, q.getComment());
			pstmt.setString(3, q.getGongji());
			pstmt.setInt(4, q.getUid());
			
			pstmt.executeUpdate();
			
			pstmt.close();
			d.conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//게시글 삭제하기
	public void qnaDelete(int uid) {
		d.getCon(); //똑똑 두드려준다

		try {
			String sql = "delete from qna where uid=?";
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
