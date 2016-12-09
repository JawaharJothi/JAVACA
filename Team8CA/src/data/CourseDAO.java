package data;

import java.util.ArrayList;

import model.CourseDTO;

public interface CourseDAO {

	ArrayList<CourseDTO> findAllCourse() throws DAOException;

	void insertCourse(CourseDTO course) throws DAOException;

	

}