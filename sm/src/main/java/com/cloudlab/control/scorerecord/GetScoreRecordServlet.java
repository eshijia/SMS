package com.cloudlab.control.scorerecord;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.map.ObjectMapper;

import com.cloudlab.dao.ScoreRecordDAO;
import com.cloudlab.dao.imp.ScoreRecordDAOImp;
import com.cloudlab.model.Datagrid;
import com.cloudlab.model.ScoreRecordTb;
import com.cloudlab.model.Student;

/**
 * Servlet implementation class GetUserServlet
 */
@WebServlet("/GetScoreRecord.do")
public class GetScoreRecordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public GetScoreRecordServlet() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		ScoreRecordDAO srDAO = new ScoreRecordDAOImp();
		List<ScoreRecordTb> srs = srDAO.getAllScoreRecord();
		
		Datagrid datagrid = new Datagrid(srs.size(), srs);

		response.setContentType("text/html;charset=UTF-8"); 
		PrintWriter pw = response.getWriter();

		JsonGenerator jsonGenerator = null;
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			jsonGenerator = objectMapper.getJsonFactory().createJsonGenerator(
					pw);
			jsonGenerator.writeObject(datagrid);
		} catch (IOException e) {
			e.printStackTrace();
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

