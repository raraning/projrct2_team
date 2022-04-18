package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import model.Member;

public class MemberDAO {

	Statement stmt;
	PreparedStatement pstmt;
	ResultSet rs;
	
	DAO d = new DAO();
	

	//회원가입
	public void insertMamber(Member m) {
		d.getCon();
		
		try {
			String sql = "insert into member (id, pass, name, birth, gender, email, zipcode, zipcode1, zipcode2, zipcode3, zipcode4, date, pro_manuname, pro_salname, phone)" 
						+"values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			pstmt = d.conn.prepareStatement(sql);
		
			pstmt.setString(1, m.getId());
			pstmt.setString(2, m.getPass());
			pstmt.setString(3, m.getName());
			pstmt.setString(4, m.getBirth());
			pstmt.setString(5, m.getGender());
			pstmt.setString(6, m.getEmail());
			pstmt.setString(7, m.getZipcode());
			pstmt.setString(8, m.getZipcode1());
			pstmt.setString(9, m.getZipcode2());
			pstmt.setString(10, m.getZipcode3());
			pstmt.setString(11, m.getZipcode4());
			pstmt.setString(12, m.getDate());
			pstmt.setString(13, m.getPro_manuname());
			pstmt.setString(14, m.getPro_salname());
			pstmt.setString(15, m.getPhone());
			
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
	
	//아이디 존재 여부
	
	public int loginSelect(String id) {
		d.getCon();
		
		int num = 0;
		try {
			String sql = "select count(*) from member where id = ? and none = '1'";
			pstmt = d.conn.prepareStatement(sql);
			
			pstmt.setString(1, id);
			
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
	
	
	//로그인
	public Member loginMemberSelect(String id, String pass) {
	d.getCon();
		Member m = new Member();
		try {
			String sql = "select * from member where id = ? and pass=?";
			pstmt = d.conn.prepareStatement(sql);
			
			pstmt.setString(1, id);
			pstmt.setString(2, pass);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				m.setId(rs.getString("id"));
				m.setName(rs.getString("name"));
				m.setLevel(rs.getString("level"));
				m.setSell_buy(rs.getString("sell_buy"));
				
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
	
	//회원정보 불러오기
	public Member oneMember(String id) {
		d.getCon();
		
		Member m = new Member();
		
		try {
			String sql = "select * from member where id=?";
			pstmt = d.conn.prepareStatement(sql);
			
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {	
				m.setUid(rs.getInt("uid"));
				m.setId(rs.getString("id"));
				m.setPass(rs.getString("pass"));
				m.setName(rs.getString("name"));	
				m.setBirth(rs.getString("birth"));
				m.setGender(rs.getString("gender"));
				m.setEmail(rs.getString("email"));
				m.setZipcode(rs.getString("zipcode"));
				m.setZipcode1(rs.getString("zipcode1"));
				m.setZipcode2(rs.getString("zipcode2"));
				m.setZipcode3(rs.getString("zipcode3"));
				m.setZipcode4(rs.getString("zipcode4"));
				m.setSell_buy(rs.getString("sell_buy"));
				m.setLevel(rs.getString("level"));
				m.setNone(rs.getString("none"));
				m.setPro_manuname(rs.getString("pro_manuname"));
				m.setPro_salname(rs.getString("pro_salname"));
				m.setDate(rs.getString("date"));
				m.setPoint(rs.getInt("point"));
				m.setPhone(rs.getString("phone"));
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
	
	//회원수정
	public void updateMember(Member m) {
		d.getCon();
		
		try {
			String sql = "update member set "
						+"pass=? , name=? , birth=?,"
						+"gender=?, email=?, zipcode=?, zipcode1=?, zipcode2=?, zipcode3=?," 
						+"zipcode4=?, level=?, none=?,pro_manuname=?, pro_salname=?, phone=? where id = ?";
			pstmt = d.conn.prepareStatement(sql);
			
			pstmt.setString(1, m.getPass());
			pstmt.setString(2, m.getName());
			pstmt.setString(3, m.getBirth());
			pstmt.setString(4, m.getGender());
			pstmt.setString(5, m.getEmail());
			pstmt.setString(6, m.getZipcode());
			pstmt.setString(7, m.getZipcode1());
			pstmt.setString(8, m.getZipcode2());
			pstmt.setString(9, m.getZipcode3());
			pstmt.setString(10, m.getZipcode4());
			pstmt.setString(11, m.getLevel());
			pstmt.setString(12, m.getNone());
			pstmt.setString(13, m.getPro_manuname());
			pstmt.setString(14, m.getPro_salname());
			pstmt.setString(15, m.getPhone());
			pstmt.setString(16, m.getId());
			
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
	
	//아이디 찾기
	public String idSearch(String name, String email) {
		d.getCon();
		
		String id2 = "";
		
		try {
			String sql = "select * from member where name=? and email=?";
			pstmt = d.conn.prepareStatement(sql);
			
			pstmt.setString(1, name);
			pstmt.setString(2, email);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				id2 = rs.getString("id");
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
		return id2;
	}
	
	//비밀번호 찾기
	public String passSearch(String id, String email) {
		d.getCon();
		
		String pass = "";
		
		try {
			String sql = "select * from member where id=? and email=?";
			pstmt = d.conn.prepareStatement(sql);
			
			pstmt.setString(1, id);
			pstmt.setString(2, email);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				pass = rs.getString("pass");
				
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
		return pass;
	}
	
	//회원 휴먼 처리
	public void outMember(String id) {
		d.getCon();
		
		try {
			String sql = "update member set none = '2' where id = ?";
			pstmt = d.conn.prepareStatement(sql);
			
			pstmt.setString(1, id);
			
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
	
	//판매자 신청
	public void sellOk(Member m) {
		d.getCon();
		
		try {
			String sql = "update member set level = ? , pro_manuname = ?, pro_salname = ? where id = ?";
			pstmt = d.conn.prepareStatement(sql);
			
			pstmt.setString(1, m.getLevel());
			pstmt.setString(2, m.getPro_manuname());
			pstmt.setString(3, m.getPro_salname());
			pstmt.setString(4, m.getId());
			
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

























