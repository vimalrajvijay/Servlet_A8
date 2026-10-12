package servlet_config;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LoanServlet extends HttpServlet{

	private double interest;
	@Override
	public void init() throws ServletException {
		ServletConfig config = getServletConfig();
		interest = Double.parseDouble(config.getInitParameter("interest"));
		
	}	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter writer = resp.getWriter();
		writer.println("Interest : "+ interest);
	}
}
