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
import com.cloudlab.dao.StudentDAO;
import com.cloudlab.model.Combo;
import com.cloudlab.model.ScoreRecord;
import com.cloudlab.model.ScoreType;
import com.cloudlab.model.Student;
import com.cloudlab.model.User;
import com.cloudlab.util.TableLoader;
import com.mysql.jdbc.PreparedStatement;

public class StudentDAOImp extends BaseDAO implements StudentDAO {

	@Override
	public List<Student> getAllUsers() {
		Connection conn = getConn();

		List<Student> users = new ArrayList<Student>();
		String sql = "select * from tb_student as tb1, "
				+ " (select tmp.sr_student_id, sum(tmp.st_score) as stu_score from (select * from tb_score_record as sr, tb_score_type as st where sr.sr_score_type_id = st.st_id) as tmp group by tmp.sr_student_id) as tb2 "
				+ " where tb1.stu_id = tb2.sr_student_id;";
		
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = getConn();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Student user = TableLoader.loadStudent(rs);
				int score = rs.getInt("stu_score");
				user.setStu_score(score);
				users.add(user);
			}
		} catch (SQLException | UnsupportedEncodingException e) {
			e.printStackTrace();
		} finally {
			releaseSource(conn, stmt, rs);
		}
		return users;
	}

	@Override
	public List<ScoreRecord> getStudentScoreDetail(int studentId) {
		Connection conn = getConn();

		List<ScoreRecord> srs = new ArrayList<ScoreRecord>();
		String sql = "select * from tb_score_record as sr, tb_score_type as st where sr.sr_score_type_id = st.st_id and sr.sr_student_id = "
				+ studentId + " order by sr.sr_ct desc;";
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = getConn();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				ScoreRecord user = TableLoader.loadScoreRecord(rs);
				srs.add(user);
			}
		} catch (SQLException | UnsupportedEncodingException e) {
			e.printStackTrace();
		} finally {
			releaseSource(conn, stmt, rs);
		}
		return srs;
	}

	@Override
	public List<Combo> getStudentNameList() {
		Connection conn = getConn();

		List<Combo> scs = new ArrayList<Combo>();
		String sql = "select * from tb_student";
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = getConn();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Combo sc = TableLoader.loadStudentCombo(rs);
				scs.add(sc);
			}
		} catch (SQLException | UnsupportedEncodingException e) {
			e.printStackTrace();
		} finally {
			releaseSource(conn, stmt, rs);
		}
		return scs;
	}

	@Override
	public List<Combo> getScoreTypeList() {
		Connection conn = getConn();

		List<Combo> scs = new ArrayList<Combo>();
		String sql = "select * from tb_score_type as st where st.st_id > 1";
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = getConn();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Combo sc = TableLoader.loadScoreTypeCombo(rs);
				scs.add(sc);
			}
		} catch (SQLException | UnsupportedEncodingException e) {
			e.printStackTrace();
		} finally {
			releaseSource(conn, stmt, rs);
		}
		return scs;
	}

	@Override
	public int save(ScoreRecord sr) {
		Connection conn = getConn();

		List<Combo> scs = new ArrayList<Combo>();
		String sql = "insert into tb_score_record values (null, ?, ?,?,?);";

		int res = -1;
		java.sql.PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, sr.getSr_student_id());
			pstmt.setInt(2, sr.getSr_score_type_id());
			pstmt.setString(3, sr.getSr_comment());
			pstmt.setTimestamp(4, sr.getSr_ct());
			res = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			releaseSource(conn, pstmt, rs);
		}

		return res;
	}

	@Override
	public int validate(User user) {
		Connection conn = getConn();

		List<Combo> scs = new ArrayList<Combo>();
		String sql = "select * from tb_user where u_username = ? and u_password = ?";
		java.sql.PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getU_username());
			pstmt.setString(2, user.getU_password());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				int u_id = rs.getInt("u_id");
				int u_admin = rs.getInt("u_admin");
				
				user.setU_id(u_id);
				user.setU_admin(u_admin);
				return 1;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			releaseSource(conn, pstmt, rs);
		}

		return 0;
	}

}
