package service;

import java.util.ArrayList;

import data.DAOException;
import data.DaoFactory;
import data.LecProcessDAO;
import data.StudentGradingDAO;
import model.ClassCourseDTO;
import model.StudentDTO;
import model.StudentGradingDTO;
import model.StudentPerformanceDTO;

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
	
	public void updatestudentgrading(String id, String grade, String cid){
		try {
			studentgradingDAO.updateStudentGrading(id, grade, cid);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("finally")
	public ArrayList<StudentPerformanceDTO> findstudentperformance(String id){
		ArrayList<StudentPerformanceDTO> splist= new ArrayList<StudentPerformanceDTO>();
		try {
			splist=lecturerprocessDAO.findsperformancelist(id);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			return splist;
		}
	}
	
	@SuppressWarnings("finally")
	public ArrayList<StudentDTO> findenrollstudent(String id, int offset, int noOfRecords){
		ArrayList<StudentDTO> slist = new ArrayList<StudentDTO>();
		try {
			slist = lecturerprocessDAO.findallstudents(id, offset, noOfRecords);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			return slist;
		}
	}
	
	@SuppressWarnings("finally")
	public int getnoofrecord(String id){
		int i=0;
		try {
			 i = lecturerprocessDAO.getNoOfRecords(id);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			return i;
		}
		
	}

}
