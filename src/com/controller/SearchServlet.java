package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.DBApplication;
import com.model.Register;


public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
    public SearchServlet() {
        super();
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		
			Register u = new Register();
		u.setUname(request.getParameter("uname"));
		DBApplication db = new DBApplication();
		List<Register> ls = db.getUser(u);
		Iterator<Register> itr = ls.iterator();
		u = itr.next();
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		pw.println("<html><head><link rel=\"stylesheet\" type=\"text/css\" href=\"main.css\"><title>");
		pw.println("User details");
		pw.println("</title></head><body><div class=\"wrapper\" \"><div class=\"inner\" style=\"background-image: url('images/bg-registration-form-2.jpg');\"><table border=\"2\" cellpadding=\"3\"><tr>");
		pw.println("<th>name</th><th>User name</th><th>password</th><th>Gender</th><th>Email</th><th>Phone no</th><th>Subject</th><th>Balance</th>");
		pw.println("</tr><tr>");
		pw.println("<td>"+u.getFname()+"</td><td>"+u.getUname()+"</td><td>"+u.getPassword()+"</td><td>"+u.getGender()+"</td><td>"+u.getEmail()+"</td><td>"+u.getPhone()+"</td><td>"+u.getSubject()+"</td><td>"+u.getBalance()+"</td></tr>");
		pw.print("</table>");
		pw.println("<h4><a href=\"Welcome.jsp\">Welcome Page</a></h4></div></div></body>");
		}
	 catch (Exception e) {
		response.sendRedirect("Search.jsp");
		e.printStackTrace();
	}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
