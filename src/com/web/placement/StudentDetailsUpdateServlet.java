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

@WebServlet("/StudentDetailsUpdateServlet")
public class StudentDetailsUpdateServlet extends HttpServlet {
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


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println("Hello World");
		try {
			updateStudentDetails(request,response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	private void updateStudentDetails(HttpServletRequest request, HttpServletResponse response) throws Exception{
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
		studentDbUtil.updateStudentDetails(student);
		request.setAttribute("student_details", student);
		dispatcher=request.getRequestDispatcher("/student_home.jsp");
		dispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			loadStudentDetails(request,response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	private void loadStudentDetails(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String usn=request.getParameter("usn");
		Student studentDetails= studentDbUtil.getStudentDetails(usn);
		//System.out.println("Student Details:"+studentDetails.toString());
		request.setAttribute("STUDENT_DETAILS", studentDetails);
		RequestDispatcher dispatcher=request.getRequestDispatcher("/update_form.jsp");
		dispatcher.forward(request, response);
	}

}
