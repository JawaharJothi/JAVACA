package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import model.CourseGradeDTO;

public class CourseGradeDAOImpl implements CourseGradeDAO {
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
	
	

	
	public ArrayList<CourseGradeDTO> findPastGrades(String matricNumber){
		ArrayList<CourseGradeDTO> courseGradeList=null;
		Connection connection = openConnection();
		PreparedStatement ps = null;
		String string = "SELECT SE.classID,C.CourseName,SE.MatricNumber,C.credit,SE.grade FROM team8.student_enrolment SE, team8.class C WHERE 1=1 AND SE.ClassID = C.ClassID AND Status='Completed' and matricnumber=?;";
		try {
			courseGradeList = new ArrayList<CourseGradeDTO>();
			connection.setAutoCommit(false);
			ps = connection.prepareStatement(string);
			ps.setString(1, matricNumber);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				CourseGradeDTO courseGradeDTO = new CourseGradeDTO();
				courseGradeDTO.setClassID(rs.getString("ClassID"));
				courseGradeDTO.setCourseName(rs.getString("CourseName"));
				courseGradeDTO.setCredit(rs.getString("Credit"));
				courseGradeDTO.setGrade(rs.getString("Grade"));
				courseGradeList.add(courseGradeDTO);
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
		
		return courseGradeList;
		
	}
	
}
