package data;

import java.util.ArrayList;


import model.StudentGradingDTO;

public interface StudentGradingDAO {
	
	public ArrayList<StudentGradingDTO> findstudentlistforgrading(String id) throws DAOException;
	public void updateStudentGrading(String id, String grade, String cid) throws DAOException;

}
