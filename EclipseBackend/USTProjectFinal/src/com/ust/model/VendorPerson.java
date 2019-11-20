package com.ust.model;

public class VendorPerson 
{

//Instance variables of Vendor and Person fileds
	
	 private int vendorId;
	 private String vendorName;
	 private String vendorAddress;
	 private String location;
	 private String service;
	 private int pincode;
	 private String isActive;
	 
	 private int contactId;
	 private String contactName;
	 private String department;
	 private String email;
	 private String phone;
	 
	 
//Default Constructor
	 
	public VendorPerson()
	{
		super();
	}


//Parameterized  Constructor
	
	
	public VendorPerson(int vendorId, String vendorName, String vendorAddress,
			String location, String service, int pincode, String isActive,
			int contactId, String contactName, String department, String email,
			String phone) {
		super();
		this.vendorId = vendorId;
		this.vendorName = vendorName;
		this.vendorAddress = vendorAddress;
		this.location = location;
		this.service = service;
		this.pincode = pincode;
		this.isActive = isActive;
		this.contactId = contactId;
		this.contactName = contactName;
		this.department = department;
		this.email = email;
		this.phone = phone;
	}


//Getters and setters
	
	public int getVendorId() {
		return vendorId;
	}


	public void setVendorId(int vendorId) {
		this.vendorId = vendorId;
	}


	public String getVendorName() {
		return vendorName;
	}


	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}


	public String getVendorAddress() {
		return vendorAddress;
	}


	public void setVendorAddress(String vendorAddress) {
		this.vendorAddress = vendorAddress;
	}


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}


	public String getService() {
		return service;
	}


	public void setService(String service) {
		this.service = service;
	}


	public int getPincode() {
		return pincode;
	}


	public void setPincode(int pincode) {
		this.pincode = pincode;
	}


	public String getIsActive() {
		return isActive;
	}


	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}


	public int getContactId() {
		return contactId;
	}


	public void setContactId(int contactId) {
		this.contactId = contactId;
	}


	public String getContactName() {
		return contactName;
	}


	public void setContactName(String contactName) {
		this.contactName = contactName;
	}


	public String getDepartment() {
		return department;
	}


	public void setDepartment(String department) {
		this.department = department;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}
	 
	 
	 
	 
}
