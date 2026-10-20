package requestdispatcher_program;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/home")
public class HomeServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String username = (String)session.getAttribute("username");
		PrintWriter pw = resp.getWriter();
		resp.setContentType("text/html");
		if(username!=null && "admin".equals(username)) {
			pw.println("<h2>Wecome to Home Page.. </h2>");
		}else {
			pw.println("<h2>Login first... </h2>");
			RequestDispatcher rd1 = req.getRequestDispatcher("login.html");
			rd1.include(req, resp);
		}
	}
	
//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		String username = req.getParameter("username");
//		resp.setContentType("text/html");
//		PrintWriter pw = resp.getWriter();
//		if(username!=null && "admin".equals(username)) {
//			pw.println("<h2>Wecome to Home Page.. </h2>");
//		}else {
//			pw.println("<h2>Login first</h2>");
//		}
//	}

//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		Cookie[] cookies = req.getCookies();
//		PrintWriter pw = resp.getWriter();
//		boolean flag = true;
//		resp.setContentType("text/html");
//		for(Cookie cookie : cookies) {
//			if("username".equals(cookie.getName())) {
//				if("admin".equals(cookie.getValue())) {
//					pw.println("<h2>Wecome to Home Page.. </h2>");
//					flag = false;
//				}
//			}
//		}
//		if(flag)
//			pw.println("<h2>Login first</h2>");	
//	}
}
