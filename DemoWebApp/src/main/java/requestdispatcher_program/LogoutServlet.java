package requestdispatcher_program;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String username = (String)session.getAttribute("username");
		PrintWriter pw = resp.getWriter();
		resp.setContentType("text/html");
		if(username!=null && "admin".equals(username)) {
			session.invalidate();
			pw.println("<h2>Logout Successful.. </h2>");
		}else {
			pw.println("<h2>Login first... </h2>");
			RequestDispatcher rd1 = req.getRequestDispatcher("login.html");
			rd1.include(req, resp);
		}
	}
}
