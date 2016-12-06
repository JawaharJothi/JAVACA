package model;

import java.util.Date;

public class LecturerDTO {
	private String lecturerid;
	private String lecturername;
	private String dob;
	private int phone;
	private String lectureraddress;
	private String email;
	private String degree;
	private String password;
	public LecturerDTO(String lecturerID, String lecturername, String dob, int phone, String lectureraddress,
			String email, String degree, String password) {
		super();
		this.lecturerid = lecturerID;
		this.lecturername = lecturername;
		this.dob = dob;
		this.phone = phone;
		this.lectureraddress = lectureraddress;
		this.email = email;
		this.degree = degree;
		this.password = password;
	}
	public String getLecturerID() {
		return lecturerid;
	}
	public void setLecturerID(String lecturerID) {
		this.lecturerid = lecturerID;
	}
	public String getLecturername() {
		return lecturername;
	}
	public void setLecturername(String lecturername) {
		this.lecturername = lecturername;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public String getLectureraddress() {
		return lectureraddress;
	}
	public void setLectureraddress(String lectureraddress) {
		this.lectureraddress = lectureraddress;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDegree() {
		return degree;
	}
	public void setDegree(String degree) {
		this.degree = degree;
	}
	public LecturerDTO() {
		super();
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}


}
