package it.polito.tdp.borders.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.borders.model.Border;
import it.polito.tdp.borders.model.Country;

public class BordersDAO {

	public List<Country> loadAllCountries(int anno) {

		String sql = "SELECT ccode,StateAbb,StateNme " + "FROM country, contiguity " + "WHERE country.StateAbb = contiguity.state1ab AND year = ?";

		try {
			List<Country> countries = new ArrayList<Country>() ;
			Connection conn = DBConnect.getInstance().getConnection();
			PreparedStatement st = conn.prepareStatement(sql);

			st.setInt(1, anno);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				countries.add(new Country(rs.getInt("ccode"), rs.getString("StateABB"), rs.getString("StateNme")));
			}

			conn.close();
			return countries;

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Database Error -- loadAllCountries");
			throw new RuntimeException("Database Error");
		}
	}

	public List<Border> getCountryPairs(int anno) {
		String sql = 
		"SELECT contiguity.state1ab, contiguity.state2ab "+
		"FROM country, contiguity "+
		"WHERE country.StateAbb = contiguity.state1ab "+
		"AND country.StateAbb = contiguity.state1ab "+
		"AND contiguity.conttype = 1 "+
		"AND contiguity.year <= ?";
		
		List<Border> borders = new ArrayList<Border>();
		
		try {
			
			Connection conn = DBConnect.getInstance().getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, anno);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				borders.add(new Border(new Country(rs.getString(1)), new Country(rs.getString(2))));
			}

			conn.close();
			return borders;

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Database Error -- setBorders");
			throw new RuntimeException("Database Error");
		}
		
	}
	
	
}
