package demo;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DemoServlet extends HttpServlet{

	@Override
	public void init() throws ServletException {
		System.out.println("Start-Up");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("First Servlet Program");
		System.out.println(req.getRequestURL());
		System.out.println(req.getMethod());
	}
	
	@Override
	public void destroy() {
		System.out.println("Clean-Up");
	}

}
