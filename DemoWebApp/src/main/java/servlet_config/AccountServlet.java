package servlet_config;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AccountServlet extends HttpServlet{
	
	private String name;
	private double amount;
	private String bankName;
	
	@Override
	public void init() throws ServletException {
		ServletContext context = getServletContext();
		bankName = context.getInitParameter("bankName");
		
		ServletConfig config = getServletConfig();
		name = config.getInitParameter("accountHolderName");
		amount = Double.parseDouble(config.getInitParameter("fixedDeposite"));
		
		User user = new User("ABC", "abc@gmail.com", "abc@123");
		context.setAttribute("user", user);
	}	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter writer = resp.getWriter();
		writer.println("Bank Name           : "+bankName);
		writer.println("Account Holder Name : "+ name);
		writer.println("Fixed Deposite      : "+amount);
	}
}
