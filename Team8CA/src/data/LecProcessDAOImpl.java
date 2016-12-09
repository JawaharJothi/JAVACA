package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.ClassCourseDTO;
import model.Page;
import model.StudentDTO;
import model.StudentPerformanceDTO;

public class LecProcessDAOImpl implements LecProcessDAO {
	private static final String dbUrl = "jdbc:mysql://localhost:3306/team8";
	private static final String dbUserName = "root";
	private static final String dbPassword = "password";
	private int noOfRecords = 0;

	@Override
	public ArrayList<ClassCourseDTO> findassigncourse(String id) throws DAOException {
		ArrayList<ClassCourseDTO> classcourse = new ArrayList<ClassCourseDTO>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		String sql = "SELECT * FROM class c, course co where c.CourseName = co.CourseName AND co.LecturerID='" + id
				+ "'";
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
			rs.close();
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

		String sql = "select * from student s, class c,  student_enrolment se where s.MatricNumber=se.MatricNumber AND se.ClassID=c.ClassID AND s.MatricNumber='"
				+ id + "'";
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

	@Override
	public ArrayList<StudentDTO> findallstudents(String id, int offset, int noOfRecords) throws DAOException {
		// TODO Auto-generated method stub
		ArrayList<StudentDTO> slist = new ArrayList<StudentDTO>();

		try {
			Class.forName("com.mysql.jdbc.Driver");
		}

		catch (ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		String sql = "select * from student s, student_enrolment se, class c WHERE s.MatricNumber=se.MatricNumber AND se.ClassID=c.ClassID AND  c.ClassID='"
				+ id + "' LIMIT " + offset + ", " + noOfRecords;
		Connection con = null;

		try {
			con = DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				StudentDTO sdto = new StudentDTO();
				sdto.setMatricno(rs.getString("MatricNumber"));
				sdto.setStudentname(rs.getString("StudentName"));
				sdto.setDateofbirth(rs.getString("DateofBirth"));
				sdto.setAddress(rs.getString("Address"));
				sdto.setPhone(rs.getInt("PhoneNumber"));
				sdto.setImage(rs.getString("Image"));
				sdto.setStatus(rs.getString("Status"));
				sdto.setEmail(rs.getString("Email"));
				slist.add(sdto);
			}
			rs.close();

			rs = st.executeQuery("SELECT FOUND_ROWS()");
			if (rs.next()) {
				Page p = new Page();
				p.setPage(rs.getInt(1));
			}
			rs.close();

		}

		catch (SQLException e) {
			String error = "Student cannot be selected. Nested Exception is: " + e;
			throw new DAOException(error);
		} finally {
			try {
				con.close();
			} catch (Exception e) {
			}
		}
		return slist;
	}

	public int getNoOfRecords(String id) throws DAOException {
		int i =0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}

		catch (ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		}


		Connection con = null;

		try {
			con = DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
			Statement st = con.createStatement();
			ResultSet rs =  st.executeQuery("select count(*) from student s, student_enrolment se, class c WHERE s.MatricNumber=se.MatricNumber AND se.ClassID=c.ClassID AND  c.ClassID='"
				+ id + "'");
			if (rs.next()) {
				
				i=rs.getInt(1);
			}
			rs.close();

		}

		catch (SQLException e) {
			String error = "Student cannot be selected. Nested Exception is: " + e;
			throw new DAOException(error);
		} finally {
			try {
				con.close();
			} catch (Exception e) {
			}
		}
		return i;

	}

}
