package requestdispatcher_program;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		if (username.equals("admin") && password.equals("admin123")) {
			RequestDispatcher rd = req.getRequestDispatcher("welcome.html");
			rd.forward(req, resp);
		} else {
			//resp.getWriter().println("Invalid Credentials");
			RequestDispatcher rd1 = req.getRequestDispatcher("login.html");
			rd1.include(req, resp);
			RequestDispatcher rd2 = req.getRequestDispatcher("error.html");
			rd2.include(req, resp);
		}
	}
}
