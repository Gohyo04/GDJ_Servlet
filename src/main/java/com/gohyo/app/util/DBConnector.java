package com.gohyo.app.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBConnector {
	
	// 1. IP:PORT
	// 2. ID, PW
	
	public void getConnector() {
		String user = "user01";
		String password = "oracle";
		
		String url = "jdbc:oracle:thin:@43.201.114.90:1521:xe";
		String driver = "oracle.jdbc.driver.OracleDriver";
		
		try {
			// 1. driver를 메모리에 로딩 (객체 생성)
			Class.forName(driver);
			// 2. DB연결 (con = 연결못하면 null)
			Connection con = DriverManager.getConnection(url, user, password);
			
			// 3. Sql(query)문 생성 ( ; 생략 )
			String sql = "SELECT * FROM REGIONS";
			
			// 4. SQL문 미리 전송
			PreparedStatement st = con.prepareStatement(sql);
			
			// 5. 
			
			// 6. 최종 전송 및 결과 처리
			ResultSet rs = st.executeQuery();
			
			while(rs.next()) { // rs 값이있으면 true / 아니면 false
				// rs = 1, Europe
				int n = rs.getInt("REGION_ID");
				String name = rs.getString("REGION_NAME");
				System.out.println(n +" : "+ name);
				System.out.println("============================");
			}
			
			System.out.println(con);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}













