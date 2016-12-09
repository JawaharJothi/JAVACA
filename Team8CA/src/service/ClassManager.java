package service;

import java.util.ArrayList;

import data.ClassDAO;
import data.DAOException;
import data.DaoFactory;
import model.ClassDTO;

public class ClassManager {
	private ClassDAO classDAO;

	public ClassManager() {
		classDAO = DaoFactory.getClassDao();
	}

	public ArrayList<ClassDTO> findAllClass() {
		
			ArrayList<ClassDTO> clst = new ArrayList<ClassDTO>();
			try {
				clst = classDAO.findAllClass();
			} catch (DAOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return clst;
		
		
	}
	public void insertClass(ClassDTO cls) {
		try {
			classDAO.insertClass(cls);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void DeleteClass(ClassDTO cls) {
		try {
			classDAO.DeleteClass(cls);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public ClassDTO FindClass(String cid) {
		ClassDTO cto = new ClassDTO();
		try {
			cto = classDAO.FindClass(cid);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cto;
	}
	public void UpdateClass(ClassDTO cls){
		try {
			classDAO.UpdateClass(cls);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ArrayList<ClassDTO> getClassesWithNumberEnrolled(String matricNumber){
		System.out.println("mmmmddd");
		return classDAO.getClassesEnrolled(matricNumber);
	}
}
