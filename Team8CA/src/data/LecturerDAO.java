package data;

import java.util.ArrayList;

import model.LecturerDTO;

public interface LecturerDAO {
	public ArrayList<LecturerDTO> findalllecturer() throws DAOException;
	public LecturerDTO findlecturer(String id) throws DAOException;
	public void insertlecturer(LecturerDTO ldto) throws DAOException;
	public void deletelecturer(LecturerDTO ldto) throws DAOException;
	public void updatelecturer(LecturerDTO ldto) throws DAOException;
}
