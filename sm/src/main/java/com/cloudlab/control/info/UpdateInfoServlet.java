package com.cloudlab.control.info;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cloudlab.dao.InfoDAO;
import com.cloudlab.dao.StudentDAO;
import com.cloudlab.dao.imp.InfoDAOImp;
import com.cloudlab.dao.imp.StudentDAOImp;
import com.cloudlab.model.Info;

/**
 * Servlet implementation class GetUserServlet
 */
@WebServlet("/UpdateInfo.do")
public class UpdateInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    /**
     * Default constructor. 
     */
    public UpdateInfoServlet() {            
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf8");
		
		String if_id = request.getParameter("if_id");
		String createTime = request.getParameter("if_ct");
		String info = request.getParameter("if_info");
		
		InfoDAO infoDAO = new InfoDAOImp();
		int res = infoDAO.update(Integer.parseInt(if_id), info, createTime);
		
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
