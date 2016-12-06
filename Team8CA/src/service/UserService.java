package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import data.DaoFactory;
import data.UserDAO;
import exception.NotFoundException;
import model.User;

public class UserService {
	private Connection conn;
	private UserDAO udao;

	public UserService() throws NotFoundException {
		// TODO Auto-generated constructor stub
		super();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			this.conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/team8", "root", "password");
			this.udao = DaoFactory.getUserDao();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new NotFoundException("Driver Fault");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new NotFoundException("SQL Fault");
		}
	}
	
	public boolean authenticate(User u) throws NotFoundException {
		try {
			ArrayList<User> list = this.udao.searchMatching(this.conn, u);
			if (list.size() > 0)
				return true;
			else
				return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;

	}

}
