package model;

public class CourseGradeDTO {
	private String classID;
	private String courseName;
	private String credit;
	private String grade;
	public CourseGradeDTO(String classID, String courseName, String credit, String grade) {
		super();
		this.classID = classID;
		this.courseName = courseName;
		this.credit = credit;
		this.grade = grade;
	}
	public CourseGradeDTO() {
		super();
	}
	public String getClassID() {
		return classID;
	}
	public void setClassID(String classID) {
		this.classID = classID;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getCredit() {
		return credit;
	}
	public void setCredit(String credit) {
		this.credit = credit;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	
	
	
	
}
