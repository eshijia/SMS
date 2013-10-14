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
import com.cloudlab.dao.ScoreTypeDAO;
import com.cloudlab.model.ScoreType;
import com.cloudlab.model.Student;
import com.cloudlab.util.TableLoader;

public class ScoreTypeDAOImp extends BaseDAO implements ScoreTypeDAO {

	@Override
	public int save(ScoreType st) {
		Connection conn = getConn();
		String sql = "insert into tb_score_type values (null, ?, ?);";

		int res = -1;
		java.sql.PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, st.getSt_name());
			pstmt.setInt(2, st.getSt_score());
			res = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			releaseSource(conn, pstmt, rs);
		}

		return res;
	}

	@Override
	public List<ScoreType> getAllScoreType() {
		Connection conn = getConn();

		List<ScoreType> sts = new ArrayList<ScoreType>();
		String sql = "select * from tb_score_type";
		
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = getConn();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				ScoreType st = TableLoader.loadScoreType(rs);
				sts.add(st);
			}
		} catch (SQLException | UnsupportedEncodingException e) {
			e.printStackTrace();
		} finally {
			releaseSource(conn, stmt, rs);
		}
		return sts;
	}

	@Override
	public int delete(int st_id) {
		Connection conn = getConn();
		String sql = "delete from tb_score_type where st_id = " + st_id;

		int res = -1;
		java.sql.Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = getConn();
			stmt = conn.createStatement();
			res = stmt.executeUpdate(sql);
			
			System.out.println("res = " + res);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			releaseSource(conn, stmt, rs);
		}
		return res;
	}

	@Override
	public int delete(String st_id) {
		int stid = Integer.parseInt(st_id);
		return delete(stid);
	}

	@Override
	public int update(String st_id, String st_name, String st_score) {
		Connection conn = getConn();
		String sql = "update tb_score_type set st_name = '"+st_name+"' , st_score = "+st_score+" where st_id = " + st_id;
		
		System.out.println(sql);

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
