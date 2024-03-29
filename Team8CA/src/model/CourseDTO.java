package model;

import java.io.Serializable;

public class CourseDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/*Attributes*/
	private String courseName;
	private String typeOfCourse;
	private String lecturerID;
	private String lecturerName;
	public String getLecturerName() {
		return lecturerName;
	}
	public void setLecturerName(String lecturerName) {
		this.lecturerName = lecturerName;
	}
	/*Constructors*/
	public CourseDTO() {
		super();
	}

	public CourseDTO(String courseName, String typeOfCourse, String lecturerID, String lecturerName) {
		super();
		this.courseName = courseName;
		this.typeOfCourse = typeOfCourse;
		this.lecturerID = lecturerID;
		this.lecturerName = lecturerName;
	}
	/*getters & setters*/
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getTypeOfCourse() {
		return typeOfCourse;
	}
	public void setTypeOfCourse(String typeOfCourse) {
		this.typeOfCourse = typeOfCourse;
	}
	public String getLecturerID() {
		return lecturerID;
	}
	public void setLecturerID(String lecturerID) {
		this.lecturerID = lecturerID;
	}
	/*toString method*/
	@Override
	public String toString() {
		return "CourseDTO [courseName=" + courseName + ", typeOfCourse=" + typeOfCourse + ", lecturerID=" + lecturerID
				+ "]";
	}
	
	
}
