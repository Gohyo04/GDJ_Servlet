package com.gohyo.app.test;

import java.util.ArrayList;
import java.util.List;
import com.gohyo.app.departments.DepartmentDAO;
import com.gohyo.app.departments.DepartmentDTO;
import com.gohyo.app.regions.RegionDAO;
import com.gohyo.app.regions.RegionDTO;
import com.gohyo.app.views.View;

public class AppMain {
	public static void main(String[] args){
//		DBConnector dbc = new DBConnector();
//		dbc.getConnector();
		
//		DepartmentDAO ddao = new DepartmentDAO();
//		ddao.getList();
		try {
			View view = new View();
			RegionDAO regionDAO = new RegionDAO();
//			List<RegionDTO> ar = regionDAO.getList();
//			view.regionView(ar);	
			DepartmentDAO departmentDAO = new DepartmentDAO();
//			List<DepartmentDTO> arr = departmentDAO.getList();
//			view.departmentView(arr);
			
//			RegionDTO regionDTO = new RegionDTO();
//			regionDTO.setRegion_id(2);
//			regionDTO = regionDAO.getDetail(regionDTO);
//			
//			if(regionDTO != null) {
//				System.out.println(regionDTO.getRegion_id()+"\t"+regionDTO.getRegion_name());
//			}else {
//				System.out.println("없는 ID");
//			}
			
			DepartmentDTO departmentDTO = new DepartmentDTO();
			departmentDTO.setDepartment_id(20);
			departmentDTO = departmentDAO.getDetail(departmentDTO);
			
			if(departmentDTO != null) {
				System.out.println(departmentDTO.getDepartment_id());
				System.out.println(departmentDTO.getDepartment_name());
				System.out.println(departmentDTO.getManager_id());
				System.out.println(departmentDTO.getLocation_id());
			}else {
				System.out.println("없는 ID");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
}
