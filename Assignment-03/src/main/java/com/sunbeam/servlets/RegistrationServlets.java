package com.sunbeam.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunbeam.daos.UserDao;
import com.sunbeam.daos.UserDaoImpl;
import com.sunbeam.entities.User;

@WebServlet("/registrationServlet")
public class RegistrationServlets extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}

	protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String fName = req.getParameter("first_name");
		String lName = req.getParameter("last_name");
		String email = req.getParameter("email");
		String pass = req.getParameter("passwd");
		String date = req.getParameter("dob");
		Date dob = Date.valueOf(date);
		
		User u = new User(0, fName, lName, email, pass, dob, 0, "voter");
		
		
		try (UserDao userDao = new UserDaoImpl()){
			int count = userDao.save(u);
			resp.setContentType("text/html");
			PrintWriter out = resp.getWriter();
			
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Register</title>");
			out.println("</head>");			
			out.println("<body>");			
			out.println("<h2>Registration Successful</h2>");
			out.println("<p><a href = 'index.html'>Login</a></p>");
			out.println("</body>");			
			out.println("</html>");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
