package com.example.server.test;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/TestDBServlet")
public class TestDBServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3063543017628394690L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		// Setup connection variables
		String user = "postgres";
		String pwd = "000000";

		// get connection to database
		String url = "jdbc:postgresql://localhost:5432/testDB";
		String driver = "org.postgresql.Driver";
		try {
			Class.forName(driver);
			Connection myConn = DriverManager.getConnection(url, user, pwd);
			PrintWriter out = response.getWriter();
			out.println("Connection to " + url);
			out.println("Connection successful!!!");
			myConn.close();
		}catch(Exception ex) {
			ex.printStackTrace();
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException {

	}
}
