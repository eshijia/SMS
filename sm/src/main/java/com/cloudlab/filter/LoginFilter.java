/**
 * 文件名：LoginFilter.java
 *
 * 版本信息： version 1.0
 * 日期：2013-9-22
 * Copyright by menuz
 */
package com.cloudlab.filter;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginFilter implements Filter {
	protected FilterConfig filterConfig;
	java.util.List revokeList;

	@Override
	// Called once when this filter is instantiated.
	// If mapped to j_security_check, called
	// very first time j_security_check is invoked.
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		this.filterConfig = filterConfig;

		// read revoked user list
		// revokeList = new java.util.ArrayList();
		// readConfig();

	}

	@Override
	// Called for every request that is mapped to this filter.
	// If mapped to j_security_check,
	// called for every j_security_check action
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		// // perform pre-login action here
		// // calls the next filter in chain.
		// // j_security_check if this filter is
		// // mapped to j_security_check.
		// // perform post-login action here.
		//
		// HttpServletRequest req = (HttpServletRequest) request;
		// HttpServletResponse res = (HttpServletResponse) response;
		//
		// // pre login action
		//
		// // get username
		// String username = req.getParameter("username");
		// String password = req.getParameter("password");
		//
		// // if user is in revoked list send error
		// if (revokeList.contains(username)) {
		// res.sendError(javax.servlet.http.HttpServletResponse.SC_UNAUTHORIZED);
		// return;
		// }
		//
		// // call next filter in the chain : let j_security_check authenticate
		// // user
		// chain.doFilter(request, response);
		//
		// // post login action

		System.out.println("LoginFilter");

		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		HttpSession session = request.getSession();
		ServletContext application = session.getServletContext();

		if (application.getAttribute("user") == null) {
			response.sendRedirect("login.jsp");
			return;
		} else {
			chain.doFilter(request, response);
		}
	}

	@Override
	public void destroy() {
		this.filterConfig = null;

	}

	/**
	 * readConfig() : Reads revoked user list file and creates a revoked user
	 * list.
	 */
	private void readConfig() {
		if (filterConfig != null) {
			// get the revoked user list file and open it.
			BufferedReader in;
			try {
				String filename = filterConfig.getInitParameter("RevokedUsers");
				in = new BufferedReader(new FileReader(filename));
			} catch (FileNotFoundException fnfe) {
				return;
			}

			// read all the revoked users and add to revokeList.
			String userName;
			try {
				while ((userName = in.readLine()) != null)
					revokeList.add(userName);
			} catch (IOException ioe) {
			}

		}

	}

}
