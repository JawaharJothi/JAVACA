package model;

public class ClassCourseDTO {
	private String classID;
	private int classSize;
	private String startDate;
	private String courseName;
	private String endDate;
	private String credit;
	public String getClassID() {
		return classID;
	}
	public void setClassID(String classID) {
		this.classID = classID;
	}
	public int getClassSize() {
		return classSize;
	}
	public ClassCourseDTO() {
		super();
	}
	public void setClassSize(int classSize) {
		this.classSize = classSize;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getCredit() {
		return credit;
	}
	public void setCredit(String credit) {
		this.credit = credit;
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

	private String typeOfCourse;
	private String lecturerID;
	public ClassCourseDTO(String classID, int classSize, String startDate, String courseName, String endDate,
			String credit, String typeOfCourse, String lecturerID) {
		super();
		this.classID = classID;
		this.classSize = classSize;
		this.startDate = startDate;
		this.courseName = courseName;
		this.endDate = endDate;
		this.credit = credit;
		this.typeOfCourse = typeOfCourse;
		this.lecturerID = lecturerID;
	}
}
