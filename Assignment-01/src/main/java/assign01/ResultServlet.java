package assign01;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/result")
public class ResultServlet extends HttpServlet {

    private ArrayList<Marks> result;

    @Override
    public void init(ServletConfig config) throws ServletException {
        result = new ArrayList<>(); // Initialize the ArrayList
        result.add(new Marks("Java programming", 80.0));
        result.add(new Marks("Web programming", 85.0));
        result.add(new Marks("Database technologies", 83.0));
        result.add(new Marks("Operating Systems", 92.0));
        result.add(new Marks("Software Developments", 73.0));
        result.add(new Marks("C plus plus", 82.0));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<html>");
        out.println("<body>");
        out.println("<h1>Result</h1>");
        out.println("<table border='1'>");
        out.println("<tr><th>Subjects</th><th>Marks</th></tr>");
        for (Marks m : result) {
            out.println("<tr>");
            out.printf("<td>%s</td>\r\n", m.getSubjects());
            out.printf("<td>%.2f</td>\r\n", m.getMarks());
            out.println("</tr>");
        }
        out.println("</table>");
        out.println("</body>");
        out.println("</html>");
    }
}
