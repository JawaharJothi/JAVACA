package model;

import java.util.Date;

public class StudentDTO {
	private String matricno;
	private String studentname;
	private String dateofbirth;
	private int phone;
	private String address;
	private String email;
	private String image;
	private String status;
	private String password;
	private int page;

	public int getPage() {
		return page;
	}



	public void setPage(int page) {
		this.page = page;
	}



	public StudentDTO(String matricno, String studentname, String dateofbirth, int phone, String address,
			String email, String image, String status,String password) {
		super();
		this.matricno = matricno;
		this.studentname = studentname;
		this.dateofbirth = dateofbirth;
		this.phone = phone;
		this.address = address;
		this.email = email;
		this.image = image;
		this.status = status;
		this.password = password;
	}
	
	

	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public StudentDTO() {
		super();
	}

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

	public String getDateofbirth() {
		return dateofbirth;
	}

	public void setDateofbirth(String dateofbirth) {
		this.dateofbirth = dateofbirth;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	

}
