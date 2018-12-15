package com.web.placement;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

@WebServlet("/FileUploadServlet")
public class FileUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Got It!");
		System.out.println("Value:"+request.getParameter("usn_number"));
		ServletFileUpload upload=new ServletFileUpload(new DiskFileItemFactory());
		try {
			List<FileItem> resume=upload.parseRequest(request);
			for(FileItem i :resume) {
				String fileName=i.getName().substring(i.getName().lastIndexOf("\\")+1);
				System.out.println(fileName);
				//System.out.println(extn);
				i.write(new File("D:\\My Project\\resumes\\"+fileName));
			}
		} catch (Exception e) {
			//e.printStackTrace();
			System.out.println("Done!");
		}
		finally {
			RequestDispatcher dispatcher=request.getRequestDispatcher("/placement_cell_home.jsp");
			dispatcher.forward(request, response);
		}
	}

}
