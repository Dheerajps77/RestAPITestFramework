package com.qa.restapi.data;


public class PUTAPIUser {
	
	String street;
	String suite;
	String city;
	String zipCode;
	
	public PUTAPIUser(String street, String suite, String city, String zipCode)
	{
		this.street=street;
		this.suite=suite;
		this.city=city;
		this.zipCode=zipCode;
		
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getSuite() {
		return suite;
	}

	public void setSuite(String suite) {
		this.suite = suite;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	
	

}
