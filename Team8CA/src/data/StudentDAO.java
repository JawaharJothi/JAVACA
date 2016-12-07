package data;

import java.util.ArrayList;

import model.LecturerDTO;
import model.StudentDTO;

public interface StudentDAO {
	public ArrayList<StudentDTO> findallstudents() throws DAOException;

	public StudentDTO findstudent(String id) throws DAOException;
		// TODO Auto-generated method stub

	public void insertStudent(StudentDTO sdto) throws DAOException;

	public void deletestudent(StudentDTO sdto) throws DAOException;

	public void updatestudent(StudentDTO sdto) throws DAOException;

	public StudentDTO findallstudents(String matric);

	

}
