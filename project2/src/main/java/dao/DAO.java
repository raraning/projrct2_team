package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DAO {
	Connection conn;
	
	public void getCon() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/project2?useUnicode=true&characterEncoding=utf8";
			String user="root";
			String password="1111";
			
			conn=DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
