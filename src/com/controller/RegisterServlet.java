package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.print.DocFlavor.STRING;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.DBApplication;
import com.model.Register;

/**
 * Servlet implementation class RegisterServlet
 */
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Register u = new Register();
			List<Register> ls = new ArrayList<Register>();
			u.setFname(request.getParameter("fname"));
			u.setUname(request.getParameter("uname"));
			u.setPassword(request.getParameter("password"));
			u.setGender(request.getParameter("gender"));
			u.setEmail(request.getParameter("email"));
			u.setPhone(Long.parseLong(request.getParameter("phone")));
			u.setSubject(request.getParameter("subject"));
			u.setBalance(Long.parseLong(request.getParameter("balance")));
			ls.add(u);
			
			DBApplication db = new DBApplication();
			int i = db.saveData(ls);
			
			if(i>0) {
				response.sendRedirect("Login.jsp");
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		catch(Exception e) {
			System.out.println(e);
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
