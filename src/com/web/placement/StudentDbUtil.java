package com.web.placement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class StudentDbUtil {
	private DataSource dataSource;
	
	public StudentDbUtil(DataSource theDataSource) 
	{
		dataSource=theDataSource;
	}
	
	public List<Student> getStudents() throws Exception {
		List<Student> students= new ArrayList<Student>();
		Connection myConn=null;
		Statement myStmt=null;
		ResultSet myResultSet=null;
		
		try {
			myConn=dataSource.getConnection();
			String sql="select * from placementStudents";
			myStmt=myConn.createStatement();
			myResultSet=myStmt.executeQuery(sql);
			
			while(myResultSet.next())
			{
				String firstName=myResultSet.getString("first_name");
				String lastName=myResultSet.getString("last_name");
				String branch=myResultSet.getString("branch");
				String emailId=myResultSet.getString("email_ID");
				String USN=myResultSet.getString("usn");
				String dob=myResultSet.getString("dob");
				String address=myResultSet.getString("address");
				long phone=myResultSet.getLong("phone_number");
				double sslcPercentage=myResultSet.getDouble("sslc_percentage");
				double pucPercentage=myResultSet.getDouble("puc_percentage");
				double cgpa=myResultSet.getDouble("cgpa");
				double sgpa=myResultSet.getDouble("sgpa");
				
				Student tempStudent=new Student(USN, firstName, lastName, dob, address, phone, sslcPercentage, pucPercentage, cgpa, sgpa, emailId,branch);
				students.add(tempStudent);
			}
			
			return students;
		}
		finally {
			close(myConn,myStmt,myResultSet);
		}
		
		
	}
	
	public List<Student> ShortListStudents(String sqlQuery) throws Exception{
		List<Student> students= new ArrayList<Student>();
		Connection myConn=null;
		Statement myStmt=null;
		ResultSet myResultSet=null;
		
		try {
			myConn=dataSource.getConnection();
			myStmt=myConn.createStatement();
			myResultSet=myStmt.executeQuery(sqlQuery);
			while(myResultSet.next())
			{
				String firstName=myResultSet.getString("first_name");
				String lastName=myResultSet.getString("last_name");
				String branch=myResultSet.getString("branch");
				String emailId=myResultSet.getString("email_ID");
				String USN=myResultSet.getString("usn");
				String dob=myResultSet.getString("dob");
				String address=myResultSet.getString("address");
				long phone=myResultSet.getLong("phone_number");
				double sslcPercentage=myResultSet.getDouble("sslc_percentage");
				double pucPercentage=myResultSet.getDouble("puc_percentage");
				double cgpa=myResultSet.getDouble("cgpa");
				double sgpa=myResultSet.getDouble("sgpa");
				
				Student tempStudent=new Student(USN, firstName, lastName, dob, address, phone, sslcPercentage, pucPercentage, cgpa, sgpa, emailId,branch);
				students.add(tempStudent);
			}
			
			return students;
		}
		finally {
			close(myConn,myStmt,myResultSet);
		}
		
		
	}

	private void close(Connection myConn, Statement myStmt, ResultSet myResultSet) {
		try {
			if(myResultSet!=null) {
				myResultSet.close();
			}
			if(myConn!=null) {
				myConn.close();
			}
			if(myStmt!=null) {
				myStmt.close();
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	public int deleteStudent(String usnToBeDeleted) throws Exception{
		Connection myConn=null;
		PreparedStatement myStmt=null;
		
		try {
			myConn=dataSource.getConnection();
			int rowsAffected = 0;
			String sql="delete from placementStudents where usn=?";
			String sql1="delete from studentsCredentials where usn=?";
			myStmt=myConn.prepareStatement(sql);
			myStmt.setString(1, usnToBeDeleted);
			myStmt.execute();
			myStmt=myConn.prepareStatement(sql1);
			myStmt.setString(1, usnToBeDeleted);
			myStmt.execute();
			rowsAffected = myStmt.getUpdateCount(); 
			return rowsAffected;
		}
		finally {
			close(myConn,myStmt,null);
		}
		
	}

	public void addStudentDetails(Student student) throws Exception {
		Connection myConn=null;
		PreparedStatement myStmt=null;
		try {
			myConn=dataSource.getConnection();
			String sql="insert into placementStudents VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
			myStmt=myConn.prepareStatement(sql);
			myStmt.setString(1, student.getUSN());
			myStmt.setString(2, student.getFirstName());
			myStmt.setString(3, student.getLastName());
			myStmt.setString(4, student.getBranch());
			myStmt.setString(5, student.getEmailID());
			myStmt.setString(6, student.getDateOfBirth());
			myStmt.setString(7, student.getAddress());
			myStmt.setLong(8, student.getPhoneNumber());
			myStmt.setDouble(9, student.getSslcPercentage());
			myStmt.setDouble(10, student.getPucPercentage());
			myStmt.setDouble(11, student.getCgpa());
			myStmt.setDouble(12, student.getSgpa());
			myStmt.execute();
			int rowsAffected = myStmt.getUpdateCount(); 
			System.out.println("Rows inserted:"+rowsAffected);
			
		}
		finally {
			close(myConn, myStmt, null);
		}
		
	}

	public Student getStudentDetails(String usn) throws Exception {
		Student tempStudent=null;
		Connection myConn=null;
		Statement myStmt=null;
		ResultSet myResultSet=null;
		try {
			myConn=dataSource.getConnection();
			String sql="select * from placementStudents where usn='"+usn+"'";
			//System.out.println(sql);
			myStmt=myConn.createStatement();
			myResultSet=myStmt.executeQuery(sql);
			
			while(myResultSet.next())
			{
				String firstName=myResultSet.getString("first_name");
				String lastName=myResultSet.getString("last_name");
				String branch=myResultSet.getString("branch");
				String emailId=myResultSet.getString("email_ID");
				String USN=myResultSet.getString("usn");
				String dob=myResultSet.getString("dob");
				String address=myResultSet.getString("address");
				long phone=myResultSet.getLong("phone_number");
				double sslcPercentage=myResultSet.getDouble("sslc_percentage");
				double pucPercentage=myResultSet.getDouble("puc_percentage");
				double cgpa=myResultSet.getDouble("cgpa");
				double sgpa=myResultSet.getDouble("sgpa");
				tempStudent=new Student(USN, firstName, lastName, dob, address, phone, sslcPercentage, pucPercentage, cgpa, sgpa, emailId,branch);
			}
		return tempStudent;
	}finally {
		close(myConn,myStmt,myResultSet);
	}
	
	}

	public void updateStudentDetails(Student student) throws Exception {
		//System.out.println(student.toString());
		Connection myConn=null;
		PreparedStatement myStmt=null;
		try {
		myConn=dataSource.getConnection();
		String sql="update placementStudents set first_name=?,last_name=?,branch=?,email_ID=?,dob=?,address=?,phone_number=?,sslc_percentage=?,puc_percentage=?,cgpa=?,sgpa=? where usn=?";
		myStmt=myConn.prepareStatement(sql);
		myStmt.setString(1, student.getFirstName());
		myStmt.setString(2, student.getLastName());
		myStmt.setString(3, student.getBranch());
		myStmt.setString(4, student.getEmailID());
		myStmt.setString(5, student.getDateOfBirth());
		myStmt.setString(6, student.getAddress());
		myStmt.setLong(7, student.getPhoneNumber());
		myStmt.setDouble(8, student.getSslcPercentage());
		myStmt.setDouble(9, student.getPucPercentage());
		myStmt.setDouble(10, student.getCgpa());
		myStmt.setDouble(11, student.getSgpa());
		myStmt.setString(12, student.getUSN());
		
		myStmt.execute();
		}
		finally {
			close(myConn, myStmt, null);
		}
	}
	
}
