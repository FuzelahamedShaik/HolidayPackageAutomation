package com;

public class Package {
	
	private String packageId;
	private String sourcePlace;
	private String destinationPlace;
	private double basicFare;
	private int noOfDays;
	private double packageCost;
	
	public String getPackageId() {
		return packageId;
	}
	public void setPackageId(String packageId) {
		this.packageId = packageId;
	}
	public String getSourcePlace() {
		return sourcePlace;
	}
	public void setSourcePlace(String sourcePlace) {
		this.sourcePlace = sourcePlace;
	}
	public String getDestinationPlace() {
		return destinationPlace;
	}
	public void setDestinationPlace(String destinationPlace) {
		this.destinationPlace = destinationPlace;
	}
	public double getBasicFare() {
		return basicFare;
	}
	public void setBasicFare(double basicFare) {
		this.basicFare = basicFare;
	}
	public int getNoOfDays() {
		return noOfDays;
	}
	public void setNoOfDays(int noOfDays) {
		this.noOfDays = noOfDays;
	}
	public double getPackageCost() {
		return packageCost;
	}
	public void setPackageCost(double packageCost) {
		this.packageCost = packageCost;
	}
	
	public void calculatePackageCost() {
		//Package p = new Package();
		if(noOfDays<=5) {
			double amt = basicFare*noOfDays;
			double gst = (amt*12)/100;
			double res = amt+gst;
			setPackageCost(res);
		}
		if(noOfDays>5 && noOfDays<=8) {
			double amt = basicFare*noOfDays;
			double dis = (amt*3)/100;
			double gst = (amt*12)/100;
			double res = (amt-dis)+gst;
			setPackageCost(res);
		}
		if(noOfDays>8 && noOfDays<=10) {
			double amt = basicFare*noOfDays;
			double dis = (amt*5)/100;
			double gst = (amt*12)/100;
			double res = (amt-dis)+gst;
			setPackageCost(res);
		}
		if(noOfDays>10) {
			double amt = basicFare*noOfDays;
			double dis = (amt*7)/100;
			double gst = (amt*12)/100;
			double res = (amt-dis)+gst;
			setPackageCost(res);
		}
	}
	
}
