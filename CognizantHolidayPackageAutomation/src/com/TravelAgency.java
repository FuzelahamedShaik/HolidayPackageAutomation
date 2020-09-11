package com;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TravelAgency {
	
	public List<Package> generatePackageCost (String filepath) throws IOException, InvalidPackageIdException {
		BufferedReader bf = new BufferedReader(new FileReader(filepath));
		List<Package> list = new LinkedList<Package>();
		String line;
		while((line=bf.readLine())!=null) {
			try {
				String[] s = line.split(",");
				Package p = new Package();
				if(validate(s[0])) {
					p.setPackageId(s[0]);
					p.setSourcePlace(s[1]);
					p.setDestinationPlace(s[2]);
					p.setBasicFare(Integer.parseInt(s[3]));
					p.setNoOfDays(Integer.parseInt(s[4]));
					p.calculatePackageCost();
					p.setPackageCost(p.getPackageCost());
					list.add(p);
				}
			}catch(InvalidPackageIdException e) {
				continue;
			}
		}
		return list;
	}
	
	public boolean validate(String packageId) throws InvalidPackageIdException {
		String regex = "[0-9]{3}[/]{1}[A-Z]{3}";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(packageId);
		if(m.matches()) {
			return true;
		}else throw new InvalidPackageIdException();
	}
	
	public List<Package> findPackagesWithMinimumNumberOfDays() throws IOException, SQLException, ClassNotFoundException {
		DBHandler db = new DBHandler();
		Connection con = db.establishConnection();
		List<Package> list = new LinkedList<Package>();
		PreparedStatement ps = con.prepareStatement("select * from Package_Details where no_of_days = (select min(no_of_days) from Package_Details)");
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			Package p = new Package();
			p.setPackageId(rs.getString(1));
			p.setSourcePlace(rs.getString(2));
			p.setDestinationPlace(rs.getString(3));
			p.setNoOfDays(rs.getInt(4));
			p.setBasicFare(rs.getInt(5));
			list.add(p);
		}
		return list;
	}
	
}
