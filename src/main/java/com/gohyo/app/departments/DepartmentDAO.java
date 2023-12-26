package com.gohyo.app.departments;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.gohyo.app.util.DBConnector;

public class DepartmentDAO {
	// DAO -> Data Access Object
	// SELECT Detail
	public DepartmentDTO getDetail(DepartmentDTO departmentDTO) throws Exception{
		Connection con = DBConnector.getConnector();
		
		String sql = "SELECT * FROM DEPARTMENTS WHERE DEPARTMENT_ID =?";
		
		PreparedStatement ps = con.prepareStatement(sql);
		
		ps.setInt(1, departmentDTO.getDepartment_id());
		ResultSet rs = ps.executeQuery();
		
		DepartmentDTO ddto = null;
		if(rs.next()) {
			ddto = new DepartmentDTO();
			ddto.setDepartment_id(rs.getInt("DEPARTMENT_ID"));
			ddto.setDepartment_name(rs.getString("DEPARTMENT_NAME"));
			ddto.setManager_id(rs.getInt("MANAGER_ID"));
			ddto.setLocation_id(rs.getInt("LOCATION_ID"));
		}
		DBConnector.disConnect(rs, ps, con);
		return ddto; 
	}
	
	// SELECT List
	public ArrayList<DepartmentDTO> getList() throws Exception{
		Connection con =  DBConnector.getConnector();
		
		// 3. Sql(query)문 생성 ( ; 생략 )
		String sql = "SELECT * FROM DEPARTMENTS";
		// 4. SQL문 미리 전송(준비)
		PreparedStatement ps = con.prepareStatement(sql);
		// 6. 최종 전송 및 결과 처리
		ResultSet rs = ps.executeQuery();
		
		ArrayList<DepartmentDTO> arr = new ArrayList<>(); 
		while(rs.next()) {
			DepartmentDTO ddto = new DepartmentDTO();
			ddto.setDepartment_id(rs.getInt("DEPARTMENT_ID"));
			ddto.setDepartment_name(rs.getString("DEPARTMENT_NAME"));
			ddto.setManager_id(rs.getInt("MANAGER_ID"));
			ddto.setLocation_id(rs.getInt("LOCATION_ID"));
			arr.add(ddto);
		}
		
		DBConnector.disConnect(rs, ps, con);
		return arr;
	}
	
	// Insert
	public int add(DepartmentDTO ddto) throws Exception{
		Connection con = DBConnector.getConnector();
		String sql = "INSERT INTO DEPARTMENTS VALUES (?,?,?,?)";
		
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, ddto.getDepartment_id());
		ps.setString(2, ddto.getDepartment_name());
		ps.setInt(3, ddto.getManager_id());
		ps.setInt(4, ddto.getLocation_id());
		
		int result = ps.executeUpdate();
		DBConnector.disConnect(ps, con);
		return result;
	}
	
	
	public int update(DepartmentDTO ddto) throws Exception{
		Connection con = DBConnector.getConnector();
		String sql = "UPDATE DEPARTMENTS SET DEPARTMENT_NAME = ?, MANAGER_ID = ?, LOCATION_ID = ? WHERE DEPARTMENT_ID = ?";
		
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, ddto.getDepartment_name());
		ps.setInt(2, ddto.getManager_id());
		ps.setInt(3, ddto.getLocation_id());
		ps.setInt(4, ddto.getDepartment_id());
		
		int result = ps.executeUpdate();
		
		DBConnector.disConnect(ps, con);
		return result;
	}
}
