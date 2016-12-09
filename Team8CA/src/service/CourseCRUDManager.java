package service;

import java.util.ArrayList;

import data.CourseDAO;
import data.DAOException;
import data.DaoFactory;
import model.CourseDTO;

public class CourseCRUDManager {
	private CourseDAO courseDAO;

	public CourseCRUDManager() {
		super();
		// TODO Auto-generated constructor stub
		courseDAO = DaoFactory.getCourseDAO();
	}
	
	public ArrayList<CourseDTO> findAllCourse() {
		ArrayList<CourseDTO> result = new ArrayList<CourseDTO>();
		try {
			result = courseDAO.findAllCourse();
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public CourseDTO findOneCourse(CourseDTO course) {
		CourseDTO c = new CourseDTO();
		try {
			c = courseDAO.findOneCourse(course);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;
	}
	
	public void insertCourse(CourseDTO course) {
		try {
			courseDAO.insertCourse(course);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int updateCourse(CourseDTO course) {
		int result = -1;
		try {
			result = courseDAO.updateCourse(course);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public boolean deleteCourse(CourseDTO course) {
		boolean result = false;
		try {
			result = courseDAO.deleteCourse(course);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
}














