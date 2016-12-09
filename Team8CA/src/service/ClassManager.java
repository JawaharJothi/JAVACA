package service;


import java.util.ArrayList;

import org.omg.PortableServer.ThreadPolicyOperations;

import data.StudentClassDAO;
import data.DAOException;
import data.DaoFactory;
import model.StudentClassDTO;

public class ClassManager {
	private StudentClassDAO classDAO;

	public ClassManager() {
		super();
		classDAO = DaoFactory.getClassDAO();
	}
	
	private ArrayList<StudentClassDTO> getUntakenClasses(String matricNumber) throws DAOException{
		return classDAO.getUntakenClasses(matricNumber);
	}

	public ArrayList<StudentClassDTO> getUntakenClassesWithNumberEnrolled(String matricNumber) throws DAOException{
		return classDAO.getNumberEnrolled(classDAO.getUntakenClasses(matricNumber));
	}
	public ArrayList<StudentClassDTO> gettakenclass(String matricNumber) throws DAOException{
		ArrayList<StudentClassDTO> taken = new ArrayList<StudentClassDTO>();
		
		return classDAO.getNumberEnrolled(classDAO.getUntakenClasses(matricNumber)) ;
	}
	
	
	public ArrayList<StudentClassDTO> gettakenClasses(String matricNumber) throws DAOException{
		ArrayList<StudentClassDTO> classlist = new ArrayList<StudentClassDTO>();
		classlist = classDAO.gettakenClasses(matricNumber);
		return classlist;
	}
	
	public ArrayList<StudentClassDTO> checkCourse(ArrayList<StudentClassDTO> list, ArrayList<StudentClassDTO> classTakenlist) {
		System.out.println("zzzzz");
		ArrayList<StudentClassDTO> newList = new ArrayList<StudentClassDTO>();
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getNumberEnrolled() < list.get(i).getClassSize()) {
				if(classTakenlist.size() == 0) {
					newList.add(list.get(i));
				}
				for(int j = 0; j < classTakenlist.size(); j++) {
					if(classTakenlist.get(j).getStartDate().after(list.get(i).getEndDate()) || classTakenlist.get(j).getEndDate().before(list.get(i).getStartDate())) {
						newList.add(list.get(i));
					}
				}
			}
		}
		
		return newList;
		
	}
	
}
