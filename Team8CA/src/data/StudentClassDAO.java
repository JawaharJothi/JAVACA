package data;

import java.util.ArrayList;

import model.StudentClassDTO;

public interface StudentClassDAO {

	public ArrayList<StudentClassDTO> getUntakenClasses(String matricNumber) throws DAOException;
	
	public ArrayList<StudentClassDTO> getNumberEnrolled(ArrayList<StudentClassDTO> classList)throws DAOException;
	
	public ArrayList<StudentClassDTO> gettakenClasses(String matricNumber) throws DAOException;
	
	
}