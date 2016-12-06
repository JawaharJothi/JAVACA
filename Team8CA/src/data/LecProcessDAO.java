package data;

import java.util.ArrayList;

import model.ClassCourseDTO;


public interface LecProcessDAO {
	public ArrayList<ClassCourseDTO> findassigncourse(String id) throws DAOException;
}
