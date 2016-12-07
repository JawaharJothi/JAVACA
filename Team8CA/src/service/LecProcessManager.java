package service;

import java.util.ArrayList;

import data.DAOException;
import data.DaoFactory;
import data.LecProcessDAO;
import data.StudentGradingDAO;
import model.ClassCourseDTO;
import model.StudentGradingDTO;

public class LecProcessManager {
	private LecProcessDAO lecturerprocessDAO;
	private StudentGradingDAO studentgradingDAO;
	public LecProcessManager() {
		super();
		lecturerprocessDAO= DaoFactory.getLecturerProcessDao();
		studentgradingDAO=DaoFactory.getStudentGradingDao();
		// TODO Auto-generated constructor stub
	}


	
	@SuppressWarnings("finally")
	public ArrayList<ClassCourseDTO> findassignCourse(String id){
		ArrayList<ClassCourseDTO> clist = new ArrayList<ClassCourseDTO>();
		try {
			clist = lecturerprocessDAO.findassigncourse(id);
		} catch (DAOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			return clist;
		}
		
	}
	
	@SuppressWarnings("finally")
	public ArrayList<StudentGradingDTO> findstudentforgrade(String id){
		ArrayList<StudentGradingDTO> sgdlist= new ArrayList<StudentGradingDTO>();
		try {
			sgdlist = studentgradingDAO.findstudentlistforgrading(id);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			return sgdlist;
		}
		
	}

}
