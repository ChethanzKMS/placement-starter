package com.web.placement;

public class Student {
	private String USN,emailID;
	private String firstName,lastName,DateOfBirth, Address,branch;
	private long phoneNumber;
	private double sslcPercentage,pucPercentage, cgpa,sgpa;
	
	public Student(String uSN, String firstName, String lastName, String dateOfBirth, String address, long phoneNumber,
			double sslcPercentage, double pucPercentage, double cgpa, double sgpa,String emailID,String branch) {
		USN = uSN;
		this.firstName = firstName;
		this.lastName = lastName;
		DateOfBirth = dateOfBirth;
		Address = address;
		this.phoneNumber = phoneNumber;
		this.sslcPercentage = sslcPercentage;
		this.pucPercentage = pucPercentage;
		this.cgpa = cgpa;
		this.sgpa = sgpa;
		this.emailID = emailID;
		this.branch = branch;
	}

	public Student(String firstName, String lastName, String dateOfBirth, String address, long phoneNumber,
			double sslcPercentage, double pucPercentage, double cgpa, double sgpa, String emailID,String branch) {
		this.firstName = firstName;
		this.lastName = lastName;
		DateOfBirth = dateOfBirth;
		Address = address;
		this.phoneNumber = phoneNumber;
		this.sslcPercentage = sslcPercentage;
		this.pucPercentage = pucPercentage;
		this.cgpa = cgpa;
		this.sgpa = sgpa;
		this.emailID = emailID;
		this.branch = branch;
	}

	public String getUSN() {
		return USN;
	}

	public void setUSN(String uSN) {
		USN = uSN;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDateOfBirth() {
		return DateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		DateOfBirth = dateOfBirth;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public double getSslcPercentage() {
		return sslcPercentage;
	}

	public void setSslcPercentage(double sslcPercentage) {
		this.sslcPercentage = sslcPercentage;
	}

	public double getPucPercentage() {
		return pucPercentage;
	}

	public void setPucPercentage(double pucPercentage) {
		this.pucPercentage = pucPercentage;
	}

	public double getCgpa() {
		return cgpa;
	}

	public void setCgpa(double cgpa) {
		this.cgpa = cgpa;
	}

	public double getSgpa() {
		return sgpa;
	}

	public void setSgpa(double sgpa) {
		this.sgpa = sgpa;
	}

	public String getEmailID() {
		return emailID;
	}

	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	@Override
	public String toString() {
		return "Student [USN=" + USN + ", emailID=" + emailID + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", DateOfBirth=" + DateOfBirth + ", Address=" + Address + ", phoneNumber=" + phoneNumber
				+ ", sslcPercentage=" + sslcPercentage + ", pucPercentage=" + pucPercentage + ", cgpa=" + cgpa
				+ ", branch=" + branch+ ", sgpa=" + sgpa + "]";
	}	

}
