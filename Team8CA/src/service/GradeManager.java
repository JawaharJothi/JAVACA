package service;

import java.util.ArrayList;

import data.CourseGradeDAO;
import data.DaoFactory;
import model.CourseGradeDTO;

public class GradeManager {
	private CourseGradeDAO courseGradeDAO;
	
	public GradeManager() {
		super();
		courseGradeDAO = DaoFactory.getCourseGradeDAO();
	}

	public ArrayList<CourseGradeDTO> findPastGrades(String matricNumber){
		return courseGradeDAO.findPastGrades(matricNumber);
		
	}
	
	public double ComputeCAP(String matricNumber){
	
		ArrayList<CourseGradeDTO> courseGradeList = findPastGrades(matricNumber);
		int MCSum = 0;
		double gradeSum=0;
		for(CourseGradeDTO c: courseGradeList){
			System.out.println(c.getGrade());
			MCSum += Integer.parseInt(c.getCredit());
			if(c.getGrade().equals("A+") || c.getGrade().equals("A")){
				gradeSum+=(5.0* Integer.parseInt(c.getCredit()));
				
			} else if(c.getGrade().equals("A-")){
				gradeSum+=(4.5* Integer.parseInt(c.getCredit()));
			} else if(c.getGrade().equals("B+")){
				gradeSum+=(4.0* Integer.parseInt(c.getCredit()));
			} else if(c.getGrade().equals("B")){
				gradeSum+=(3.5* Integer.parseInt(c.getCredit()));
			} else if(c.getGrade().equals("B-")){
				gradeSum+=(3.0* Integer.parseInt(c.getCredit()));
			} else if(c.getGrade().equals("C+")){
				gradeSum+=(2.5* Integer.parseInt(c.getCredit()));
			} else if(c.getGrade().equals("C")){
				gradeSum+=(2.0* Integer.parseInt(c.getCredit()));
			} else if (c.getGrade().equals("D+")){
				gradeSum+=(1.5* Integer.parseInt(c.getCredit()));
			} else if(c.getGrade().equals("D")){
				gradeSum+=(1.0* Integer.parseInt(c.getCredit()));
			} else {
				gradeSum+=(0.0* Integer.parseInt(c.getCredit()));
			}
			
		}
		
		gradeSum /=MCSum;
		
		return (gradeSum);
	}
	
	
}
