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

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.map.ObjectMapper;

import com.cloudlab.dao.StudentDAO;
import com.cloudlab.dao.imp.StudentDAOImp;
import com.cloudlab.model.ScoreRecord;

/**
 * Servlet implementation class GetUserServlet
 */
@WebServlet("/GetStudentScoreServlet")
public class GetStudentScoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public GetStudentScoreServlet() {            
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String studentId = (String)request.getParameter("studentId");
		
		StudentDAO userDAO = new StudentDAOImp(); 
		int _studentId = Integer.parseInt(studentId);
		     
		List<ScoreRecord> srs = userDAO.getStudentScoreDetail(_studentId);
		
		response.setCharacterEncoding("utf8");  
		PrintWriter pw = response.getWriter();      
		
		request.setAttribute("srs", srs);
		RequestDispatcher rd = request.getRequestDispatcher("scorerecords.jsp");
	    rd.forward(request, response);
	    
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
