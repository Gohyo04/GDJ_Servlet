package com.gohyo.app.locations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.gohyo.app.util.DBConnector;

public class LocationDAO {

	public LocationDTO getDetail(LocationDTO locationDTO) throws Exception{
		Connection con = DBConnector.getConnector();
		String sql = "SELECT * FROM LOCATIONS WHERE LOCATION_ID = ?";
		
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, locationDTO.getLocation_id());
		ResultSet rs = ps.executeQuery();
		
		LocationDTO ldto = null;
		if(rs.next()) {
			ldto = new LocationDTO();
			ldto.setLocation_id(rs.getInt("LOCATION_ID"));
			ldto.setStreet_address(rs.getString("STREET_ADDRESS"));
			ldto.setPostal_code(rs.getInt("POSTRAL_CODE"));
			ldto.setCity(rs.getString("CITY"));
			ldto.setState_province(rs.getString("STATE_PROVINCE"));
			ldto.setCountry_id(rs.getString("COUNTRY_ID"));
		}
		return ldto;
	}
	
	public ArrayList<LocationDTO> getList() throws Exception{
		Connection con = DBConnector.getConnector();
		String sql = "SELECT * FROM LOCATIONS";
		
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		ArrayList<LocationDTO> arr = new ArrayList<>();
		while(rs.next()) {
			LocationDTO ldto = new LocationDTO();
			ldto.setLocation_id(rs.getInt("LOCATION_ID"));
			ldto.setStreet_address(rs.getString("STREET_ADDRESS"));
			ldto.setPostal_code(rs.getInt("POSTRAL_CODE"));
			ldto.setCity(rs.getString("CITY"));
			ldto.setState_province(rs.getString("STATE_PROVINCE"));
			ldto.setCountry_id(rs.getString("COUNTRY_ID"));
			arr.add(ldto);
		}
		return arr;
	}
}
