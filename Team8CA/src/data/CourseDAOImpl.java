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
		String sqlStr = "SELECT * FROM course";
		try {
			rs = statement.executeQuery(sqlStr);
			while (rs.next()) {
				CourseDTO c = new CourseDTO(rs.getString("CourseName"), rs.getString("TypeOfCourse"),
						rs.getString("LecturerID"));
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
		CourseDTO c = new CourseDTO();
		openConnection();
		String sqlStr = "SELECT * FROM course WHERE CourseName=" + course.getCourseName();
		try {
			rs = statement.executeQuery(sqlStr);
			while (rs.next()) {
				c.setCourseName(rs.getString("CourseName"));
				c.setTypeOfCourse(rs.getString("TypeOfCourse"));
				c.setLecturerID(rs.getString("LecturerID"));
			}	
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DAOException();
		}
		closeConnection();
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
				if(prep.executeUpdate() != 1){
					connection.rollback();
					throw new DAOException();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				
			}
			
			closeConnection();
		}
}

		