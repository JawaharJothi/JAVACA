package data;

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.User;

public class UserDAOImpl implements UserDAO{
	private static final String dbUrl = "jdbc:mysql://localhost:3306/team8";
	private static final String dbUserName = "root";
	private static final String dbPassword = "password";
	
	@Override
	public User createValueObject() {
		// TODO Auto-generated method stub
		return new User();
	}

	@Override
	public User searchMatching(User valueObject) throws DAOException {
		// TODO Auto-generated method stub
		User result = new User();
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		String sql = "SELECT * FROM user WHERE UserID='"+ valueObject.getUserID() +"' AND Password='"+ valueObject.getPassword() +"'";
		Connection con = null;
		try{
		con = DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		while (rs.next()) {

			result.setUserID(rs.getString("UserID"));
			result.setPassword(rs.getString("Password"));
			result.setRole(rs.getString("Role"));

			
		}
		st.close();
	}

	catch (SQLException e) {
		String error = "User Can't find. Nested Exception is: " + e;
		throw new DAOException(error);
	} finally {
		try {
			con.close();
		} catch (Exception e) {
		}
	}
	return result;
	}
	



}
