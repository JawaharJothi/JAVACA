package data;

import java.util.ArrayList;

import model.ClassDTO;

public interface ClassDAO {

	ArrayList<ClassDTO> findAllClass() throws DAOException;

	void insertClass(ClassDTO cls) throws DAOException;

	void DeleteClass(ClassDTO cls) throws DAOException;

	ClassDTO FindClass(String cid) throws DAOException;

	void UpdateClass(ClassDTO cls) throws DAOException;

}