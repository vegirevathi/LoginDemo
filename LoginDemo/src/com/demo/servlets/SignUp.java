package com.demo.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SignUp
 */
@WebServlet("/SignUp")
public class SignUp extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname = request.getParameter("SaveUserName");
		String pword = request.getParameter("SavePassWord");
		PrintWriter out = response.getWriter();
		
		SignUpDao signup = new SignUpDao();
		if(signup.saveDetails(uname, pword)!=0) {
			out.println("Details saved successfully");
			response.sendRedirect("login.jsp");
		} else {
			out.println("Details not saved. Try again");
			response.sendRedirect("signup.jsp");
		}
	}

}
