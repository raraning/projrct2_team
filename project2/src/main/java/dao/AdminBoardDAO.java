package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import model.Notice;

public class AdminBoardDAO {

	Statement stmt;
	PreparedStatement pstmt;
	ResultSet rs;
	
	DAO d = new DAO();
	
	//공지사항 글쓰기
	public void insertWrite(Notice n) {
		d.getCon();
		
		try {
			String sql = "insert into notice (pro_uid,id,name,subject,comment,signdate) values (?,?,?,?,?,?)";
			pstmt = d.conn.prepareStatement(sql);
			
			pstmt.setInt(1, n.getPro_uid());
			pstmt.setString(2, n.getId());
			pstmt.setString(3, n.getName());
			pstmt.setString(4, n.getSubject());
			pstmt.setString(5, n.getComment());
			pstmt.setString(6, n.getSigndate());
			
			
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
	
	//공지 목록
	
	public ArrayList<Notice> getAllNotice(int startRow,int endRow,String field,String search){
		d.getCon();
		
		ArrayList<Notice> g = new ArrayList<Notice>();
		try {
			String sql = ""; 
			
			if(search != null && !search.equals("")) {
				sql = "select * from notice where "+field+" like '%"+search+"%' order by uid desc limit ?,?";
			}else {
				sql = "select * from notice order by uid desc limit ?,?";
			}
			pstmt = d.conn.prepareStatement(sql);
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Notice v = new Notice();
				
				v.setUid(rs.getInt("uid"));
				v.setSubject(rs.getString("subject"));
				v.setSigndate(rs.getString("signdate"));
				
				g.add(v);
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
		return g;
	}
	
	//전체 공지사항 수
	public int getAllCount(String field, String search) {
		d.getCon();
		int num = 0;
		
		try {
			String sql = "";
			
			if(search != null && !search.equals("")) {
				sql = "select count(*) as total_count from notice where "+field+" like '%"+search+"%'";
			}else {
				sql = "select count(*) as total_count from notice";
			}
			pstmt = d.conn.prepareStatement(sql);
			
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
	
	
	//공지사항(view,modify) 정보 불러오기
	
	public Notice selectNotice(int uid) {
		d.getCon();
		
		Notice n = new Notice();
		
		try {
			String sql = "select * from notice where uid = ?"; 
			pstmt = d.conn.prepareStatement(sql);
			
			pstmt.setInt(1, uid);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				n.setUid(rs.getInt("uid"));
				n.setPro_uid(rs.getInt("pro_uid"));
				n.setName(rs.getString("name"));
				n.setSubject(rs.getString("subject"));
				n.setComment(rs.getString("comment"));
				n.setSigndate(rs.getString("signdate"));
						
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
		return n;
	}
	
	//글 수정
	
	public void updateModify(Notice n) {
		d.getCon();
		
		try {
			String sql = "update notice set pro_uid=?, id=?, name=?, subject=?, comment=?, signdate=? where uid=?";
			pstmt = d.conn.prepareStatement(sql);
			
			pstmt.setInt(1, n.getPro_uid());
			pstmt.setString(2, n.getId());
			pstmt.setString(3, n.getName());
			pstmt.setString(4, n.getSubject());
			pstmt.setString(5, n.getComment());
			pstmt.setString(6, n.getSigndate());
			pstmt.setInt(7, n.getUid());
			
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
	//게시글 삭제
	public void outNotice(int uid) {
		d.getCon();
		
		try {
			String sql = "delete from notice where uid=?";
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









































