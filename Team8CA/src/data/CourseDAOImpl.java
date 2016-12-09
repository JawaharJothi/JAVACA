package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.ClassDTO;
import model.CourseDTO;

public class CourseDAOImpl implements CourseDAO {

	private Connection connection;
	private Statement statement;
	private PreparedStatement prep;
	private ResultSet rs;
	private static final String dbUrl = "jdbc:mysql://localhost:3306/team8";
	private static final String dbUserName = "root";
	private static final String dbPassword = "password";

	private void openConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/team8", "root", "password");
			statement = connection.createStatement();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void closeConnection() {
		try {
			statement.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<CourseDTO> findAllCourse() throws DAOException {
		ArrayList<CourseDTO> result = new ArrayList<CourseDTO>();
		openConnection();
		String sqlStr = "SELECT * FROM course c, lecturer l where c.LecturerID = l.LecturerID";
		try {
			rs = statement.executeQuery(sqlStr);
			while (rs.next()) {
				CourseDTO c = new CourseDTO(rs.getString("CourseName"), rs.getString("TypeOfCourse"),
						rs.getString("LecturerID"), rs.getString("LecturerName"));
				result.add(c);
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DAOException();
		}
		closeConnection();
		return result;
	}

	public CourseDTO findOneCourse(CourseDTO course) throws DAOException {
		openConnection();
		CourseDTO c = new CourseDTO();
		int count = 0;
		String sqlStr = "SELECT * FROM course WHERE CourseName='" + course.getCourseName() + "'";
		try {
			rs = statement.executeQuery(sqlStr);
			while (rs.next()) {
				count++;
				c.setCourseName(rs.getString("CourseName"));
				c.setTypeOfCourse(rs.getString("TypeOfCourse"));
				c.setLecturerID(rs.getString("LecturerID"));
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DAOException();
		}
		closeConnection();
		if (count == 0) {
			c = null;
		}
		return c;
	}

	@Override
	public void insertCourse(CourseDTO course) throws DAOException {
		openConnection();
		String sqlStr = "INSERT INTO course VALUES(?, ?, ?)";
		try {
			connection.setAutoCommit(false);
			prep = connection.prepareStatement(sqlStr);
			prep.setString(1, course.getCourseName());
			prep.setString(2, course.getTypeOfCourse());
			prep.setString(3, course.getLecturerID());
			if (prep.executeUpdate() != 1) {
				connection.rollback();
				throw new DAOException();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block

		}

		closeConnection();
	}

	@Override
	public int updateCourse(CourseDTO course) throws DAOException {
		openConnection();
		// String sqlStr = "UPDATE course SET TypeOfCourse='?', LecturerID='?'
		// WHERE CourseName='?'";
		String sqlStr = "UPDATE course SET TypeOfCourse='" + course.getTypeOfCourse() + "', LecturerID='"
				+ course.getLecturerID() + "' WHERE CourseName='" + course.getCourseName() + "'";
		int result;
		try {
			// connection.setAutoCommit(false);
			System.out.println("i made it here 0");
			// prep = connection.prepareStatement(sqlStr);

			System.out.println("i made it here 0.5");
			System.out.println(course.getTypeOfCourse());
			System.out.println(course.getLecturerID());
			System.out.println(course.getCourseName());

			// prep.setString(1, course.getTypeOfCourse());
			// prep.setString(2, course.getLecturerID());
			// prep.setString(3, course.getCourseName());
			System.out.println("i made it here 1");
			// result = prep.executeUpdate();
			result = statement.executeUpdate(sqlStr);
			System.out.println("i made it here 2");
			// if (result != 1) {
			// connection.rollback();
			// throw new DAOException();
			// }
			// connection.commit();
			// prep.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("inside catch block");
			System.out.println(e.getMessage());
			throw new DAOException();
		} finally {
			closeConnection();
		}
		return result;
	}

	@Override
	public boolean deleteCourse(CourseDTO course) throws DAOException {
		openConnection();
		boolean result;
		String sqlStr = "DELETE FROM course WHERE CourseName='" + course.getCourseName() + "'";
		try {
			result = statement.execute(sqlStr);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DAOException();
		} finally {
			closeConnection();
		}
		return result;
	}
}
