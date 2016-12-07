package service;


import java.util.ArrayList;

import data.ClassDAO;
import data.DaoFactory;
import model.ClassDTO;

public class ClassManager {
	private ClassDAO classDAO;

	public ClassManager() {
		super();
		classDAO = DaoFactory.getClassDAO();
	}
	
	private ArrayList<ClassDTO> getUntakenClasses(String matricNumber){
		return classDAO.getUntakenClasses(matricNumber);
	}

	public ArrayList<ClassDTO> getUntakenClassesWithNumberEnrolled(String matricNumber){
		return classDAO.getNumberEnrolled(classDAO.getUntakenClasses(matricNumber));
	}
	
	
	
}
