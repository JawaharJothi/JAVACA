package data;

import java.util.ArrayList;

import model.LecturerDTO;
import model.StudentDTO;

public interface StudentDAO {


	public StudentDTO findstudent(String id) throws DAOException;
		// TODO Auto-generated method stub

	public void insertStudent(StudentDTO sdto) throws DAOException;

	public void deletestudent(StudentDTO sdto) throws DAOException;

	public void updatestudent(StudentDTO sdto) throws DAOException;

	public ArrayList<StudentDTO> findallstudents( int offset, int noOfRecords) throws DAOException;

	public int getNoOfRecords() throws DAOException;

	

}
