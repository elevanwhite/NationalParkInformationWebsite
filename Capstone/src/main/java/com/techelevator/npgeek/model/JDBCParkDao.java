package com.techelevator.npgeek.model;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JDBCParkDao implements ParkDao{
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JDBCParkDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<Park> getAllParks() {
		
		List<Park> allParks = new ArrayList<Park>();
		String sql = "SELECT parkcode, parkname, parkdescription FROM park ORDER BY parkname;";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
		while(results.next()) {
			Park currentPark = new Park();
			currentPark.setParkCode(results.getString("parkcode"));
			currentPark.setParkName(results.getString("parkname"));
			currentPark.setDescription(results.getString("parkdescription"));
			
			allParks.add(currentPark);
		}
		
		return allParks;
	}

	@Override
	public Park getParkByCode(String code) {
		Park park = new Park();
		String sql = "SELECT parkname, state, acreage, elevationinfeet, milesoftrail, numberofcampsites, climate, yearfounded, " +
					 "annualvisitorcount, inspirationalquote, inspirationalquotesource, parkdescription, entryfee, numberofanimalspecies " +
					 "FROM park WHERE parkcode = ?;";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, code);
		if(results.next()) {
			park.setParkCode(code);
			park.setParkName(results.getString("parkname"));
			park.setState(results.getString("state"));
			park.setAcreage(results.getInt("acreage"));
			park.setElevationInFeet(results.getInt("elevationinfeet"));
			park.setMilesOfTrails(results.getDouble("milesoftrail"));
			park.setNumberOfCampsites(results.getInt("numberofcampsites"));
			park.setClimate(results.getString("climate"));
			park.setYearFounded(results.getInt("yearfounded"));
			park.setAnnualVistors(results.getInt("annualvisitorcount"));
			park.setInspirationalQuote(results.getString("inspirationalquote"));
			park.setInspQuoteSource(results.getString("inspirationalquotesource"));
			park.setDescription(results.getString("parkdescription"));
			park.setEntryFee(results.getInt("entryfee"));
			park.setNumberOfAnimalSpecies(results.getInt("numberofanimalspecies"));
		}
		
		return park;
	}

}