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

@WebServlet("/StudentControllerServlet")
public class StudentControllerServlet extends HttpServlet {
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
		try {
		listStudents(request,response);
		}
		catch(Exception e) {
			throw new ServletException(e);
		}
	}



	private void listStudents(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<Student> students=studentDbUtil.getStudents();
		request.setAttribute("STUDENTS_LIST", students);
		request.setAttribute("backButtonNeeded", "no");
		RequestDispatcher dispatcher=request.getRequestDispatcher("/list_students.jsp");
		dispatcher.forward(request, response);
	}

}
