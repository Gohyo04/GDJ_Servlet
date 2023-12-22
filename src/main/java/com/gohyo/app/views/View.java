package com.gohyo.app.views;

import java.util.List;

import com.gohyo.app.departments.DepartmentDTO;
import com.gohyo.app.regions.RegionDTO;

public class View {
	
	// Regions를 출력하는 메서드
	public void regionView(List<RegionDTO> dtos) {
		for(RegionDTO regionDTO : dtos) {
			System.out.println(regionDTO.getRegion_id() +" : "+ regionDTO.getRegion_name());
			System.out.println("===============================");
		}
	}
	
	public void departmentView(List<DepartmentDTO> ddto) {
		for(DepartmentDTO departmentDTO : ddto) {
			System.out.println(departmentDTO.getDepartment_id()+". "+departmentDTO.getDepartment_name());
			System.out.println(departmentDTO.getManager_id()+"\t"+departmentDTO.getLocation_id());
			System.out.println("=====================================");
		}
	}
}
