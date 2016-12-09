package data;

import model.StudentEnrolmentDTO;

public interface StudentEnrolmentDAO {

	void addEnrollment(StudentEnrolmentDTO se) throws DAOException;

}