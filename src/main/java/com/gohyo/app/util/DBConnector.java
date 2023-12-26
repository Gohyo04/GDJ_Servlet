package com.gohyo.app.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBConnector {
	
	// 1. IP:PORT
	// 2. ID, PW
	// static으로 미리 메모리에 로딩해놓음
	public static Connection getConnector() throws Exception{
		String user = "user01";
		String password = "oracle";	
		String url = "jdbc:oracle:thin:@43.201.114.90:1521:xe";
		String driver = "oracle.jdbc.driver.OracleDriver";
		
		// 1. driver를 메모리에 로딩 (객체 생성)
		Class.forName(driver);
		// 2. DB연결 (con = 연결못하면 null)
		Connection con = DriverManager.getConnection(url, user, password);
		return con;
	}
	
	// SELECT
	public static void disConnect(ResultSet rs, PreparedStatement ps, Connection con) throws Exception {
		rs.close();
		ps.close();
		con.close();
	}
	
	// INSERT, DELETE, UPDATE
	public static void disConnect(PreparedStatement ps, Connection con) throws Exception{
		ps.close();
		con.close();
	}
}













