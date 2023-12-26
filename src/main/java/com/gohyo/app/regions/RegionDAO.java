package com.gohyo.app.regions;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.gohyo.app.util.DBConnector;

public class RegionDAO {
	
	public RegionDTO getDetail(RegionDTO regionDTO) throws Exception{
		Connection con = DBConnector.getConnector();
		
		String sql = "SELECT * FROM REGIONS WHERE REGION_ID =?";
		
		PreparedStatement ps = con.prepareStatement(sql);
		// ? 값 세팅
		ps.setInt(1, regionDTO.getRegion_id());
		
		ResultSet rs = ps.executeQuery();
	
		RegionDTO rdto = null;
		if(rs.next()) {
			rdto = new RegionDTO(); 
			rdto.setRegion_id(rs.getInt("REGION_ID"));
			rdto.setRegion_name(rs.getString("REGION_NAME"));
		}
		return rdto;
	}
	
	public ArrayList<RegionDTO> getList() throws Exception{
		
		Connection con =  DBConnector.getConnector();
			
		// 3. Sql(query)문 생성 ( ; 생략 )
		String sql = "SELECT * FROM REGIONS";
		
		// 4. SQL문 미리 전송
		PreparedStatement ps = con.prepareStatement(sql);
		
		// 5. 
		
		// 6. 최종 전송 및 결과 처리
		ResultSet rs = ps.executeQuery();
		ArrayList<RegionDTO> arr = new ArrayList<>();
		while(rs.next()) { // rs 값이있으면 true / 아니면 false
			RegionDTO rdto = new RegionDTO();
			// rs = 1, Europe
			rdto.setRegion_id(rs.getInt("REGION_ID"));
			rdto.setRegion_name(rs.getString("REGION_NAME"));
			arr.add(rdto);
		}
		// 연결확인
		System.out.println(con);
		// 연결헤제
		DBConnector.disConnect(rs, ps, con);
		return arr; 
	}
	
	// Insert
	public int add(RegionDTO rdto) throws Exception{
		Connection con = DBConnector.getConnector();
		String sql = "INSERT INTO REGIONS VALUES (?,?)";
		
		
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, rdto.getRegion_id());
		ps.setString(2, rdto.getRegion_name());
		
		// 성공 1, 실패 0 or error
		int result =  ps.executeUpdate();
		
		DBConnector.disConnect(ps, con);
		return result;
	}
	
	// Update
	public int update(RegionDTO regionDTO) throws Exception {
		Connection con = DBConnector.getConnector();
		
		String sql = "UPDATE REGIONS SET REGION_NAME = ? WHERE REGION_ID = ?"; 
		
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, regionDTO.getRegion_name());
		ps.setInt(2, regionDTO.getRegion_id());
		
		int result = ps.executeUpdate();
		
		DBConnector.disConnect(ps, con);
		return result;
	}
	
	
	
	
	
	
	
	
	
	
	
}
