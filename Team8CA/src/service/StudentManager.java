package service;

import java.util.ArrayList;

import com.sun.xml.internal.messaging.saaj.util.FinalArrayList;

import data.DAOException;
import data.DaoFactory;
import data.StudentDAO;
import model.StudentDTO;

public class StudentManager {

	private StudentDAO studentDAO;

	public StudentManager() {
		super();
		studentDAO = DaoFactory.getStudentDao();
	}

	@SuppressWarnings("finally")
	public ArrayList<StudentDTO> findallStudents( int offset, int noOfRecords) {
		ArrayList<StudentDTO> slist = new ArrayList<StudentDTO>();
		try {
			slist = studentDAO.findallstudents( offset, noOfRecords);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			return slist;
		}

	}

	public void insertStudent(StudentDTO sdto) {
		try {
			studentDAO.insertStudent(sdto);
		} catch (data.DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void updateStudent(StudentDTO sdto) {
		try {
			studentDAO.updatestudent(sdto);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void deletestudent(StudentDTO sdto) {
		// TODO Auto-generated method stub
		try {
			System.out.println(sdto.getMatricno());
			studentDAO.deletestudent(sdto);
			
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}




	@SuppressWarnings("finally")
	public StudentDTO findstudent(String matric) {
		// TODO Auto-generated method stub
		StudentDTO sdto = new StudentDTO();
		try {
			
			sdto=studentDAO.findstudent(matric);
			
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			return sdto;
		}
	}
	
	@SuppressWarnings("finally")
	public int gtnoofrecord(){
		int i =0;
		try {
			i = studentDAO.getNoOfRecords();
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			return i;
		}
	}
}
