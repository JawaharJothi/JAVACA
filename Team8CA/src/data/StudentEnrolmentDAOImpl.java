package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import model.StudentEnrolmentDTO;

public class StudentEnrolmentDAOImpl implements StudentEnrolmentDAO {
	private static final String dbUrl = "jdbc:mysql://localhost:3306/team8";
	private static final String dbUserName = "root";
	private static final String dbPassword = "password";

	/*
	 * (non-Javadoc)
	 * 
	 * @see data.StudentEnrolmentDAO#addEnrollment(model.StudentEnrollmentDTO)
	 */
	@Override
	public void addEnrollment(StudentEnrolmentDTO sedto) throws DAOException {
		String sql = "INSERT INTO student_enrolment VALUES(?,?,?,?)";
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		Connection con = null;

		try {
			con = DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
			PreparedStatement pt = con.prepareStatement(sql);
			pt.setString(1, sedto.getMatricnumber());
			pt.setString(2, sedto.getClassid());
			pt.setString(3, "NA");
			pt.setString(4, "Enrolled");
			System.out.println(sql);
			pt.executeUpdate();
			pt.close();

		} catch (SQLException e) {
			String error = "Error inseting student_enrolment. Nested Exception is: " + e;
			throw new DAOException(error);
		} finally {
			try {
				con.close();
			} catch (Exception e) {
			}
		}
	}
}
