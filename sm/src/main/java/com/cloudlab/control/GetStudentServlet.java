package com.cloudlab.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.map.ObjectMapper;

import com.cloudlab.comparator.ComparatorStudentDesc;
import com.cloudlab.comparator.ComparatorStudentAsc;
import com.cloudlab.dao.StudentDAO;
import com.cloudlab.dao.imp.StudentDAOImp;
import com.cloudlab.model.Student;
import com.cloudlab.model.StudentDatagrid;

/**
 * Servlet implementation class GetUserServlet
 */
@WebServlet("/GetStudent.do")
public class GetStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public GetStudentServlet() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		System.out.println("query string = " + request.getQueryString());
		
		String sort = request.getParameter("sort");
		String order = request.getParameter("order");
		System.out.println("sort = " + sort);
		System.out.println("order = " + order);
		
		StudentDAO userDAO = new StudentDAOImp();
		List<Student> users = userDAO.getAllUsers();
		
		if("desc".equals(order.toLowerCase().trim())) {
			// System.out.println("---------- desc");
			ComparatorStudentDesc comparator=new ComparatorStudentDesc();
			Collections.sort(users, comparator);
		} else if("asc".equals(order.toLowerCase().trim())) {
			// System.out.println("---------- asc");
			ComparatorStudentAsc comparator=new ComparatorStudentAsc();
			Collections.sort(users, comparator);
		}
		
//		for(Student student : users) {
//			System.out.println(student.getStu_score());  
//		}

		StudentDatagrid datagrid = new StudentDatagrid(users.size(), users);

		StringBuffer sb = new StringBuffer();
		for (Student user : users) {
			sb.append(user.getStu_no() + "  " + "\n");
		}

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
