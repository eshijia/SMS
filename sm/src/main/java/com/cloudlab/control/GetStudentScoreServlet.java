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

import com.cloudlab.dao.StudentDAO;
import com.cloudlab.dao.imp.StudentDAOImp;
import com.cloudlab.filter.imp.ScoreRecordFilter;
import com.cloudlab.model.ScoreRecord;

/**
 * Servlet implementation class GetUserServlet
 */
@WebServlet("/GetStudentScore.do")
public class GetStudentScoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public GetStudentScoreServlet() {            
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String studentId = (String)request.getParameter("studentId");
		
		StudentDAO userDAO = new StudentDAOImp(); 
		int _studentId = Integer.parseInt(studentId);
		     
		List<ScoreRecord> srs = userDAO.getStudentScoreDetail(_studentId);
		
		/**
		 * filter init score record record which is related with sql
		 */
		srs= new ScoreRecordFilter(srs).filter();
		
		System.out.println(srs.size());
		
		response.setCharacterEncoding("utf8");  
		PrintWriter pw = response.getWriter();      
		
		request.setAttribute("srs", srs);
		RequestDispatcher rd = request.getRequestDispatcher("ajax/scorerecords.jsp");
	    rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
