package data;

import java.util.ArrayList;

import model.ClassCourseDTO;
import model.StudentPerformanceDTO;


public interface LecProcessDAO {
	public ArrayList<ClassCourseDTO> findassigncourse(String id) throws DAOException;
	public ArrayList<StudentPerformanceDTO> findsperformancelist(String id) throws DAOException;
}
