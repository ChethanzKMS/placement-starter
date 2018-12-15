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

@WebServlet("/ShortListedStudentsServlet")
public class ShortListedStudentsServlet extends HttpServlet {
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
		List<Student> students=null;
		double tenthPercentage, pucPercentage, cgpa,sgpa;
		String branchType=request.getParameter("branch_type");
		tenthPercentage=Double.parseDouble(request.getParameter("sslcCutoff"));
		pucPercentage=Double.parseDouble(request.getParameter("pucCutoff"));
		cgpa=Double.parseDouble(request.getParameter("CGPACutoff"));
		sgpa=Double.parseDouble(request.getParameter("SGPACutoff"));
		//System.out.println("10th:"+tenthPercentage);
		//System.out.println("12th:"+pucPercentage);
		cgpa=cgpa-0.000001;
		sgpa=sgpa-0.000001;
		//System.out.println("CGPA:"+cgpa);
		//System.out.println("SGPA:"+sgpa);
		//System.out.println("Selected:"+branchType);
		String sqlQuery="select * from placementStudents where sslc_percentage>="+tenthPercentage+" and puc_percentage>="+pucPercentage+" and cgpa>="+cgpa+" and sgpa>="+sgpa;
		if(branchType.equals("specific") && (request.getParameterValues("branch"))!=null) {
			String selectedBranches[]=request.getParameterValues("branch");
			for(int i=0;i<selectedBranches.length;i++) {
				//System.out.println(selectedBranches[i]);
				sqlQuery=sqlQuery+" and branch='"+selectedBranches[i]+"'";
			}
		}
		sqlQuery=sqlQuery+";";
		//System.out.println(sqlQuery);
		try {
			students = studentDbUtil.ShortListStudents(sqlQuery);
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("STUDENTS_LIST", students);
		request.setAttribute("backButtonNeeded", "yes");
		RequestDispatcher dispatcher=request.getRequestDispatcher("/list_students.jsp");
		dispatcher.forward(request, response);
	}

}
