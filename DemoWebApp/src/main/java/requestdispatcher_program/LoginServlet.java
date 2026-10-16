package requestdispatcher_program;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();
		if ("admin".equals(username) && "admin123".equals(password)) {
			pw.println("<h2>Logged in Successfully! </h2>");
			pw.println("<form action='home' method='GET'>");
			pw.println("<input type = 'hidden' name = 'username' value = '"+username+"'>");
			pw.println("<button type = 'submit'>Go to Home</button>");
			pw.println("</form>");
		} else {
			pw.println("<h2>Invalid credentials..</h2>");
		}
	}
	
//	@Override
//	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		String username = req.getParameter("username");
//		String password = req.getParameter("password");
//		resp.setContentType("text/html");
//		PrintWriter pw = resp.getWriter();
//		if ("admin".equals(username) && "admin123".equals(password)) {
//			pw.println("<h2>Logged in Successfully! </h2>");
//			String url = "home?username="+username;
//			pw.println("<a href = '"+url+"'>Go to Home Page</a>");
//		} else {
//			pw.println("<h2>Invalid credentials..</h2>");
//		}
//	}

//	@Override
//	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		String username = req.getParameter("username");
//		String password = req.getParameter("password");
//		resp.setContentType("text/html");
//		PrintWriter pw = resp.getWriter();
//		if (username.equals("admin") && password.equals("admin123")) {
//			Cookie c1 = new Cookie("username", "vimal");
//			resp.addCookie(c1);
//			pw.println("<h2>Logged in Successfully! </h2>");	
//		} else {
//			pw.println("<h2>Invalid credentials..</h2>");
//		}
//	}
}
