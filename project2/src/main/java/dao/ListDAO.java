package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import model.List;

public class ListDAO {
	Statement stmt;
	PreparedStatement pstmt;
	ResultSet rs;
	
	DAO d = new DAO(); //d.getCon()
	
	//게시글 목록
	public ArrayList<List> getAllPost(int startRow, int endRow, String field, String search){
		d.getCon();
		
		ArrayList<List> v = new ArrayList<List>();
		
		try {
			String sql = "";
			if(search != null && search.equals("")) {
				sql = "select * from notice where "+field+" like '%"+search+"%' limit ?,?";
			}else {
				sql = "select * from notice limit ?,?";
			}
			
			pstmt = d.conn.prepareStatement(sql);
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				List l = new List();
				
				l.setUid(rs.getInt("uid"));
				l.setId(rs.getString("id"));
				l.setName(rs.getString("name"));
				l.setSubject(rs.getString("subject"));
				l.setComment(rs.getString("comment"));
				l.setSigndate(rs.getString("signdate"));
				l.setRef(rs.getInt("ref"));
				l.setGongji(rs.getString("gongji"));
				l.setFile1(rs.getString("file1"));
				l.setFile1_o(rs.getString("file1_o"));
				l.setFile1_s(rs.getString("file1_s"));
				l.setFid(rs.getInt("fid"));
				l.setThread(rs.getString("thread"));
				
				v.add(l);
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
	public int getAllNotice(String field, String search) {
		d.getCon();
		
		int num = 0;
		
		try {
			String sql = "";
			
			if(search != null && search.equals("")) { //검색어가 있다면
				sql = "select count(*) from notice where "+field+" like '%"+search+"%'";
			}else {
				sql = "select count(*) from notice";
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
	
	//게시글 조회수 증가
	public void noticeRef(int ref) {
		d.getCon();
		
		try {
			String sql = "update notice set ref = ref + 1 where uid=?";			
			pstmt = d.conn.prepareStatement(sql);
			
			pstmt.setInt(1, ref);
			
			pstmt.executeUpdate();
			
			pstmt.close();
			d.conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//제목과 내용과 이름에 맞는 게시글의 정보를 돌려주자
	public List NoticeSelect(String subject, String comment, String name) {
		d.getCon();
		
		List l = new List();
		
		try {
			String sql = "select * from notice where subject=? and comment=? and name=?";
			pstmt = d.conn.prepareStatement(sql);
			
			pstmt.setString(3, subject);
			pstmt.setString(4, comment);
			pstmt.setString(2, name);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				l.setUid(rs.getInt("uid"));
				l.setId(rs.getString("id"));
				l.setName(rs.getString("name"));
				l.setSubject(rs.getString("subject"));
				l.setComment(rs.getString("comment"));
				l.setSigndate(rs.getString("signdate"));
				l.setRef(rs.getInt("ref"));
				l.setGongji(rs.getString("gongji"));
				l.setFile1(rs.getString("file1"));
				l.setFile1_o(rs.getString("file1_o"));
				l.setFile1_s(rs.getString("file1_s"));
				l.setFid(rs.getInt("fid"));
				l.setThread(rs.getString("thread"));
			}
			rs.close();
			pstmt.close();
			d.conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return l;
	}
	
	//게시글 상세내용 보기 notice_view.jsp 
	public List oneNotice(int uid) {
		d.getCon();
		
		List l = new List();
		
		try {
			String sql = "select * from notice where uid=?";
			pstmt = d.conn.prepareStatement(sql);
			
			pstmt.setInt(1, uid);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				l.setSubject(rs.getString("subject"));
				l.setComment(rs.getString("comment"));
				l.setSigndate(rs.getString("signdate"));
				l.setGongji(rs.getString("gongji"));
				l.setUid(rs.getInt("uid"));
	
			}
			rs.close();
			pstmt.close();
			d.conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return l;
	}
	
	//게시글 등록
	public void insertNotice(List l) {
		d.getCon();
		
		try {
			String sql = "insert into notice (id,name,subject,comment,signdate) values (?,?,?,?,?)";
			pstmt = d.conn.prepareStatement(sql);
			
			pstmt.setString(1, l.getId());
			pstmt.setString(2, l.getName());
			pstmt.setString(3, l.getSubject());
			pstmt.setString(4, l.getComment());
			pstmt.setString(5, l.getSigndate());
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//게시글 수정하기 - 수정할 글 불러오기 NoticeModify 연동
	public List oneNoticeModify(int uid) {
		d.getCon(); //똑똑 두드려준다
		
		List l = new List();
		
		try {
			String sql = "select * from notice where uid=?";
			pstmt = d.conn.prepareStatement(sql);
			
			pstmt.setInt(1, uid);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				l.setSubject(rs.getString("subject"));
				l.setComment(rs.getString("comment"));
				l.setGongji(rs.getString("gongji"));
				l.setSigndate(rs.getString("signdate"));
				l.setUid(rs.getInt("uid"));
			}
			rs.close();
			pstmt.close();
			d.conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return l;
	}
	
	//게시글 수정하기 - 수정하고 업데이트하기 NoticeModifyUpdate 연동
	public void updateNotice(List l) {
		d.getCon();
		
		try {
			String sql = "update notice set subject=?,comment=?,gongji=? where uid=?";
			pstmt = d.conn.prepareStatement(sql);
			
			pstmt.setString(1, l.getSubject());
			pstmt.setString(2, l.getComment());
			pstmt.setString(3, l.getGongji());
			pstmt.setInt(4, l.getUid());
			
			pstmt.executeUpdate();
			
			pstmt.close();
			d.conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//게시글 삭제하기 
	 public void deleteNotice(int uid) {
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
