


package com.cloudlab.control.scoretype;

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

import com.cloudlab.dao.ScoreTypeDAO;
import com.cloudlab.dao.imp.ScoreTypeDAOImp;
import com.cloudlab.model.Datagrid;
import com.cloudlab.model.ScoreType;
import com.cloudlab.model.Student;

/**
 * Servlet implementation class GetUserServlet
 */
@WebServlet("/GetScoreType.do")
public class GetScoreTypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public GetScoreTypeServlet() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		ScoreTypeDAO stDAO = new ScoreTypeDAOImp();
		List<ScoreType> sts = stDAO.getAllScoreType();

		Datagrid datagrid = new Datagrid(sts.size(), sts);
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

