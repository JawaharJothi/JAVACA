package service;

import java.util.ArrayList;

import data.DAOException;
import data.DaoFactory;
import data.LecturerDAO;
import model.LecturerDTO;

public class LecturerManager {
	private LecturerDAO lecturerDAO;


	public LecturerManager() {
		super();
		lecturerDAO = DaoFactory.getLecturerDao();
	}
	
	@SuppressWarnings("finally")
	public ArrayList<LecturerDTO> findallLecturer(){
		ArrayList<LecturerDTO> list = new ArrayList<LecturerDTO>();
		try {
			list = lecturerDAO.findalllecturer();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			return list;
		}
		
	}
	
	public void inserLecturer(LecturerDTO lecturer) {
    	try {
    		lecturerDAO.insertlecturer(lecturer);
		} catch (data.DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	
	public void updateLecturer(LecturerDTO lecturer){
		try {
			lecturerDAO.updatelecturer(lecturer);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void deleteLecturer(LecturerDTO lecturer){
		try {
			lecturerDAO.deletelecturer(lecturer);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("finally")
	public LecturerDTO findlecturer(String id){
		LecturerDTO ldto = new LecturerDTO();
		try {
			ldto= lecturerDAO.findlecturer(id);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			return ldto;
		}
	}
	
	
}
