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
import com.cloudlab.dao.InfoDAO;
import com.cloudlab.model.Combo;
import com.cloudlab.model.Info;
import com.cloudlab.model.ScoreRecord;
import com.cloudlab.model.Student;
import com.cloudlab.util.TableLoader;

public class InfoDAOImp extends BaseDAO implements InfoDAO {

	@Override
	public int save(Info info) {
		Connection conn = getConn();
		String sql = "insert into tb_info values (null, ?, null);";

		int res = -1;
		java.sql.PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, info.getIf_info());
			res = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			releaseSource(conn, pstmt, rs);
		}

		return res;
	}
	
//	Connection conn = getConn();
//
//	List<Student> users = new ArrayList<Student>();
//	String sql = "select * from tb_student as tb1, "
//			+ " (select tmp.sr_student_id, sum(tmp.st_score) as stu_score from (select * from tb_score_record as sr, tb_score_type as st where sr.sr_score_type_id = st.st_id) as tmp group by tmp.sr_student_id) as tb2 "
//			+ " where tb1.stu_id = tb2.sr_student_id;";
//	Statement stmt = null;
//	ResultSet rs = null;
//	try {
//		conn = getConn();
//		stmt = conn.createStatement();
//		rs = stmt.executeQuery(sql);
//		while (rs.next()) {
//			Student user = TableLoader.loadStudent(rs);
//			users.add(user);
//		}
//	} catch (SQLException | UnsupportedEncodingException e) {
//		e.printStackTrace();
//	} finally {
//		releaseSource(conn, stmt, rs);
//	}
//	return users;

	@Override
	public List<Info> getAllInfos() {
			List<Info> infos = new ArrayList<Info>();
			String sql = "select * from tb_info order by if_id desc;";
			Connection conn = null;
			Statement stmt = null;
			ResultSet rs = null;
			try {
				conn = getConn();
				stmt = conn.createStatement();
				rs = stmt.executeQuery(sql);
				while (rs.next()) {
					Info info = TableLoader.loadInfo(rs);
					infos.add(info);
				}
			} catch (SQLException | UnsupportedEncodingException e) {
				e.printStackTrace();
			} finally {
				releaseSource(conn, stmt, rs);
			}
			return infos;
	}

	@Override
	public int update(int if_id, String if_info, String if_ct) {
		Connection conn = getConn();
		String sql = "update tb_info set if_info = '"+if_info+"' where if_id = " + if_id;
		
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

	@Override
	public int delete(int if_id) {
		Connection conn = getConn();
		String sql = "delete from tb_info where if_id = " + if_id;

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

//	@Override
//	public List<Student> getAllUsers() {
//		Connection conn = getConn();
//
//		List<Student> users = new ArrayList<Student>();
//		String sql = "select * from tb_student as tb1, "
//				+ " (select tmp.sr_student_id, sum(tmp.st_score) as stu_score from (select * from tb_score_record as sr, tb_score_type as st where sr.sr_score_type_id = st.st_id) as tmp group by tmp.sr_student_id) as tb2 "
//				+ " where tb1.stu_id = tb2.sr_student_id;";
//		Statement stmt = null;
//		ResultSet rs = null;
//		try {
//			conn = getConn();
//			stmt = conn.createStatement();
//			rs = stmt.executeQuery(sql);
//			while (rs.next()) {
//				Student user = TableLoader.loadStudent(rs);
//				users.add(user);
//			}
//		} catch (SQLException | UnsupportedEncodingException e) {
//			e.printStackTrace();
//		} finally {
//			releaseSource(conn, stmt, rs);
//		}
//		return users;
//	}
//
//	@Override
//	public List<ScoreRecord> getStudentScoreDetail(int studentId) {
//		Connection conn = getConn();
//
//		List<ScoreRecord> srs = new ArrayList<ScoreRecord>();
//		String sql = "select * from tb_score_record as sr, tb_score_type as st where sr.sr_score_type_id = st.st_id and sr.sr_student_id = "
//				+ studentId + " order by sr.sr_ct desc;";
//		Statement stmt = null;
//		ResultSet rs = null;
//		try {
//			conn = getConn();
//			stmt = conn.createStatement();
//			rs = stmt.executeQuery(sql);
//			while (rs.next()) {
//				ScoreRecord user = TableLoader.loadScoreRecord(rs);
//				srs.add(user);
//			}
//		} catch (SQLException | UnsupportedEncodingException e) {
//			e.printStackTrace();
//		} finally {
//			releaseSource(conn, stmt, rs);
//		}
//		return srs;
//	}
//
//	@Override
//	public List<Combo> getStudentNameList() {
//		Connection conn = getConn();
//
//		List<Combo> scs = new ArrayList<Combo>();
//		String sql = "select * from tb_student";
//		Statement stmt = null;
//		ResultSet rs = null;
//		try {
//			conn = getConn();
//			stmt = conn.createStatement();
//			rs = stmt.executeQuery(sql);
//			while (rs.next()) {
//				Combo sc = TableLoader.loadStudentCombo(rs);
//				scs.add(sc);
//			}
//		} catch (SQLException | UnsupportedEncodingException e) {
//			e.printStackTrace();
//		} finally {
//			releaseSource(conn, stmt, rs);
//		}
//		return scs;
//	}
//
//	@Override
//	public List<Combo> getScoreTypeList() {
//		Connection conn = getConn();
//
//		List<Combo> scs = new ArrayList<Combo>();
//		String sql = "select * from tb_score_type as st where st.st_id > 1";
//		Statement stmt = null;
//		ResultSet rs = null;
//		try {
//			conn = getConn();
//			stmt = conn.createStatement();
//			rs = stmt.executeQuery(sql);
//			while (rs.next()) {
//				Combo sc = TableLoader.loadScoreTypeCombo(rs);
//				scs.add(sc);
//			}
//		} catch (SQLException | UnsupportedEncodingException e) {
//			e.printStackTrace();
//		} finally {
//			releaseSource(conn, stmt, rs);
//		}
//		return scs;
//	}
//
//	@Override
//	public int save(ScoreRecord sr) {
//		Connection conn = getConn();
//
//		List<Combo> scs = new ArrayList<Combo>();
//		String sql = "insert into tb_score_record values (null, ?, ?,?,?);";
//
//		int res = -1;
//		java.sql.PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		try {
//			conn = getConn();
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setInt(1, sr.getSr_student_id());
//			pstmt.setInt(2, sr.getSr_score_type_id());
//			pstmt.setString(3, sr.getSr_comment());
//			pstmt.setTimestamp(4, sr.getSr_ct());
//			res = pstmt.executeUpdate();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			releaseSource(conn, pstmt, rs);
//		}
//
//		return res;
//	}

}
