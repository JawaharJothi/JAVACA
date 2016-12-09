package model;

public class ClassDTO {
	private String classID;
	private int classSize;
	private String startDate;
	private String endDate;
	private String credit;
	private String courseName;
	public ClassDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ClassDTO(String classID, int classSize, String startDate, String endDate, String credit, String courseName) {
		super();
		this.classID = classID;
		this.classSize = classSize;
		this.startDate = startDate;
		this.endDate = endDate;
		this.credit = credit;
		this.courseName = courseName;
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
	@Override
	public String toString() {
		return "ClassDTO [classID=" + classID + ", classSize=" + classSize + ", startDate=" + startDate + ", endDate="
				+ endDate + ", credit=" + credit + ", courseName=" + courseName + "]";
	}
	
}
