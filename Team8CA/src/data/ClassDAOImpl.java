package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.ClassDTO;

public class ClassDAOImpl implements ClassDAO {
	private static final String dbUrl = "jdbc:mysql://localhost:3306/team8";
	private static final String dbUserName = "root";
	private static final String dbPassword = "password";
	
	
	
	//Establishes Connection
	private Connection openConnection(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Connection connection = null;
		try {
			connection=DriverManager.getConnection("jdbc:mysql://localhost/team8","root","password");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
		
	}
	
	/* (non-Javadoc)
	 * @see data.ClassDAO#getUntakenClasses(java.lang.String)
	 */
	
	
	//Takes matric number in as input and returns classes.The classes returns in this method fills up all
	//attributes of the ClassDTO except for the number of students enrolled in class
	//Number of students enrolled is added with the DAO Method getNumberEnrolled
	@Override
	public ArrayList<ClassDTO> getUntakenClasses(String matricNumber){
		ArrayList<ClassDTO> classList=null;
		Connection connection = openConnection();
		PreparedStatement ps = null;
		String string = "SELECT * FROM team8.class where ClassID not in(SELECT ClassID FROM team8.student_enrolment where status='completed' and MatricNumber=?);";
		try {
			classList = new ArrayList<ClassDTO>();
			connection.setAutoCommit(false);
			ps = connection.prepareStatement(string);
			ps.setString(1, matricNumber);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				
				ClassDTO classDTO = new ClassDTO();
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
		} finally{
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
	
	
	//this method takes in an array list of classDTO and adds number of students enrolled to attributes
	//the rationale behind designing a method in such a way is such that 1. queries will be simplified
	//2. getNumberEnrolled Method can enable number enrolled to be used in methods similar to getUntakenClasses
	public ArrayList<ClassDTO> getNumberEnrolled(ArrayList<ClassDTO> classList){
	
		Connection connection = openConnection();
		PreparedStatement ps = null;
		String string = "SELECT count(*) FROM team8.student_enrolment  where Status = 'Enrolled' and ClassID = ?;";
		try {
			connection.setAutoCommit(false);
			ps = connection.prepareStatement(string);
			
			for(ClassDTO c: classList){
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
		} finally{
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
