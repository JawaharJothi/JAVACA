package data;

import java.util.ArrayList;

import model.CourseDTO;

public interface CourseDAO {

	ArrayList<CourseDTO> findAllCourse() throws DAOException;

	void insertCourse(CourseDTO course) throws DAOException;

	CourseDTO findOneCourse(CourseDTO course) throws DAOException;

	int updateCourse(CourseDTO course) throws DAOException;

	boolean deleteCourse(CourseDTO course) throws DAOException;

}