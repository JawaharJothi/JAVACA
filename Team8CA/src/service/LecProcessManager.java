package service;

import java.util.ArrayList;

import data.DAOException;
import data.DaoFactory;
import data.LecProcessDAO;
import model.ClassCourseDTO;

public class LecProcessManager {
	private LecProcessDAO lecturerprocessDAO;
	public LecProcessManager() {
		super();
		lecturerprocessDAO= DaoFactory.getLecturerProcessDao();
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

}
