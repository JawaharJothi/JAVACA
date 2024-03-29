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
import java.util.logging.Level;
import java.util.logging.Logger;

import model.StudentDTO;

public class StudentDAOImpl implements StudentDAO {
	private static final String dbUrl = "jdbc:mysql://localhost:3306/team8";
	private static final String dbUserName = "root";
	private static final String dbPassword = "password";

	@Override
	public ArrayList<StudentDTO> findallstudents( int offset, int noOfRecords) throws DAOException {
		// TODO Auto-generated method stub
		ArrayList<StudentDTO> slist = new ArrayList<StudentDTO>();

		try {
			Class.forName("com.mysql.jdbc.Driver");
		}

		catch (ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		String sql = "select * from student LIMIT " + offset + ", " + noOfRecords;
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
			st.close();
			
			
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

	@Override
	public void insertStudent(StudentDTO sdto) throws DAOException {
		// TODO Auto-generated method stub

		String sqlInsert1 = "INSERT INTO student VALUES(?,?,?,?,?,?,?,?)";
		String sqlInsert2 = "INSERT INTO user VALUES(?,?,?)";

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Connection con = null;

		try {
			java.util.Date date = new SimpleDateFormat("yyyy-MM-dd").parse(sdto.getDateofbirth());
			Date sqldate = new Date(date.getTime());

			con = DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
			PreparedStatement pt = con.prepareStatement(sqlInsert1);
			pt.setString(1, sdto.getMatricno());
			pt.setString(2, sdto.getStudentname());
			pt.setDate(3, sqldate);
			pt.setInt(4, sdto.getPhone());
			pt.setString(5, sdto.getAddress());
			pt.setString(6, sdto.getEmail());
			pt.setString(7, sdto.getImage());
			pt.setString(8, sdto.getStatus());
			pt.executeUpdate();
			pt.close();

			pt = con.prepareStatement(sqlInsert2);
			pt.setString(1, sdto.getMatricno());
			pt.setString(2, sdto.getPassword());
			pt.setString(3, "Student");
			pt.executeUpdate();
			pt.close();

		} catch (Exception e) {
			String error = "Error inseting Student. Nested Exception is: " + e;
			throw new DAOException(error);
		} finally {
			try {
				con.close();
			} catch (Exception e) {
			}
		}
	}

	public StudentDTO findstudent(String id) throws DAOException {

		String selectsql = "SELECT * FROM student WHERE MatricNumber='" + id.trim() + "'";
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		StudentDTO sdto = new StudentDTO();
		Connection con = null;
		try {
			con = DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(selectsql);
			while (rs.next()) {
				
				sdto.setMatricno(rs.getString("MatricNumber"));
				sdto.setStudentname(rs.getString("StudentName"));
				sdto.setDateofbirth(rs.getString("DateofBirth"));
				sdto.setAddress(rs.getString("Address"));
				sdto.setPhone(rs.getInt("PhoneNumber"));
				sdto.setImage(rs.getString("Image"));
				sdto.setStatus(rs.getString("Status"));
				sdto.setEmail(rs.getString("Email"));

			}
			System.out.println(sdto.getStudentname());

		} catch (Exception e) {
			String error = "Error selecting student. Nested Exception is: " + e;
			Logger.getLogger(getClass().getName()).log(Level.SEVERE, error);
			throw new DAOException(error);
		} finally {
			try {

				con.close();
			} catch (Exception e) {
			}
		}
		return sdto;

	}

	@Override
	public void deletestudent(StudentDTO sdto) throws DAOException {
		// TODO Auto-generated method stub
		String insertsql1 = "DELETE FROM `team8`.`student` WHERE `MatricNumber`=?";
		String insertsql2 = "DELETE FROM `team8`.`user` WHERE `UserID`=?";
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
			pt.setString(1, sdto.getMatricno());
			pt.executeUpdate();
			pt.close();

			pt = con.prepareStatement(insertsql2);
			pt.setString(1, sdto.getMatricno());
			pt.executeUpdate();
			pt.close();
		} catch (SQLException e) {
			String error = "Error Deleteing Student. Nested Exception is: " + e;
			throw new DAOException(error);
		} finally {
			try {
				con.close();
			} catch (Exception e) {
			}
		}

	}

	@Override
	public void updatestudent(StudentDTO sdto) throws DAOException {
		// TODO Auto-generated method stub

		String insertsql1 = "UPDATE student SET  StudentName=?, DateofBirth=?, PhoneNumber=?, Address=?, Email=?,  Image=?, Status=? WHERE MatricNumber=?;";
		String insertsql2 = "UPDATE user SET Password=? WHERE UserID=? ";
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Connection con = null;
		try {
			java.util.Date date = new SimpleDateFormat("yyyy-MM-dd").parse(sdto.getDateofbirth());
			Date sqldate = new Date(date.getTime());

			con = DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
			PreparedStatement pt = con.prepareStatement(insertsql1);

			pt.setString(1, sdto.getStudentname());
			pt.setDate(2, sqldate);
			pt.setInt(3, sdto.getPhone());
			pt.setString(4, sdto.getAddress());
			pt.setString(5, sdto.getEmail());
			pt.setString(6, sdto.getImage());
			pt.setString(7, sdto.getStatus());
			pt.setString(8, sdto.getMatricno());
			pt.executeUpdate();
			pt.close();

			pt = con.prepareStatement(insertsql2);
			pt.setString(2, sdto.getMatricno());
			pt.setString(1, sdto.getPassword());
			pt.executeUpdate();
			pt.close();

		} catch (Exception e) {
			String error = "Error Updating Student. Nested Exception is: " + e;
			throw new DAOException(error);
		} finally {
			try {
				con.close();
			} catch (Exception e) {
			}
		}

	}




	@Override
	public int getNoOfRecords() throws DAOException {
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
			ResultSet rs =  st.executeQuery("select count(*) from student");
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
