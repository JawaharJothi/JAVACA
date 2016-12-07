package model;

import java.sql.Date;

public class ClassDTO {
	private String classID;
	private String courseName;
	private Date startDate;
	private Date endDate;
	private String credit;
	private int classSize;
	private int numberEnrolled;
	
	
	
	public int getNumberEnrolled() {
		return numberEnrolled;
	}


	public void setNumberEnrolled(int numberEnrolled) {
		this.numberEnrolled = numberEnrolled;
	}


	public ClassDTO() {
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
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getCredit() {
		return credit;
	}
	public void setCredit(String credit) {
		this.credit = credit;
	}
	public int getClassSize() {
		return classSize;
	}
	public void setClassSize(int classSize) {
		this.classSize = classSize;
	}
	
	
	
}
