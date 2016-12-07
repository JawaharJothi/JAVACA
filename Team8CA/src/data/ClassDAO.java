package data;

import java.util.ArrayList;

import model.ClassDTO;

public interface ClassDAO {

	ArrayList<ClassDTO> getUntakenClasses(String matricNumber);
	
	ArrayList<ClassDTO> getNumberEnrolled(ArrayList<ClassDTO> classList);
}