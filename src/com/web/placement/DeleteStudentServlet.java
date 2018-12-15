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

@WebServlet("/DeleteStudentServlet")
public class DeleteStudentServlet extends HttpServlet {
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
			deleteStudent(request,response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void deleteStudent(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String usnToBeDeleted=request.getParameter("usn");
		int rowsAffected=studentDbUtil.deleteStudent(usnToBeDeleted);
		if(rowsAffected==1) {
			request.setAttribute("delete_Status", "success");
		}
		else
		{
			request.setAttribute("delete_Status", "failure");
		}
		//System.out.println("deleted row="+rowsAffected);
		RequestDispatcher dispatcher=request.getRequestDispatcher("/delete_student_form.jsp");
		dispatcher.forward(request, response);
	}

}
