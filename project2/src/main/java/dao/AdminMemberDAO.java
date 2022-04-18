package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import model.Member;

public class AdminMemberDAO {

	Statement stmt;
	PreparedStatement pstmt;
	ResultSet rs;
	
	DAO d = new DAO();
	
	//전체 회원목록
	public ArrayList<Member> getAllMember(int startRow, int endRow, String field,String search){
		d.getCon();
		
		ArrayList<Member> v = new ArrayList<Member>();
		
		try {
			String sql = "";
			
			if(search != null && !search.equals("")) {
				sql = "select * from member where "+field+" like '%"+search+"%'"
					+"order by uid desc limit ?,?";
			}else {
				sql = "select * from member order by uid desc limit ?,?";
			}
			pstmt = d.conn.prepareStatement(sql);
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Member m = new Member();
				
				m.setUid(rs.getInt("uid"));
				m.setId(rs.getString("id"));
				m.setPass(rs.getString("pass"));
				m.setName(rs.getString("name"));
				m.setBirth(rs.getString("birth"));
				m.setGender(rs.getString("gender"));
				m.setEmail(rs.getString("email"));
				m.setLevel(rs.getString("level"));
				m.setSell_buy(rs.getString("sell_buy"));
				m.setNone(rs.getString("none"));
				m.setPro_manuname(rs.getString("pro_manuname"));
				m.setPro_salname(rs.getString("pro_salname"));
				m.setDate(rs.getString("date"));
				
				v.add(m);		
			}
			
			rs.close();
			pstmt.close();
			d.conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return v;
	}
	
	//판매 신청목록
		public ArrayList<Member> getAllMemberSellok(int startRow, int endRow, String field,String search){
			d.getCon();
			
			ArrayList<Member> v = new ArrayList<Member>();
			
			try {
				String sql = "";
				
				if(search != null && !search.equals("")) {
					sql = "select * from member where level='5' and "+field+" like '%"+search+"%'"
						+"order by uid desc limit ?,?";
				}else {
					sql = "select * from member where level='5' order by uid desc limit ?,?";
				}
				pstmt = d.conn.prepareStatement(sql);
				
				pstmt.setInt(1, startRow);
				pstmt.setInt(2, endRow);
				
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					Member m = new Member();
					
					m.setUid(rs.getInt("uid"));
					m.setId(rs.getString("id"));
					m.setPass(rs.getString("pass"));
					m.setName(rs.getString("name"));
					m.setBirth(rs.getString("birth"));
					m.setGender(rs.getString("gender"));
					m.setEmail(rs.getString("email"));
					m.setLevel(rs.getString("level"));
					m.setSell_buy(rs.getString("sell_buy"));
					m.setNone(rs.getString("none"));
					m.setPro_manuname(rs.getString("pro_manuname"));
					m.setPro_salname(rs.getString("pro_salname"));
					m.setDate(rs.getString("date"));
					
					v.add(m);		
				}
				
				rs.close();
				pstmt.close();
				d.conn.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return v;
		}
	
	//전체 회원 수
	
	public int getAllCount(String field, String search) {
		d.getCon();
		
		int num = 0;
		
		try {
			String sql = "";
			
			if(search != null && !search.equals("")) {
				sql = "select count(*) as total_count from member"
					+"where "+field+" like '"+search+"'";
			}else {
				sql = "select count(*) as total_count from member";
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
	
	//회원가입
	public void insertMamber(Member m) {
		d.getCon();
		
		try {
			String sql = "insert into member (id, pass, name, birth, gender, email, zipcode, zipcode1, zipcode2, zipcode3, zipcode4,level,sell_buy,pro_manuname,pro_salname,date) values"
						+" (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
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
			pstmt.setString(12, m.getLevel());
			pstmt.setString(13, m.getSell_buy());
			pstmt.setString(14, m.getPro_manuname());
			pstmt.setString(15, m.getPro_salname());
			pstmt.setString(16, m.getDate());
			
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
	
	//회원정보 불러오기
	public Member selectMember(String id) {
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
				m.setLevel(rs.getString("level"));
				m.setSell_buy(rs.getString("sell_buy"));
				m.setPro_manuname(rs.getString("pro_manuname"));
				m.setPro_salname(rs.getString("pro_salname"));
				m.setNone(rs.getString("none"));
				m.setDate(rs.getString("date"));
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
			String sql = "update member set pass=?, name=?, birth=?, gender=?, email=?, "
					+"zipcode=?, zipcode1=?, zipcode2=?, zipcode3=?, zipcode4=?, level=?,"
					+" sell_buy=?, pro_manuname=?, pro_salname=? where id=?";
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
			pstmt.setString(12, m.getSell_buy());
			pstmt.setString(13, m.getPro_manuname());
			pstmt.setString(14, m.getPro_salname());
			pstmt.setString(15, m.getId());
			
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

	//회원 사용 처리
	public void useMember(String id) {
		d.getCon();
		
		try {
			String sql = "update member set none = '1' where id = ?";
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
	
	//회원 탈퇴 처리
	public void deleteMember(String id) {
		d.getCon();
		
		try {
			String sql = "delete from member where id = ?";
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
	
	//판매자 승인 완료
	public void sellMemberOk(String id) {
		d.getCon();
		
		try {
			String sql = "update member set sell_buy = 'Y' where id = ?";
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
	
	//판매자 승인 취소
	public void sellMemberNo(String id) {
		d.getCon();
		
		try {
			String sql = "update member set pro_manuname = '거절', pro_salname = '거절' where id = ?";
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
}





















