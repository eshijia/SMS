package com.cloudlab.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.JsonEncoding;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.map.ObjectMapper;

import com.cloudlab.dao.StudentDAO;
import com.cloudlab.dao.imp.StudentDAOImp;
import com.cloudlab.model.Datagrid;
import com.cloudlab.model.Student;

/**
 * Servlet implementation class GetUserServlet
 */
@WebServlet("/GetUserServlet")
public class GetUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public GetUserServlet() {            
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		// TODO Auto-generated method stub
		StudentDAO userDAO = new StudentDAOImp();    
		List<Student> users = userDAO.getAllUsers();
		
		Datagrid datagrid = new Datagrid(users.size(), users);
		
		StringBuffer sb = new StringBuffer();
		for(Student user : users) {
			sb.append(user.getStu_no()+"  "+"\n");
		}  
		        
		response.setCharacterEncoding("utf8");  
		PrintWriter pw = response.getWriter();      

		JsonGenerator jsonGenerator = null;
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			jsonGenerator = objectMapper.getJsonFactory().createJsonGenerator(pw);
			jsonGenerator.writeObject(datagrid);
		} catch (IOException e) {
			e.printStackTrace();
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
