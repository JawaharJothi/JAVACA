package model;

public class StudentGradingDTO {
	private String matricNumber;
	private String studentName;
	private String startDate;
	private String endDate;
	private String Grade;
	private String courseName;
	public String getMatricNumber() {
		return matricNumber;
	}
	public void setMatricNumber(String matricNumber) {
		this.matricNumber = matricNumber;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
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
	public String getGrade() {
		return Grade;
	}
	public void setGrade(String grade) {
		Grade = grade;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public StudentGradingDTO() {
		super();
	}
	public StudentGradingDTO(String matricNumber, String studentName, String startDate, String endDate, String grade,
			String courseName) {
		super();
		this.matricNumber = matricNumber;
		this.studentName = studentName;
		this.startDate = startDate;
		this.endDate = endDate;
		Grade = grade;
		this.courseName = courseName;
	}

}
