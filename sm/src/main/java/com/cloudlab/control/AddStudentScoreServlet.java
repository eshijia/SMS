package com.cloudlab.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cloudlab.dao.StudentDAO;
import com.cloudlab.dao.imp.StudentDAOImp;
import com.cloudlab.model.ScoreRecord;
import com.cloudlab.model.Student;

/**
 * Servlet implementation class GetUserServlet
 */
@WebServlet("/AddStudentScore.do")
public class AddStudentScoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    /**
     * Default constructor. 
     */
    public AddStudentScoreServlet() {            
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf8");
		
		String studentId = request.getParameter("studentId");
		String scoreTypeId = request.getParameter("scoreTypeId");
		String createTime = request.getParameter("createTime");
		String comment = request.getParameter("comment");
		
		ScoreRecord sr = new ScoreRecord(studentId, scoreTypeId, createTime, comment);
		StudentDAO userDAO = new StudentDAOImp();    
		int res = userDAO.save(sr);
		
		response.setCharacterEncoding("utf8");  
		PrintWriter pw = response.getWriter();
		
		if(res > 0) {
			pw.write("保存加分记录成功");
		} else {
			pw.write("保存加分记录失败");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
