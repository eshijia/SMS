package com.cloudlab.control.scorerecord;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cloudlab.dao.ScoreRecordDAO;
import com.cloudlab.dao.imp.ScoreRecordDAOImp;

/**
 * Servlet implementation class GetUserServlet
 */
@WebServlet("/DeleteScoreRecord.do")
public class DeleteScoreRecordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    /**
     * Default constructor. 
     */
    public DeleteScoreRecordServlet() {            
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf8");
		
//		Enumeration<String> strs = request.getParameterNames();
//		while (strs.hasMoreElements()) {
//			String ele = strs.nextElement();
//			System.out.println(ele);
//		}
		
		String sr_id = request.getParameter("sr_id");
		
		
		ScoreRecordDAO stDAO = new ScoreRecordDAOImp();
		int res = stDAO.delete(sr_id);
		
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
