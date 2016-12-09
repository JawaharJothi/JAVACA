package model;

public class StudentEnrolmentDTO {
	private String matricnumber,classid,grade,status;

	public StudentEnrolmentDTO() {
		super();
	}

	public StudentEnrolmentDTO(String matricnumber, String classid, String grade, String status) {
		super();
		this.matricnumber = matricnumber;
		this.classid = classid;
		this.grade = grade;
		this.status = status;
	}

	public String getMatricnumber() {
		return matricnumber;
	}

	public void setMatricnumber(String matricnumber) {
		this.matricnumber = matricnumber;
	}

	public String getClassid() {
		return classid;
	}

	public void setClassid(String classid) {
		this.classid = classid;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "StudentEnrollmentDTO [matricnumber=" + matricnumber + ", classid=" + classid + ", grade=" + grade
				+ ", status=" + status + "]";
	}
	

}
