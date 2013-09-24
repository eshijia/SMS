package com.cloudlab.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cloudlab.dao.StudentDAO;
import com.cloudlab.dao.imp.StudentDAOImp;
import com.cloudlab.model.User;

/**
 * Servlet implementation class GetUserServlet
 */
@WebServlet("/ValidateUser")
public class ValidateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public ValidateUserServlet() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		// System.out.println(username + "   " + password);
		
		User user = new User(username.trim(), password.trim());
		
		StudentDAO userDAO = new StudentDAOImp();
		// fill user u_id, u_admin
		int res = userDAO.validate(user);

		response.setCharacterEncoding("utf8");
		if(res == 1) {
			request.getServletContext().setAttribute("user", user);
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");   
		    rd.forward(request, response);
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");   
		    rd.forward(request, response);
		}
	} 

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
