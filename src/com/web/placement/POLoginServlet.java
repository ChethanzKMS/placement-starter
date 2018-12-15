package com.web.placement;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/POLoginServlet")
public class POLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("adminID");
		String pwd=request.getParameter("adminpwd");
		RequestDispatcher dispatcher=null;
		if(id.equals("admin") && pwd.equals("password")) {
			dispatcher=request.getRequestDispatcher("/po_home.jsp");
		}
		else
		{
			dispatcher=request.getRequestDispatcher("/po_login_failure.jsp");
		}
		dispatcher.forward(request, response);
	}

	
}
