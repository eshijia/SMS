package com.cloudlab.control;

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

import com.cloudlab.dao.GroupDAO;
import com.cloudlab.dao.imp.GroupDAOImp;
import com.cloudlab.model.Assistant;
import com.cloudlab.model.Datagrid;

/**
 * Servlet implementation class GetUserServlet
 */
@WebServlet("/GetAssistant.do")
public class GetAssistantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public GetAssistantServlet() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		GroupDAO groupDAO = new GroupDAOImp();
		List<Assistant> ass = groupDAO.getAllAssistants();
		
		Datagrid<Assistant> datagrid = new Datagrid(ass.size(), ass);
		
//		AssistantDatagrid datagrid = new AssistantDatagrid(ass.size(), ass);

		response.setCharacterEncoding("utf8");
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
