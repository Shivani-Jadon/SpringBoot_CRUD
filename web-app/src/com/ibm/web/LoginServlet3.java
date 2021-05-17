package com.ibm.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LoginServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userid = request.getParameter("userid");
		String passwd = request.getParameter("passwd");
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		if(userid.equals("Duke") && passwd.equals("java")){
			// Login success
			 response.sendRedirect("hello.jsp");
			// out.println("<h1>Login Success</h1>");
			
		}else {
			// Login failed
			// response.sendRedirect("login.jsp");
			out.println("<h1>Invalid user</h1>");
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
