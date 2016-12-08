package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.ClassCourseDTO;
import model.StudentPerformanceDTO;


public class LecProcessDAOImpl implements LecProcessDAO{
	private static final String dbUrl = "jdbc:mysql://localhost:3306/team8";
	private static final String dbUserName = "root";
	private static final String dbPassword = "password";
	@Override
	public ArrayList<ClassCourseDTO> findassigncourse(String id) throws DAOException {
		ArrayList<ClassCourseDTO> classcourse = new ArrayList<ClassCourseDTO>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		String sql = "SELECT * FROM class c, course co where c.CourseName = co.CourseName AND co.LecturerID='"+id+"'";
		Connection con = null;

		try {
			con = DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			while (rs.next()) {
				ClassCourseDTO cclist = new ClassCourseDTO();
				cclist.setCourseName(rs.getString("CourseName"));
				cclist.setClassSize(Integer.parseInt(rs.getString("ClassSize")));
				cclist.setStartDate(rs.getString("StartDate"));
				cclist.setEndDate(rs.getString("EndDate"));
				cclist.setTypeOfCourse(rs.getString("TypeOfCourse"));
				cclist.setClassID(rs.getString("ClassID"));
				classcourse.add(cclist);
			
			}
			st.close();
		} catch (SQLException e) {
			String error = "Error selecting Lecturer Course. Nested Exception is: " + e;
			throw new DAOException(error);
		} finally {
			try {
				con.close();
			} catch (Exception e) {
			}
		}
		return classcourse;
	}
	@Override
	public ArrayList<StudentPerformanceDTO> findsperformancelist(String id) throws DAOException {
		ArrayList<StudentPerformanceDTO> slist = new ArrayList<StudentPerformanceDTO>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		String sql = "select * from student s, class c,  student_enrolment se where s.MatricNumber=se.MatricNumber AND se.ClassID=c.ClassID AND s.MatricNumber='"+id+"'";
		Connection con = null;

		try {
			con = DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			while (rs.next()) {
				StudentPerformanceDTO splist = new StudentPerformanceDTO();
				splist.setMatricno(rs.getString("MatricNumber"));
				splist.setStudentname(rs.getString("StudentName"));
				splist.setStartDate(rs.getString("StartDate"));
				splist.setEndDate(rs.getString("EndDate"));
				splist.setCourseName(rs.getString("CourseName"));
				splist.setGrade(rs.getString("Grade"));
				slist.add(splist);
			
			}
			st.close();
		} catch (SQLException e) {
			String error = "Error selecting Student Performance list. Nested Exception is: " + e;
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
