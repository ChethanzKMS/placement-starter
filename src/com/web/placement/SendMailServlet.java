package com.web.placement;

import java.io.FileOutputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/SendMailServlet")
public class SendMailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String emailIdsString=request.getParameter("emailIds");
		String companyName=request.getParameter("companyName");
		String location=request.getParameter("location");
		String dateOfVisit=request.getParameter("dateOfVisit");
		String reportingTime=request.getParameter("reportingTime");
		String additional_Info=request.getParameter("additional_Info");
		
		String messageText = "Hello Student! This is regarding the drive details of the company:"+companyName+", scheduled to visit "+location+" on "+dateOfVisit+". Please be reporting within the time : "+reportingTime+". Note:( "+additional_Info+" ).";
        String data=emailIdsString+"<>"+messageText;
		System.out.println(data);
        
        FileOutputStream fout=new FileOutputStream("D:\\chandu\\meta-data.txt");
        byte b[]=data.getBytes();
		try{
			 fout.write(b); 
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		finally {
			fout.close();
		}


	}

}
