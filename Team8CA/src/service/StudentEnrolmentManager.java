package service;

import java.util.ArrayList;

import data.DAOException;
import data.DaoFactory;
import data.StudentEnrolmentDAO;
import model.StudentClassDTO;
import model.StudentEnrolmentDTO;

public class StudentEnrolmentManager {
	private StudentEnrolmentDAO StudentEnrolmentDAO;

	public StudentEnrolmentManager() {
		super();
		StudentEnrolmentDAO = DaoFactory.getStudentEnrolmentDAO();
	}

	public void addEnrollment(StudentEnrolmentDTO se) {
		try {
			StudentEnrolmentDAO.addEnrollment(se);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
