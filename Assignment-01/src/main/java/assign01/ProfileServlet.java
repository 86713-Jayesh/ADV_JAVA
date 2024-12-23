package assign01;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/profile")
public class ProfileServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Profile Information</title>");
        out.println("</head>");
        out.println("<body bgcolor='pink'>");
        out.println("<h1>Profile Information</h1>");
        out.println("<p>First Name: JAYESH</p>");
        out.println("<p>Last Name: WAGH</p>");
        out.println("<p>Qualification: B-TECH</p>");
        out.println("<p>College: SUNBEAM INFO.</p>");
        out.println("</body>");
        out.println("</html>");
    }
}
