package data;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
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
	@Override
	public void updateStudentGrading(String id, String grade, String cid) throws DAOException {
		// TODO Auto-generated method stub
		String insertsql1 = "UPDATE `team8`.`student_enrolment` SET `Grade`=? WHERE `MatricNumber`=? and`ClassID`=?;";
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Connection con = null;
		try {

			con = DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
			PreparedStatement pt = con.prepareStatement(insertsql1);
			
			pt.setString(2, id);
			pt.setString(3, cid);
			pt.setString(1, grade);
			pt.executeUpdate();
			pt.close();


		} catch (Exception e) {
			String error = "Error Updating lecturer. Nested Exception is: " + e;
			throw new DAOException(error);
		} finally {
			try {
				con.close();
			} catch (Exception e) {
			}
		}
		
	}




}
