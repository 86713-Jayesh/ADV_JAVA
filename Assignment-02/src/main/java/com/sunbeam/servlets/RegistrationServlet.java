package com.sunbeam.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunbeam.daos.UserDao;
import com.sunbeam.daos.UserDaoImpl;
import com.sunbeam.entities.User;
@WebServlet("/register")
public class RegistrationServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}
	protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	  
	    String firstName = req.getParameter("first_name");
	    String lastName = req.getParameter("last_name");
	    String email = req.getParameter("email");
	    String password = req.getParameter("password");
	    String dob = req.getParameter("dob");
	    Date date = Date.valueOf(dob); 

	   
	    resp.setContentType("text/html");
	    try (PrintWriter out = resp.getWriter();
	         UserDao userDao = new UserDaoImpl()) {
	        
	       
	        User user = new User(0, firstName, lastName, email, password, date, 0, "voter");

	      
	        int result = userDao.save(user);
	        if (result > 0) {
	            out.println("<html>");
	            out.println("<head>");
	            out.println("<title>Registration Success</title>");
	            out.println("</head>");
	            out.println("<body>");
	            out.println("<h2>Registration Successful</h2>");
	            out.println("<p>Welcome, " + firstName + " " + lastName + "!</p>");
	            out.println("<p><a href='index.html'>Click here to Login</a></p>");
	            out.println("</body>");
	            out.println("</html>");
	        } else {
	            out.println("<html>");
	            out.println("<head>");
	            out.println("<title>Registration Failed</title>");
	            out.println("</head>");
	            out.println("<body>");
	            out.println("<h2>Registration Failed</h2>");
	            out.println("<p>Something went wrong while saving your details. Please try again.</p>");
	            out.println("<p><a href='newuser.html'>Register Again</a></p>");
	            out.println("</body>");
	            out.println("</html>");
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	        throw new ServletException("Error occurred during registration", e);
	    }
	}
}