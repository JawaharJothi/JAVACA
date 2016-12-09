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

import model.ClassDTO;

public class ClassDAOImpl implements ClassDAO {
	private static final String dbUrl = "jdbc:mysql://localhost:3306/team8";
	private static final String dbUserName = "root";
	private static final String dbPassword = "password";

	/* (non-Javadoc)
	 * @see data.ClassDAO#findAllClass()
	 */
	@Override
	public ArrayList<ClassDTO> findAllClass() throws DAOException {

		ArrayList<ClassDTO> clist = new ArrayList<ClassDTO>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		String sql = "SELECT * FROM `team8`.`Class`";
		Connection con = null;
		try {
			con = DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				ClassDTO cdto = new ClassDTO();
				cdto.setClassID(rs.getString("ClassID"));
				cdto.setClassSize(rs.getInt("ClassSize"));
				cdto.setStartDate(rs.getString("StartDate"));
				cdto.setEndDate(rs.getString("EndDate"));
				cdto.setCredit(rs.getString("Credit"));
				cdto.setCourseName(rs.getString("CourseName"));
				clist.add(cdto);
			}
			st.close();
		}

		catch (SQLException e) {
			String error = "Class cannot be selected. Nested Exception is: " + e;
			throw new DAOException(error);
		} finally {
			try {
				con.close();
			} catch (Exception e) {
			}
		}
		return clist;
	}

	/* (non-Javadoc)
	 * @see data.ClassDAO#insertClass(model.ClassDTO)
	 */
	@Override
	public void insertClass(ClassDTO cdto) throws DAOException {
		// TODO Auto-generated method stub

		String sqlInsert = "INSERT INTO class VALUES(?,?,?,?,?,?)";

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Connection con = null;

		try {
			java.util.Date date = new SimpleDateFormat("yyyy-MM-dd").parse(cdto.getStartDate());
			Date sqlSdate = new Date(date.getTime());
			java.util.Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(cdto.getEndDate());
			Date sqlEdate = new Date(date1.getTime());

			con = DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
			PreparedStatement pt = con.prepareStatement(sqlInsert);
			pt.setString(1, cdto.getClassID());
			pt.setInt(2, cdto.getClassSize());
			pt.setDate(3, sqlSdate);
			pt.setDate(4, sqlEdate);
			pt.setString(5, cdto.getCredit());
			pt.setString(6, cdto.getCourseName());
			pt.executeUpdate();
			pt.close();
		} catch (Exception e) {
			String error = "Error inseting Class. Nested Exception is: " + e;
			throw new DAOException(error);
		} finally {
			try {
				con.close();
			} catch (Exception e) {
			}
		}
	}

	/* (non-Javadoc)
	 * @see data.ClassDAO#DeleteClass(model.ClassDTO)
	 */
	@Override
	public void DeleteClass(ClassDTO cls) throws DAOException {
		String sql = "Delete from `team8`.`Class` where ClassID = ?";
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Connection con = null;
		try {
			con = DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
			PreparedStatement pt = con.prepareStatement(sql);
			pt.setString(1, cls.getClassID());
			pt.executeUpdate();
			pt.close();

		} catch (SQLException e) {
			String error = "Error Deleteing Class. Nested Exception is: " + e;
			throw new DAOException(error);
		} finally {
			try {
				con.close();
			} catch (Exception e) {
			}
		}
	}

	/* (non-Javadoc)
	 * @see data.ClassDAO#FindClass(java.lang.String)
	 */
	@Override
	public ClassDTO FindClass(String cid) throws DAOException {
		String sql = "Select * from Class where ClassID ='" + cid.trim() +"'";
		ClassDTO cls = new ClassDTO();
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		ClassDTO ctd = new ClassDTO();
		Connection con = null;
		try {
			con = DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()){
				ctd.setClassID(rs.getString("ClassID"));
				ctd.setClassSize(rs.getInt("ClassSize"));
				ctd.setStartDate(rs.getString("StartDate"));
				ctd.setEndDate(rs.getString("EndDate"));
				ctd.setCredit(rs.getString("Credit"));
				ctd.setCourseName(rs.getString("CourseName"));
			}
		} catch (Exception e) {
			String error = "Error selecting Class. Nested Exception is: " + e;
			Logger.getLogger(getClass().getName()).log(Level.SEVERE, error);
			throw new DAOException(error);
		} finally {
			try {

				con.close();
			} catch (Exception e) {
			}
		}
		return ctd;
	}

	/* (non-Javadoc)
	 * @see data.ClassDAO#UpdateClass(model.ClassDTO)
	 */
	@Override
	public void UpdateClass(ClassDTO cls) throws DAOException{
		String sql ="UPDATE Class set ClassSize =?, StartDate =?, EndDate =?, Credit =?, CourseName =? where ClassID =?";
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Connection con = null;
		try {
			java.util.Date date = new SimpleDateFormat("yyyy-MM-dd").parse(cls.getStartDate());
			Date sqlSdate = new Date(date.getTime());
			
			java.util.Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(cls.getEndDate());
			Date sqlEdate = new Date(date1.getTime());

			con = DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
			PreparedStatement pt = con.prepareStatement(sql);
			
			pt.setInt(1, cls.getClassSize());
			pt.setDate(2, sqlSdate);
			pt.setDate(3, sqlEdate);
			pt.setString(4, cls.getCredit());
			pt.setString(5, cls.getCourseName());
			pt.setString(6, cls.getClassID());
			pt.executeUpdate();
			pt.close();

		} catch (Exception e) {
			String error = "Error Updating Class. Nested Exception is: " + e;
			throw new DAOException(error);
		} finally {
			try {
				con.close();
			} catch (Exception e) {
			}
		}

	}
	}

