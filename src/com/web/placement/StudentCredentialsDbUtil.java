package com.web.placement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class StudentCredentialsDbUtil {
	private DataSource dataSource;
	
	public StudentCredentialsDbUtil(DataSource theDataSource) 
	{
		dataSource=theDataSource;
	}
	
	public List<StudentCredentials> getCredentials() throws Exception {
		List<StudentCredentials> credentials= new ArrayList<StudentCredentials>();
		Connection myConn=null;
		Statement myStmt=null;
		ResultSet myResultSet=null;
		
		try {
			myConn=dataSource.getConnection();
			String sql="select * from studentsCredentials";
			myStmt=myConn.createStatement();
			myResultSet=myStmt.executeQuery(sql);
			
			while(myResultSet.next())
			{
				String usn=myResultSet.getString("usn");
				String password=myResultSet.getString("password");
				StudentCredentials tempStudentCred=new StudentCredentials(usn,password);
				credentials.add(tempStudentCred);
			}
			return credentials;
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

	public int addStudent(StudentCredentials studentCred) throws Exception {
		Connection myConn=null;
		PreparedStatement myStmt=null;
		try {
			myConn=dataSource.getConnection();
			int rowsAffected = 0; 
			String sql="insert into studentsCredentials VALUES (?,?)";
			myStmt=myConn.prepareStatement(sql);
			myStmt.setString(1, studentCred.getUsn());
			myStmt.setString(2, studentCred.getPassword());
			myStmt.execute();
			rowsAffected = myStmt.getUpdateCount(); 
			System.out.println("Rows inserted:"+rowsAffected);
			return rowsAffected;
		}
		finally {
			close(myConn, myStmt, null);
		}
		
	}
		
	}
