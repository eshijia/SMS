package com.cloudlab.control.scorerecord;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cloudlab.dao.StudentDAO;
import com.cloudlab.dao.imp.StudentDAOImp;
import com.cloudlab.model.ScoreRecord;
import com.cloudlab.util.Cache;

/**
 * Servlet implementation class GetUserServlet
 */
@WebServlet("/AddStudentScore.do")
public class AddScoreRecordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public AddScoreRecordServlet() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf8");

		Cache cache = (Cache) request.getServletContext().getAttribute("cache");
		if (cache == null) {
			cache = new Cache();
			request.getServletContext().setAttribute("cache", cache);
		}

		Enumeration e = (Enumeration) request.getParameterNames();
		while (e.hasMoreElements()) {
			String parName = (String) e.nextElement();
			System.out.print(parName+"   ");
			System.out.println(request.getParameter(parName));
		}

		String sr_student_id = request.getParameter("sr_student_id");
		String studentName = cache.getStuNameById(Integer.parseInt(sr_student_id));

		String sr_score_type_id = request.getParameter("sr_score_type_id");
		String scoretypeName = cache.getScoreTypeNameById(Integer
				.parseInt(sr_score_type_id));

		String sr_score_type_score = request.getParameter("sr_score_type_score");
		String sr_ct = request.getParameter("sr_ct");
		String sr_comment = request.getParameter("sr_comment");

		ScoreRecord sr = new ScoreRecord(sr_student_id, studentName, sr_score_type_id,
				scoretypeName, sr_score_type_score, sr_ct, sr_comment);
		StudentDAO userDAO = new StudentDAOImp();
		int res = userDAO.save(sr);

		response.setCharacterEncoding("utf8");
		PrintWriter pw = response.getWriter();

		if (res > 0) {
			pw.write("1");
		} else {
			pw.write("0");
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
