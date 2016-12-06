package data;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import model.User;

public interface UserDAO {
	
	public abstract User createValueObject();
	
	public abstract ArrayList<User> searchMatching(Connection conn,
			User valueObject) throws SQLException;
}
