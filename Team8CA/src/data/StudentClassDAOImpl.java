package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.StudentClassDTO;

public class StudentClassDAOImpl implements StudentClassDAO {
	private static final String dbUrl = "jdbc:mysql://localhost:3306/team8";
	private static final String dbUserName = "root";
	private static final String dbPassword = "password";

	// Establishes Connection
	private Connection openConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;

	}


	@Override
	public ArrayList<StudentClassDTO> gettakenClasses(String matricNumber) throws DAOException {
		// TODO Auto-generated method stub
		System.out.println("taken");
		ArrayList<StudentClassDTO> classList = null;
		Connection connection = openConnection();
		PreparedStatement ps = null;
		String string = "SELECT * FROM team8.class where ClassID in(SELECT ClassID FROM team8.student_enrolment where status = 'Enrolled' and MatricNumber=?);";
		try {
			classList = new ArrayList<StudentClassDTO>();
			connection.setAutoCommit(false);
			ps = connection.prepareStatement(string);
			ps.setString(1, matricNumber);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				StudentClassDTO classDTO = new StudentClassDTO();
				classDTO.setClassID(rs.getString("ClassID"));
				classDTO.setStartDate(rs.getDate("StartDate"));
				classDTO.setEndDate(rs.getDate("EndDate"));
				classList.add(classDTO);
			}

			connection.commit();
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {

				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				ps.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
			try {
				connection.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}

		}
		System.out.println("--------------------------takenclass:" + classList.size());
		return classList;

	}

	@Override
	public ArrayList<StudentClassDTO> getNumberEnrolled(ArrayList<StudentClassDTO> classList) throws DAOException {
		System.out.println("noenroll");
		Connection connection = openConnection();
		PreparedStatement ps = null;
		String string = "SELECT count(*) FROM team8.student_enrolment  where Status = 'Enrolled' and ClassID = ?;";
		try {
			connection.setAutoCommit(false);
			ps = connection.prepareStatement(string);

			for (StudentClassDTO c : classList) {
				ps.setString(1, c.getClassID());
				ResultSet rs = ps.executeQuery();
				rs.first();
				c.setNumberEnrolled(rs.getInt("count(*)"));

			}

			connection.commit();
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {

				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				ps.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
			try {
				connection.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}

		}

		return classList;
	}

	@Override
	public ArrayList<StudentClassDTO> getUntakenClasses(String matricNumber) throws DAOException {
		// TODO Auto-generated method stub
		ArrayList<StudentClassDTO> classList = null;
		Connection connection = openConnection();
		PreparedStatement ps = null;
		String string = "SELECT * FROM team8.class where ClassID not in(SELECT ClassID FROM team8.student_enrolment where (status='Completed' or status = 'Enrolled') and MatricNumber=?);";
		try {
			classList = new ArrayList<StudentClassDTO>();
			connection.setAutoCommit(false);
			ps = connection.prepareStatement(string);
			ps.setString(1, matricNumber);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				StudentClassDTO classDTO = new StudentClassDTO();
				classDTO.setClassID(rs.getString("ClassID"));
				classDTO.setCourseName(rs.getString("CourseName"));
				classDTO.setStartDate(rs.getDate("StartDate"));
				classDTO.setEndDate(rs.getDate("EndDate"));
				classDTO.setCredit(rs.getString("Credit"));
				classDTO.setClassSize(rs.getInt("ClassSize"));
				classList.add(classDTO);
			}

			connection.commit();
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {

				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				ps.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
			try {
				connection.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}

		}

		return classList;
	}

}
