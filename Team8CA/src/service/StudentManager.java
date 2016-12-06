package service;

import java.util.ArrayList;

import data.DaoFactory;
import data.StudentDAO;
import model.LecturerDTO;
import model.StudentDTO;

public class StudentManager {

	private StudentDAO studentDAO;

	public StudentManager() {
		super();
		studentDAO = DaoFactory.getStudentDao();
	}
	
	@SuppressWarnings("finally")
	public ArrayList<StudentDTO> findallLecturer(){
		ArrayList<StudentDTO> slist = new ArrayList<StudentDTO>();
		try {
			slist = studentDAO.findallstudents();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			return slist;
		}
		
	}
}
