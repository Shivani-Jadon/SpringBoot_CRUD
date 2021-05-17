package com.ibm.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloWeb extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int counter = 1015;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		out.println("<h1> Hello beautiful World! </h1>");
		out.println("<h2> Welcome to My Hello Servlet </h2>");
		counter++;
		out.println("<h3> You are visitor no.: " + counter + " </h3>");
		Date now = new Date();
		out.println("<h3>Log: " + now + "</h3>");
	}

}
