package com.cloudlab.control.scoretype;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cloudlab.dao.ScoreTypeDAO;
import com.cloudlab.dao.imp.ScoreTypeDAOImp;
import com.cloudlab.model.ScoreType;

/**
 * Servlet implementation class GetUserServlet
 */
@WebServlet("/AddScoreType.do")
public class AddScoreTypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    /**
     * Default constructor. 
     */
    public AddScoreTypeServlet() {            
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf8");
		
		String st_name = request.getParameter("st_name");
		String st_score = request.getParameter("st_score");
		
		System.out.println("st_name = " + st_name);
		System.out.println("st_score = " + st_score);
		
		
		ScoreType st = new ScoreType(st_name, st_score);
		
		ScoreTypeDAO stDAO = new ScoreTypeDAOImp();
		
		int res = stDAO.save(st);
		
		response.setCharacterEncoding("utf8");  
		PrintWriter pw = response.getWriter();
		
		if(res > 0) {
			pw.write("1");
		} else {
			pw.write("0");
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
