package com.web.placement;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@WebServlet("/StudentLoginServlet")
public class StudentLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StudentCredentialsDbUtil studentCredentialsDbUtil;
	private StudentDbUtil studentDbUtil;
	
	@Resource(name="jdbc/web_student_tracker")
	private DataSource dataSource;
	
	@Override
	public void init() throws ServletException {
		super.init();
		try {
			studentCredentialsDbUtil=new StudentCredentialsDbUtil(dataSource);
			studentDbUtil= new StudentDbUtil(dataSource);
		}
		catch(Exception e) {
			throw new ServletException(e);
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			addStudent(request,response);
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}

	private void addStudent(HttpServletRequest request, HttpServletResponse response) throws Exception {
		RequestDispatcher dispatcher=null;
		String usn=request.getParameter("usnCred");
		String pwd=request.getParameter("defaultPwd");
		StudentCredentials studentCred=new StudentCredentials(usn,pwd);
		int rowsAffected=studentCredentialsDbUtil.addStudent(studentCred);
		if(rowsAffected==1) {
			request.setAttribute("add_Status", "success");
		}
		else
		{
			request.setAttribute("add_Status", "failure");
		}
		dispatcher=request.getRequestDispatcher("/add_student_form.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String usn=request.getParameter("usn");
		Student details=null;
		int flag=0;
		try {
			details=getStudentDetails(usn);
			//System.out.println(details.toString());
			
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		String pwd=request.getParameter("pwd");
		boolean loginStatus=false;
		RequestDispatcher dispatcher=null;
		List<StudentCredentials> studentsCred=null;
		
		try {
			studentsCred=studentCredentialsDbUtil.getCredentials();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		for(int i=0;i<studentsCred.size();i++) {
			if(usn.equals(studentsCred.get(i).getUsn()) && pwd.equals(studentsCred.get(i).getPassword())) {
				loginStatus=true;
			}
		}
		
		if(loginStatus) {
			if(details!=null) {
				request.setAttribute("student_details", details);
				dispatcher=request.getRequestDispatcher("/student_home.jsp");
			}
			else if(details==null) {
				dispatcher=request.getRequestDispatcher("/student_registration_form.jsp");
			}
		}
		else
		{
			dispatcher=request.getRequestDispatcher("/student_login_failure.jsp");
		}
		dispatcher.forward(request, response);
	}

	private Student getStudentDetails(String usn) throws Exception {
		Student studentDetails=studentDbUtil.getStudentDetails(usn);
		return studentDetails;
	}

	
}
