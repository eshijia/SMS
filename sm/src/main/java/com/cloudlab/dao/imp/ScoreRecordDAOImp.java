/**
 * 文件名：UserDAOImp.java
 *
 * 版本信息： version 1.0
 * 日期：2013-9-15
 * Copyright by menuz
 */
package com.cloudlab.dao.imp;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.cloudlab.dao.BaseDAO;
import com.cloudlab.dao.ScoreRecordDAO;
import com.cloudlab.model.Info;
import com.cloudlab.model.ScoreRecord;
import com.cloudlab.model.ScoreRecordTb;
import com.cloudlab.util.TableLoader;

public class ScoreRecordDAOImp extends BaseDAO implements ScoreRecordDAO {

//	@Override
//	public int save(Info info) {
//		Connection conn = getConn();
//		String sql = "insert into tb_info values (null, ?, null);";
//
//		int res = -1;
//		java.sql.PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		try {
//			conn = getConn();
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, info.getIf_info());
//			res = pstmt.executeUpdate();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			releaseSource(conn, pstmt, rs);
//		}
//
//		return res;
//	}
//
//	@Override
//	public List<Info> getAllInfos() {
//			List<Info> infos = new ArrayList<Info>();
//			String sql = "select * from tb_info order by if_id desc;";
//			Connection conn = null;
//			Statement stmt = null;
//			ResultSet rs = null;
//			try {
//				conn = getConn();
//				stmt = conn.createStatement();
//				rs = stmt.executeQuery(sql);
//				while (rs.next()) {
//					Info info = TableLoader.loadInfo(rs);
//					infos.add(info);
//				}
//			} catch (SQLException | UnsupportedEncodingException e) {
//				e.printStackTrace();
//			} finally {
//				releaseSource(conn, stmt, rs);
//			}
//			return infos;
//	}
//
//	@Override
//	public int update(int if_id, String if_info, String if_ct) {
//		Connection conn = getConn();
//		String sql = "update tb_info set if_info = '"+if_info+"' where if_id = " + if_id;
//		
//		int res = -1;
//		java.sql.Statement stmt = null;
//		ResultSet rs = null;
//		try {
//			conn = getConn();
//			stmt = conn.createStatement();
//			res = stmt.executeUpdate(sql);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			releaseSource(conn, stmt, rs);
//		}
//		return res;
//	}

	@Override
	public int delete(String sr_id) {
		Connection conn = getConn();
		String sql = "delete from tb_score_record where sr_id = " + sr_id;

		int res = -1;
		java.sql.Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = getConn();
			stmt = conn.createStatement();
			res = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			releaseSource(conn, stmt, rs);
		}
		return 0;
	}

	@Override
	public List<ScoreRecordTb> getAllScoreRecord() {
		List<ScoreRecordTb> srs = new ArrayList<ScoreRecordTb>();
		String sql = "select * from tb_score_record order by sr_id desc;";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = getConn();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				ScoreRecordTb sr = TableLoader.loadScoreRecordTable(rs);
				srs.add(sr);
			}
		} catch (SQLException | UnsupportedEncodingException e) {
			e.printStackTrace();
		} finally {
			releaseSource(conn, stmt, rs);
		}
		return srs;
	}

	@Override
	public int save(ScoreRecordTb sr) {
		
		return 0;
	}

	@Override
	public int update(String sr_id, String sr_student_id, String sr_student_name,
			String sr_score_type_id, String sr_score_type_name,
			String sr_score_type_score, String sr_ct, String sr_comment) {
		Connection conn = getConn();
		String sql = "update tb_score_record set sr_student_id = "+sr_student_id+"," +
											"    sr_student_name = '"+sr_student_name+"',"+
											"    sr_score_type_id = "+sr_score_type_id+","+
											"    sr_score_type_name = '"+sr_score_type_name+"',"+
											"    sr_score_type_score = "+sr_score_type_score+"," +
											"	 sr_comment = '"+sr_comment+"' where sr_id = " + sr_id;
		
		System.out.println("update sr = " + sql);
		
		int res = -1;
		java.sql.Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = getConn();
			stmt = conn.createStatement();
			res = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			releaseSource(conn, stmt, rs);
		}
		return res;
	}

}
