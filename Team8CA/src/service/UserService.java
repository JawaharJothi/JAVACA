package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import data.DAOException;
import data.DaoFactory;
import data.UserDAO;
import exception.NotFoundException;
import model.User;

public class UserService {
	private Connection conn;
	private UserDAO udao;

	public UserService() {
		// TODO Auto-generated constructor stub
		super();
		this.udao = DaoFactory.getUserDao();
	}

	@SuppressWarnings("finally")
	public User authenticate(User u) {
		User list = new User();
		try {
			list = this.udao.searchMatching(u);

		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			return list;
		}

	}
	
	@SuppressWarnings("finally")
	public boolean check(User u){
		boolean b = false;
		
		try {
			b =this.udao.checkUser(u);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			return b;
		}
	}

}
