package com.cloudlab.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cloudlab.dao.GroupDAO;
import com.cloudlab.dao.imp.GroupDAOImp;
import com.cloudlab.model.Student;

/**
 * Servlet implementation class GetUserServlet
 */
@WebServlet("/GetGroup.do")
public class GetGroupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public GetGroupServlet() {            
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String groupId = (String)request.getParameter("groupId");
		
		GroupDAO groupDAO = new GroupDAOImp();
		List<Student> ss = groupDAO.getStudentListByGroupId(groupId);
		
		response.setCharacterEncoding("utf8");  
		PrintWriter pw = response.getWriter();      
		
		request.setAttribute("ss", ss);
		RequestDispatcher rd = request.getRequestDispatcher("ajax/groupstudent.jsp");
	    rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
