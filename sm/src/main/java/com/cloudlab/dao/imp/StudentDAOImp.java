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
import com.cloudlab.model.ScoreRecord;
import com.cloudlab.model.Student;
import com.cloudlab.model.StudentCombo;
import com.cloudlab.util.TableLoader;

public class StudentDAOImp extends BaseDAO implements StudentDAO {

	@Override
	public List<Student> getAllUsers() {
		Connection conn = getConn();

		List<Student> users = new ArrayList<Student>();
		String sql = "select * from tb_student";
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = getConn();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Student user = TableLoader.loadUser(rs);
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
	public List<StudentCombo> getStudentNameList() {
		Connection conn = getConn();

		List<StudentCombo> scs = new ArrayList<StudentCombo>();
		String sql = "select * from tb_student";
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = getConn();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			int i=1;
			while (rs.next()) {
				StudentCombo sc = TableLoader.loadStudentCombo(rs, i);
				scs.add(sc);
				i++;  
			}
		} catch (SQLException | UnsupportedEncodingException e) {
			e.printStackTrace();
		} finally {
			releaseSource(conn, stmt, rs);
		}
		return scs;
	}

}
