package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.ClassCourseDTO;
import model.LecturerDTO;
import model.StudentGradingDTO;

public class StudentGradingDAOImpl implements StudentGradingDAO {
	private static final String dbUrl = "jdbc:mysql://localhost:3306/team8";
	private static final String dbUserName = "root";
	private static final String dbPassword = "password";
	@Override
	public ArrayList<StudentGradingDTO> findstudentlistforgrading(String id) throws DAOException {
		ArrayList<StudentGradingDTO> slist = new ArrayList<StudentGradingDTO>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		String sql = "SELECT * FROM student s, student_enrolment se, class c where s.MatricNumber = se.MatricNumber AND se.ClassID=c.ClassID AND c.ClassID = '"+id+"'";
		Connection con = null;

		try {
			con = DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				StudentGradingDTO ldto = new StudentGradingDTO();
				ldto.setMatricNumber(rs.getString("MatricNumber"));
				ldto.setStudentName(rs.getString("StudentName"));
				ldto.setCourseName(rs.getString("CourseName"));
				ldto.setStartDate(rs.getString("StartDate"));
				ldto.setEndDate(rs.getString("EndDate"));
				ldto.setGrade(rs.getString("Grade"));
				slist.add(ldto);
			}
			st.close();
		} catch (SQLException e) {
			String error = "Error selecting Student list. Nested Exception is: " + e;
			throw new DAOException(error);
		} finally {
			try {
				con.close();
			} catch (Exception e) {
			}
		}
		return slist;
	}




}
