package com.sunbeam.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;
import com.sunbeam.daos.UserDao;
import com.sunbeam.daos.UserDaoImpl;
import com.sunbeam.entities.Candidate;
import com.sunbeam.entities.User;

@WebServlet("/addcandidate")
public class CandidateServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}

	protected void processRequest(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String Name = req.getParameter("name");
		String Party = req.getParameter("party");
		resp.setContentType("text/html");
		try (PrintWriter out = resp.getWriter();
				CandidateDao candidateDao = new CandidateDaoImpl()) {

			// Create a Candidate object with the retrieved data
			Candidate candidate = new Candidate(0, Name, Party, 0);

			// Save the candidate using CandidateDao and handle the result
			int result = candidateDao.save(candidate);
			if (result > 0) { // Success case
				out.println("<html>");
				out.println("<head>");
				out.println("<title>Add Candidate</title>");
				out.println("</head>");
				out.println("<body>");
				out.println("<h2>Candidate Added Successfully</h2>");
				out.println("<p>Candidate Name: " + Name + "</p>");
				out.println("<p>Party: " + Party + "</p>");
				out.println("<p><a href='result'>View All Candidates</a></p>");
				out.println("</body>");
				out.println("</html>");
			} else { // Failure case
				out.println("<html>");
				out.println("<head>");
				out.println("<title>Add Candidate</title>");
				out.println("</head>");
				out.println("<body>");
				out.println("<h2>Registration Failed</h2>");
				out.println("<p>Something went wrong while saving the candidate details. Please try again.</p>");
				out.println("<p><a href='addcandidate.html'>Register Again</a></p>");
				out.println("</body>");
				out.println("</html>");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException("Error occurred while adding the candidate", e);
		}
	}
}