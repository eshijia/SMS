package com.cloudlab.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.map.ObjectMapper;

import com.cloudlab.dao.StudentDAO;
import com.cloudlab.dao.imp.StudentDAOImp;
import com.cloudlab.model.Datagrid;
import com.cloudlab.model.Student;

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
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String sort = request.getParameter("sort");
		String order = request.getParameter("order");
		
		StudentDAO userDAO = new StudentDAOImp();
		List<Student> users = userDAO.getAllUsers();
		
		if(sort.equals("stu_id")) {
			if(order.trim().equals("asc")) {
				Collections.sort(users, new Comparator<Student>() {
	
					@Override
					public int compare(Student o1, Student o2) {
						int value = new Integer(o1.getStu_id()).compareTo(new Integer(o2.getStu_id()));
						return value;
					}
					
				});
			} if(order.trim().equals("desc")) {
				Collections.sort(users, new Comparator<Student>() {
	
					@Override
					public int compare(Student o1, Student o2) {
						int value = new Integer(o2.getStu_id()).compareTo(new Integer(o1.getStu_id()));
						return value;
					}
					
				});
			}
		} else if(sort.equals("stu_score")){
			if(order.trim().equals("asc")) {
				Collections.sort(users, new Comparator<Student>() {
	
					@Override
					public int compare(Student o1, Student o2) {
						int value = new Integer(o1.getStu_score()).compareTo(new Integer(o2.getStu_score()));
						return value;
					}
					
				});
			} if(order.trim().equals("desc")) {
				Collections.sort(users, new Comparator<Student>() {
	
					@Override
					public int compare(Student o1, Student o2) {
						int value = new Integer(o2.getStu_score()).compareTo(new Integer(o1.getStu_score()));
						return value;
					}
					
				});
			}
		}

		Datagrid datagrid = new Datagrid(users.size(), users);

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
