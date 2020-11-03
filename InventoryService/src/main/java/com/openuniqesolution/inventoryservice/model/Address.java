package com.openuniqesolution.inventoryservice.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Address {

	@Id
	private int addressId;
	private String houseNumber;
	private String line1;
	private int zipcode;
	private String state;
	private String city;
	
	
	public Address() {
		
	}
	
	public Address(int addressId, String houseNumber, String line1, int zipcode, String state, String city) {
		this.addressId = addressId;
		this.houseNumber = houseNumber;
		this.line1 = line1;
		this.zipcode = zipcode;
		this.state = state;
		this.city = city;
	}
	
	public int getAddressId() {
		return addressId;
	}
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}
	public String getHouseNumber() {
		return houseNumber;
	}
	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}
	public String getLine1() {
		return line1;
	}
	public void setLine1(String line1) {
		this.line1 = line1;
	}
	public int getZipcode() {
		return zipcode;
	}
	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	
	
}
