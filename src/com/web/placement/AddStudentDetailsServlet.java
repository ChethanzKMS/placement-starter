package com.web.placement;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@WebServlet("/AddStudentDetailsServlet")
public class AddStudentDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StudentDbUtil studentDbUtil;
	
	@Resource(name="jdbc/web_student_tracker")
	private DataSource dataSource;
	
	
	
	@Override
	public void init() throws ServletException {
		super.init();
		try {
			studentDbUtil=new StudentDbUtil(dataSource);
		}
		catch(Exception e) {
			throw new ServletException(e);
		}
	}



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			addStudentDetails(request,response);
		} catch (Exception e) {
			throw new ServletException(e);
		}
		
	}



	private void addStudentDetails(HttpServletRequest request, HttpServletResponse response) throws Exception {
		RequestDispatcher dispatcher=null;
		String usn=request.getParameter("usn");
		String firstName=request.getParameter("fname");
		String lastName=request.getParameter("lname");
		String branch=request.getParameter("branch");
		String dob=request.getParameter("dob");
		String email=request.getParameter("email");
		long phone=Long.valueOf(request.getParameter("phone")) ;
		String address=request.getParameter("address");
		double sslc=Double.valueOf(request.getParameter("sslc"));
		double puc=Double.valueOf(request.getParameter("puc"));
		double cgpa=Double.valueOf(request.getParameter("CGPA"));
		double sgpa=Double.valueOf(request.getParameter("SGPA"));
		Student student=new Student(usn,firstName,lastName,dob,address,phone,sslc,puc,cgpa,sgpa,email,branch);
		studentDbUtil.addStudentDetails(student);
		dispatcher=request.getRequestDispatcher("/placement_cell_home.jsp");
		dispatcher.forward(request, response);
		
	}
	
	

}
