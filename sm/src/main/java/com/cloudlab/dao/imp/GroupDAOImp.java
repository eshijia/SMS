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
import com.cloudlab.dao.GroupDAO;
import com.cloudlab.dao.StudentDAO;
import com.cloudlab.model.Assistant;
import com.cloudlab.model.Combo;
import com.cloudlab.model.ScoreRecord;
import com.cloudlab.model.ScoreType;
import com.cloudlab.model.Student;
import com.cloudlab.model.User;
import com.cloudlab.util.TableLoader;
import com.mysql.jdbc.PreparedStatement;

public class GroupDAOImp extends BaseDAO implements GroupDAO {

	@Override
	public List<Assistant> getAllAssistants() {
		Connection conn = getConn();

		List<Assistant> ass = new ArrayList<Assistant>();
		String sql = "select * from tb_assistant;";
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = getConn();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Assistant user = TableLoader.loadAssistant(rs);
				ass.add(user);
			}
		} catch (SQLException | UnsupportedEncodingException e) {
			e.printStackTrace();
		} finally {
			releaseSource(conn, stmt, rs);
		}
		return ass;
	}

	@Override
	public List<Student> getStudentListByGroupId(String groupId) {
		Connection conn = getConn();

		List<Student> users = new ArrayList<Student>();
		String sql = "select * from tb_student as ts, tb_group as tg where ts.stu_id = tg.grp_student_id and tg.grp_id = " + groupId;
		
		System.out.println(sql);
		
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = getConn();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Student user = TableLoader.loadStudent(rs);
				int grp_leader = rs.getInt("grp_leader");
				user.setStu_grp_leader(grp_leader);
				users.add(user);
			}
		} catch (SQLException | UnsupportedEncodingException e) {
			e.printStackTrace();
		} finally {
			releaseSource(conn, stmt, rs);
		}
		return users;
	}
}
