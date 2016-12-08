package model;

import java.sql.Date;

public class StudentPerformanceDTO {
	private String matricno;
	private String studentname;
	private String email;
	private String classID;
	private String courseName;
	private String startDate;
	private String endDate;
	private String credit;
	private String Grade;
	public String getMatricno() {
		return matricno;
	}
	public void setMatricno(String matricno) {
		this.matricno = matricno;
	}
	public String getStudentname() {
		return studentname;
	}
	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
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
	public String getGrade() {
		return Grade;
	}
	public void setGrade(String grade) {
		Grade = grade;
	}
	public StudentPerformanceDTO(String matricno, String studentname, String email, String classID, String courseName,
			String startDate, String endDate, String credit, String grade) {
		super();
		this.matricno = matricno;
		this.studentname = studentname;
		this.email = email;
		this.classID = classID;
		this.courseName = courseName;
		this.startDate = startDate;
		this.endDate = endDate;
		this.credit = credit;
		Grade = grade;
	}
	public StudentPerformanceDTO() {
		super();
	}
	
	

}
