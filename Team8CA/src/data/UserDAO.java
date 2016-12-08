package data;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import model.User;

public interface UserDAO {

	public abstract User createValueObject();

	public  User searchMatching(User valueObject) throws DAOException;
}
