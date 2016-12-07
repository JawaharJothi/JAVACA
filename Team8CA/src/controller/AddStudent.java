package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.StudentDTO;
import service.StudentManager;

/**
 * Servlet implementation class AddStudent
 */
@WebServlet("/studentprocess")
public class AddStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddStudent() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		StudentManager sm = new StudentManager();
		StudentDTO sdto = new StudentDTO();
		sdto.setMatricno(request.getParameter("id"));
		sdto.setStudentname(request.getParameter("name"));
		sdto.setDateofbirth(request.getParameter("dob"));
		sdto.setPhone(Integer.parseInt(request.getParameter("phone")));
		sdto.setEmail(request.getParameter("email"));
		sdto.setAddress(request.getParameter("address"));
	
		sdto.setStatus(request.getParameter("status"));
		String ins = (String) request.getParameter("ins");
		if (ins.equalsIgnoreCase("true")) {
			
			sm.insertStudent(sdto);
		} else {
			
			sm.updateStudent(sdto);
		}
		ArrayList<StudentDTO> data = sm.findallStudents();
		request.setAttribute("students", data);
		RequestDispatcher rd = request.getRequestDispatcher("/view/Student.jsp");
		try {
			rd.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
