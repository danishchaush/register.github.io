package com.org.jsp;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/rigister")
public class rigister extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String username = req.getParameter("un");
		String password = req.getParameter("ps");
		String mailid = req.getParameter("mail");
		String address = req.getParameter("ad");
		
		String url = "jdbc:mysql://localhost:3306?user=root&password=12345";
		String query = "insert into test.register values(?,?,?,?)";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection(url);
			
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, username);
			preparedStatement.setString(2,password);
			preparedStatement.setString(3, mailid);
			preparedStatement.setString(4, address);
			
			preparedStatement.executeUpdate();
			System.out.println("registerd");
			connection.close();
			
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
