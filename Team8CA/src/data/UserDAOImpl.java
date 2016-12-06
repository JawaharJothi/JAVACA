package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.User;

public class UserDAOImpl implements UserDAO{
	
	@Override
	public User createValueObject() {
		// TODO Auto-generated method stub
		return new User();
	}

	@Override
	public ArrayList<User> searchMatching(Connection conn, User valueObject) throws SQLException {
		// TODO Auto-generated method stub
		ArrayList<User> searchResults;

		boolean first = true;
		StringBuffer sql = new StringBuffer("SELECT * FROM user WHERE ");

		if (valueObject.getUserID() != null) {
			if (first) {
				first = false;
			}
			sql.append(" UserID LIKE '").append(valueObject.getUserID())
					.append("%' ");
		}


		if (valueObject.getPassword() != null) {
			if (first) {
				first = false;
			}
			sql.append("AND password LIKE '").append(valueObject.getPassword())
					.append("%' ");
		}

		if (valueObject.getRole() != null) {
			if (first) {
				first = false;
			}
			sql.append("AND role LIKE '").append(valueObject.getRole())
					.append("%' ");
		}

		

		sql.append("ORDER BY userid ASC ");

		// Prevent accidential full table results.
		// Use loadAll if all rows must be returned.
		if (first)
			searchResults = new ArrayList<User>();
		else
			searchResults = listQuery(conn,
					conn.prepareStatement(sql.toString()));

		return searchResults;
	}
	
	protected ArrayList<User> listQuery(Connection conn, PreparedStatement stmt)
			throws SQLException {

		ArrayList<User> searchResults = new ArrayList<User>();
		ResultSet result = null;

		try {
			result = stmt.executeQuery();

			while (result.next()) {
				User temp = createValueObject();

				temp.setUserID(result.getString("UserID"));
				temp.setPassword(result.getString("Password"));
				temp.setRole(result.getString("Role"));


				searchResults.add(temp);
			}

		} finally {
			if (result != null)
				result.close();
			if (stmt != null)
				stmt.close();
		}

		return  searchResults;
	}



}
