package com.gohyo.app.test;

import java.sql.Date;
import java.util.Map;

import com.gohyo.app.employees.EmployeeDAO;
import com.gohyo.app.employees.EmployeeDTO;

public class AppMain {
	public static void main(String[] args){
		EmployeeDAO dao = new EmployeeDAO();
		EmployeeDTO dto = new EmployeeDTO();
		dto.setEmployee_id(Integer.parseInt("207"));
		dto.setFirst_name("first_name");
		dto.setLast_name("last_name");
		dto.setEmail("email");
		dto.setPhone_number("010");
		dto.setHire_date(Date.valueOf("2023-12-27"));
		dto.setJob_id("AC_MGR");
		dto.setSalary(Double.parseDouble("5000"));
		dto.setCommission_pct(0.12);
		dto.setManager_id(205);
		dto.setDepartment_id(10);
		try {
			int result = dao.add(dto);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} 	
	}
}
