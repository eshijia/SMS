package com.cloudlab.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.map.ObjectMapper;

import com.cloudlab.dao.ScoreDAO;
import com.cloudlab.dao.imp.ScoreDAOImp;
import com.cloudlab.model.Datagrid;
import com.cloudlab.model.ScoreRecord;

/**
 * Servlet implementation class GetUserServlet
 */
@WebServlet("/GetScore.do")
public class GetScoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public GetScoreServlet() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String sort = "";
		String order = "";
		
		Enumeration e = (Enumeration) request.getParameterNames();
		while (e.hasMoreElements()) {
			String parName = (String) e.nextElement();
			//System.out.println(parName + "  " + request.getParameter(parName));
			if(parName != null && parName.equals("sort")) {
				sort = request.getParameter(parName);
			}
			if(parName != null && parName.equals("order")) {
				order = request.getParameter(parName);
			}
		}
		
		ScoreDAO scoreDAO = new ScoreDAOImp();
		List<ScoreRecord> srs = null;
		
		// sort 不排序，从数据库中取到的就是
		if(sort.trim().equals("srt_score")) {
			srs = scoreDAO.getHighestScore();
			if(order.trim().equals("asc")) {
				Collections.sort(srs, new Comparator<ScoreRecord>() {
	
					@Override
					public int compare(ScoreRecord o1, ScoreRecord o2) {
						int value = new Integer(o1.getSrt_score()).compareTo(new Integer(o2.getSrt_score()));
						return value;
					}
					
				});
			} if(order.trim().equals("desc")) {
				Collections.sort(srs, new Comparator<ScoreRecord>() {
	
					@Override
					public int compare(ScoreRecord o1, ScoreRecord o2) {
						int value = new Integer(o2.getSrt_score()).compareTo(new Integer(o1.getSrt_score()));
						return value;
					}
					
				});
			}
			
			//request.getSession().setAttribute("srt_score", 1);
			
		} else {
			srs = scoreDAO.getScore();
			if (sort.trim().equals("sr_id")) {

				if (order.trim().equals("asc")) {
					Collections.sort(srs, new Comparator<ScoreRecord>() {

						@Override
						public int compare(ScoreRecord o1, ScoreRecord o2) {
							return new Integer(o1.getSr_id())
									.compareTo(new Integer(o2.getSr_id()));
						}

					});
				}
				else if (order.trim().equals("desc")) {
					Collections.sort(srs, new Comparator<ScoreRecord>() {
						
						@Override
						public int compare(ScoreRecord o1, ScoreRecord o2) {
							return new Integer(o2.getSr_id())
							.compareTo(new Integer(o1.getSr_id()));
						}
						
					});
				}

			} else if (sort.trim().equals("sr_ct_str")) {

				if (order.trim().equals("asc")) {
					Collections.sort(srs, new Comparator<ScoreRecord>() {

						@Override
						public int compare(ScoreRecord o1, ScoreRecord o2) {
							return o1.getSr_ct_str().compareTo(
									o2.getSr_ct_str());
						}

					});
				} else if (order.trim().equals("desc")) {
					Collections.sort(srs, new Comparator<ScoreRecord>() {

						@Override
						public int compare(ScoreRecord o1, ScoreRecord o2) {
							return o2.getSr_ct_str().compareTo(
									o1.getSr_ct_str());
						}

					});
				}
			}
			
			
			//request.getSession().setAttribute("srt_score", 0);
		}
		
		Datagrid<ScoreRecord> datagrid = new Datagrid(srs.size(), srs);
  		
//		ScoreRecordDatagrid datagrid = new ScoreRecordDatagrid(srs.size(), srs);

		response.setCharacterEncoding("utf8");
		PrintWriter pw = response.getWriter();

		JsonGenerator jsonGenerator = null;
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			jsonGenerator = objectMapper.getJsonFactory().createJsonGenerator(
					pw);
			jsonGenerator.writeObject(datagrid);
		} catch (IOException ee) {
			ee.printStackTrace();
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
