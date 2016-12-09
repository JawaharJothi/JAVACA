package model;

public class ClassDTO {
	private String classID;
	private int classSize;
	private String startDate;
	private String endDate;
	private String credit;
	private String courseName;
	private int numberEnrolled;

	
	public ClassDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ClassDTO(String classID, int classSize, String startDate, String endDate, String credit, String courseName,
			int numberEnrolled){
		this.classID = classID;
		this.classSize = classSize;
		this.startDate = startDate;
		this.endDate = endDate;
		this.credit = credit;
		this.courseName = courseName;
		this.numberEnrolled = numberEnrolled;

	}

	public int getNumberEnrolled() {
		return numberEnrolled;
	}

	public void setNumberEnrolled(int numberEnrolled) {
		this.numberEnrolled = numberEnrolled;
	}



	public String getClassID() {
		return classID;
	}
	public void setClassID(String classID) {
		this.classID = classID;
	}
	public int getClassSize() {
		return classSize;
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
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	
}
