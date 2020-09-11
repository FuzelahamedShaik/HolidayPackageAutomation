package com;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

public class Main {

	public static void main(String[] args) throws IOException, InvalidPackageIdException, SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		
		TravelAgency agency = new TravelAgency();
		List<Package> list = agency.generatePackageCost("VarshTourPackageDetails.txt");
		System.out.println("-----------------------------------------------");
		System.out.println("Valid package cost and details are below");
		System.out.println();
		for(Package p:list) {
			System.out.printf(p.getPackageId()+" "+p.getSourcePlace()+" "+p.getDestinationPlace()+" "+p.getNoOfDays()+" ");
			System.out.printf("%.2f", p.getPackageCost());
			System.out.println();
		}
		System.out.println("-----------------------------------------------");
		System.out.println("Packages with minimum number of days are");
		System.out.println();
		List<Package> list1 = agency.findPackagesWithMinimumNumberOfDays();
		for(Package p:list1) {
			System.out.println(p.getPackageId()+" "+p.getSourcePlace()+" to "+p.getDestinationPlace()+" for "+p.getNoOfDays()+" days");
		}
	}

}
