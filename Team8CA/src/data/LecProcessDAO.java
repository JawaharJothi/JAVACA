package data;

import java.util.ArrayList;

import model.ClassCourseDTO;
import model.StudentDTO;
import model.StudentPerformanceDTO;


public interface LecProcessDAO {
	public ArrayList<ClassCourseDTO> findassigncourse(String id) throws DAOException;
	public ArrayList<StudentPerformanceDTO> findsperformancelist(String id) throws DAOException;
	public ArrayList<StudentDTO> findallstudents(String id) throws DAOException;
}
