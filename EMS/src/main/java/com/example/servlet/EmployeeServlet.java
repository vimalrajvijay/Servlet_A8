package com.example.servlet;

import java.io.IOException;

import com.example.dao.EmployeeDao;
import com.example.entity.Employee;
import com.example.util.HibernateUtil;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/employee", initParams = @WebInitParam(name = "dept", value = "Testing"))
public class EmployeeServlet extends HttpServlet{

	private EmployeeDao dao = new EmployeeDao();
	
	@Override
	public void init() throws ServletException {
		HibernateUtil.init();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		if(action!=null && "create".equals(action))
			req.getRequestDispatcher("employeeForm.jsp").forward(req, resp);
		else
			resp.getWriter().println("Print All Emp");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String department = req.getParameter("dept");
		if(department==null)
			department = getServletConfig().getInitParameter("dept");
		Employee employee = new Employee(name, email, department);
		dao.saveEmployee(employee);
		resp.getWriter().println("Saved Successfully");
	}
}
