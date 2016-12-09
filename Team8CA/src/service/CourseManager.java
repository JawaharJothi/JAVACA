package service;

import java.util.ArrayList;

import data.CourseDAO;
import data.DAOException;
import data.DaoFactory;
import model.CourseDTO;

public class CourseManager {
	private CourseDAO courseDAO;

	public CourseManager() {
		courseDAO = DaoFactory.getCourseDAO();
	}

	public ArrayList<CourseDTO> findAllCourse() {
		
			ArrayList<CourseDTO> clst = new ArrayList<CourseDTO>();
			try {
				clst = courseDAO.findAllCourse();
			} catch (DAOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return clst;
		
		
	}
	
	

}
