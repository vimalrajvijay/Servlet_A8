package servlet_config;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LoanServlet extends HttpServlet{

	private double interest;
	private String bankName;
	private User user;
	
	@Override
	public void init() throws ServletException {
		ServletConfig config = getServletConfig();
		interest = Double.parseDouble(config.getInitParameter("interest"));
		
		ServletContext context = getServletContext();
		bankName = context.getInitParameter("bankName");
		
		user = (User)context.getAttribute("user");
	}	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter writer = resp.getWriter();
		writer.println("Bank Name: "+bankName);
		writer.println("Interest : "+ interest);
		writer.println("User     : "+ user);
	}
}
