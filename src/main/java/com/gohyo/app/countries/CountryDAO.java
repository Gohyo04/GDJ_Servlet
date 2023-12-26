package com.gohyo.app.countries;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.gohyo.app.util.DBConnector;

public class CountryDAO {
	
	// 하나씩 가져오기 (select)
	public CountryDTO getCountry(CountryDTO countryDTO) throws Exception{
		Connection con = DBConnector.getConnector();
		String sql = "SELECT * FROM COUNTRIES WHERE COUNTRY_ID = ?";
		
		PreparedStatement ps = con.prepareStatement(sql);
//		ps.setInt(몇번째 물음표에, 어떤값을 넣을지)
		ps.setString(1, countryDTO.getCountry_id());
//		쿼리 결과(반환)값 저장
		ResultSet rs = ps.executeQuery();
			
		CountryDTO cdto = null;		// 초기화
		if(rs.next()) {	// rs.next() true / false 를 반환하며 행변경
			cdto = new CountryDTO();	// set 해줄 객체 생성
			cdto.setCountry_id(rs.getString("COUNTRY_ID")); // 결과의 어떤열을 가져와서 셋할것인가
			cdto.setCountry_name(rs.getString("COUNTRY_NAME"));	// 다음 행
			cdto.setRegion_id(rs.getInt("REGION_ID"));
		}
		DBConnector.disConnect(rs, ps, con);
		return cdto;
	}
	
	// 여러개 가져오기 (select)
	public ArrayList<CountryDTO> getList() throws Exception{
		Connection con = DBConnector.getConnector();
		String sql = "SELECT * FROM COUNTRIES";
		
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		ArrayList<CountryDTO> cdtos = new ArrayList<>();
		while(rs.next()) {
			CountryDTO cdto = new CountryDTO();
			cdto.setCountry_id(rs.getString("COUNTRY_ID"));
			cdto.setCountry_name(rs.getString("COUNTRY_NAME"));
			cdto.setRegion_id(rs.getInt("REGION_ID"));
			cdtos.add(cdto);
		}
		DBConnector.disConnect(rs, ps, con);
		return cdtos;
	}
	
	// 추가하기 ( insert )
	public int add(CountryDTO cdto) throws Exception{
		Connection con = DBConnector.getConnector();
		String sql = "INSERT INTO COUNTRIES VALUES (?,?,?)";
		
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, cdto.getCountry_id());
		ps.setString(2, cdto.getCountry_name());
		ps.setInt(3, cdto.getRegion_id());
		
		int result = ps.executeUpdate();
		DBConnector.disConnect(ps, con);
		return result;
	}
	
	// 수정하기 ( update )
	public int update(CountryDTO cdto) throws Exception{
		Connection con = DBConnector.getConnector();
		String sql = "UPDATE COUNTRIES SET COUNTRY_NAME = ?, REGION_ID = ? WHERE COUNTRY_ID = ?";
		
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, cdto.getCountry_name());
		ps.setInt(2, cdto.getRegion_id());
		ps.setString(3, cdto.getCountry_id());
		
		int result = ps.executeUpdate();
		DBConnector.disConnect(ps, con);
		return result;
	}
}
