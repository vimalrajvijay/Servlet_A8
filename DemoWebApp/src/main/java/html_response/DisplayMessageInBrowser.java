package html_response;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DisplayMessageInBrowser extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter writer = resp.getWriter();
		resp.setContentType("text/html");
		writer.println("<html>");
		writer.println("<body>");
		writer.println("<h1> First Servlet Program </h1>");
		writer.println("</body>");
		writer.println("</html>");
	}
}
