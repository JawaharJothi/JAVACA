package data;

import java.util.ArrayList;


import model.CourseGradeDTO;

public interface CourseGradeDAO {

	ArrayList<CourseGradeDTO> findPastGrades(String matricNumber);
	

}