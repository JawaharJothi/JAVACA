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

import model.LecturerDTO;


public class LecturerDAOImpl implements LecturerDAO {
	private static final String dbUrl = "jdbc:mysql://localhost:3306/team8";
	private static final String dbUserName = "root";
	private static final String dbPassword = "password";

	@Override
	public ArrayList<LecturerDTO> findalllecturer() throws DAOException {
		// TODO Auto-generated method stub
		ArrayList<LecturerDTO> llist = new ArrayList<LecturerDTO>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		String sql = "SELECT * FROM team8.lecturer l, team8.user u where l.LecturerID=u.userid;";
		Connection con = null;

		try {
			con = DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				LecturerDTO ldto = new LecturerDTO();
				ldto.setLecturerID(rs.getString("LecturerID"));
				ldto.setLecturername(rs.getString("LecturerName"));
				ldto.setDob(rs.getString("DateofBirth"));
				ldto.setPhone(rs.getInt("Phone"));
				ldto.setLectureraddress(rs.getString("LecturerAddress"));
				ldto.setEmail(rs.getString("Email"));
				ldto.setDegree(rs.getString("EducationalQualification"));
				ldto.setPassword(rs.getString("Password"));
				llist.add(ldto);
			}
			st.close();
		} catch (SQLException e) {
			String error = "Error selecting Lecturer. Nested Exception is: " + e;
			throw new DAOException(error);
		} finally {
			try {
				con.close();
			} catch (Exception e) {
			}
		}
		return llist;
	}

	@Override
	public void insertlecturer(LecturerDTO ldto) throws DAOException {
		String insertsql1 = "INSERT INTO lecturer VALUES(?,?,?,?,?,?,?)";
		String insertsql2 = "INSERT INTO user VALUES(?,?,?)";
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Connection con = null;
		try {
			java.util.Date date = new SimpleDateFormat("yyyy-MM-dd").parse(ldto.getDob());
			Date sqldate = new Date(date.getTime());

			con = DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
			PreparedStatement pt = con.prepareStatement(insertsql1);
			pt.setString(1, ldto.getLecturerID());
			pt.setString(2, ldto.getLecturername());
			pt.setDate(3, sqldate);
			pt.setInt(4, ldto.getPhone());
			pt.setString(5, ldto.getLectureraddress());
			pt.setString(6, ldto.getEmail());
			pt.setString(7, ldto.getDegree());
			pt.executeUpdate();
			pt.close();

			pt = con.prepareStatement(insertsql2);
			pt.setString(1, ldto.getLecturerID());
			pt.setString(2, ldto.getPassword());
			pt.setString(3, "Lecturer");
			pt.executeUpdate();
			pt.close();

		} catch (Exception e) {
			String error = "Error inseting lecturer. Nested Exception is: " + e;
			throw new DAOException(error);
		} finally {
			try {
				con.close();
			} catch (Exception e) {
			}
		}

	}

	@Override
	public void deletelecturer(LecturerDTO ldto) throws DAOException {
		// TODO Auto-generated method stub
		String insertsql1 = "DELETE FROM `team8`.`lecturer` WHERE `LecturerID`=?";
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
			pt.setString(1, ldto.getLecturerID());
			pt.executeUpdate();
			pt.close();

			pt = con.prepareStatement(insertsql2);
			pt.setString(1, ldto.getLecturerID());
			pt.executeUpdate();
			pt.close();
		} catch (SQLException e) {
			String error = "Error Deleteing lecturer. Nested Exception is: " + e;
			throw new DAOException(error);
		} finally {
			try {
				con.close();
			} catch (Exception e) {
			}
		}

	}

	@Override
	public LecturerDTO findlecturer(String id) throws DAOException {
		String selectsql = "SELECT * FROM lecturer WHERE LecturerID='" + id.trim() + "'";
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		LecturerDTO ldto = new LecturerDTO();
		Connection con = null;
		try {
			con = DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(selectsql);
			while (rs.next()) {

				ldto.setLecturerID(rs.getString("LecturerID"));
				ldto.setLecturername(rs.getString("LecturerName"));
				ldto.setDob(rs.getString("DateofBirth"));
				ldto.setPhone(rs.getInt("Phone"));
				ldto.setLectureraddress(rs.getString("LecturerAddress"));
				ldto.setEmail(rs.getString("Email"));
				ldto.setDegree(rs.getString("EducationalQualification"));

			}

		} catch (Exception e) {
			String error = "Error selecting lecturer. Nested Exception is: " + e;
			Logger.getLogger(getClass().getName()).log(Level.SEVERE, error);
			throw new DAOException(error);
		} finally {
			try {

				con.close();
			} catch (Exception e) {
			}
		}
		return ldto;
	}

	@Override
	public void updatelecturer(LecturerDTO ldto) throws DAOException {
		String insertsql1 = "UPDATE lecturer SET  LecturerName=?, DateofBirth=?, Phone=?, LecturerAddress=?, Email=?,  EducationalQualification=? WHERE LecturerID=?;";
		String insertsql2 = "UPDATE user SET Password=? WHERE UserID=? ";
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Connection con = null;
		try {
			java.util.Date date = new SimpleDateFormat("yyyy-MM-dd").parse(ldto.getDob());
			Date sqldate = new Date(date.getTime());

			con = DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
			PreparedStatement pt = con.prepareStatement(insertsql1);
			
			pt.setString(1, ldto.getLecturername());
			pt.setDate(2, sqldate);
			pt.setInt(3, ldto.getPhone());
			pt.setString(4, ldto.getLectureraddress());
			pt.setString(5, ldto.getEmail());
			pt.setString(6, ldto.getDegree());
			pt.setString(7, ldto.getLecturerID());
			pt.executeUpdate();
			pt.close();

			pt = con.prepareStatement(insertsql2);
			pt.setString(2, ldto.getLecturerID());
			pt.setString(1, ldto.getPassword());
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
