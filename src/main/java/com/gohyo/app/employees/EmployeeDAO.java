package com.gohyo.app.employees;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.gohyo.app.util.DBConnector;

public class EmployeeDAO {
	
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
}
