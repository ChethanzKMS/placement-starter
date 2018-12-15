package com.web.placement;

public class StudentCredentials {
	private String usn,password;

	public StudentCredentials(String usn, String password) {
		this.usn = usn;
		this.password = password;
	}

	public String getUsn() {
		return usn;
	}

	public void setUsn(String usn) {
		this.usn = usn;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "StudentCredentials [usn=" + usn + ", password=" + password + "]";
	}
	

}
