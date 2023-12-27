package com.gohyo.app.employees;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.gohyo.app.util.DBConnector;

public class EmployeeDAO {
	
	// 사원 급여 합계
	public Map getSalary() throws Exception{
		Map<String,Integer> map = new HashMap();
		Connection con = DBConnector.getConnector();
		String sql = "SELECT SUM(SALARY), COUNT(EMPLOYEE_ID) FROM EMPLOYEES";
		
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		rs.next();
		int sum = rs.getInt("SUM(SALARY)");
		int count = rs.getInt(2);
		map.put("count", count);
		map.put("sum", sum);
		DBConnector.disConnect(rs, ps, con);
		return map;
	}
	
	public EmployeeDTO getDetail(EmployeeDTO employeeDTO) throws Exception{
		Connection con = DBConnector.getConnector();
		String sql = "SELECT * FROM EMPLOYEES WHERE EMPLOYEE_ID = ?";
		
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, employeeDTO.getEmployee_id());
		ResultSet rs = ps.executeQuery();
		
		EmployeeDTO edto = null;
		if(rs.next()) {
			edto = new EmployeeDTO();
			edto.setEmployee_id(rs.getInt("EMPLOYEES_ID"));
			edto.setFirst_name(rs.getString("FRIST_NAME"));
			edto.setLast_name(rs.getString("LAST_NAME"));
			edto.setEmail(rs.getString("EMAIL"));
			edto.setPhone_number(rs.getString("PHONE_NUMBER"));
			edto.setHire_date(rs.getDate("HIRE_DATE"));
			edto.setJob_id(rs.getString("JOB_ID"));
			edto.setSalary(rs.getInt("SALARY"));
			edto.setCommission_pct(rs.getInt("COMMISSION_PCT"));
			edto.setManager_id(rs.getInt("MANAGER_ID"));
			edto.setDepartment_id(rs.getInt("DEPARTMENT_ID"));
		}
		return edto;
	}
	
	public ArrayList<EmployeeDTO> getList() throws Exception{
		Connection con = DBConnector.getConnector();
		String sql = "SELECT * FROM EMPLOYEES";
		
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		ArrayList<EmployeeDTO> arr = new ArrayList<>();
		while(rs.next()) {
			EmployeeDTO edto = new EmployeeDTO();
			edto.setEmployee_id(rs.getInt("EMPLOYEES_ID"));
			edto.setFirst_name(rs.getString("FRIST_NAME"));
			edto.setLast_name(rs.getString("LAST_NAME"));
			edto.setEmail(rs.getString("EMAIL"));
			edto.setPhone_number(rs.getString("PHONE_NUMBER"));
			edto.setHire_date(rs.getDate("HIRE_DATE"));
			edto.setJob_id(rs.getString("JOB_ID"));
			edto.setSalary(rs.getInt("SALARY"));
			edto.setCommission_pct(rs.getInt("COMMISSION_PCT"));
			edto.setManager_id(rs.getInt("MANAGER_ID"));
			edto.setDepartment_id(rs.getInt("DEPARTMENT_ID"));
			arr.add(edto);
		}
		
		return arr;
	}
	
	// 추가
	public int add(EmployeeDTO edto) throws Exception{
		Connection con = DBConnector.getConnector();
		String sql = "INSERT INTO EMPLOYEES "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, edto.getEmployee_id());
		ps.setString(2, edto.getFirst_name());
		ps.setString(3, edto.getLast_name());
		ps.setString(4,edto.getEmail());
		ps.setString(5,edto.getPhone_number());
		ps.setDate(6, edto.getHire_date());
		ps.setString(7, edto.getJob_id());
		ps.setDouble(8, edto.getSalary());
		ps.setDouble(9, edto.getCommission_pct());
		ps.setInt(10, edto.getManager_id());
		ps.setInt(11, edto.getDepartment_id());
		
		int result = ps.executeUpdate();
		DBConnector.disConnect(ps, con);
		
		return result;
	}
}
