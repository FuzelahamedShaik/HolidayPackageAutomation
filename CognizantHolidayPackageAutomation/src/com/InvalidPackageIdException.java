package com;

public class InvalidPackageIdException extends Exception {
	
	public InvalidPackageIdException() {
		System.out.println("Invalid Package Id");
	}
	
	public InvalidPackageIdException(String err) {
		super(err);
	}
	
}
