package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.StudentClassDAOImpl;
import data.DAOException;
import model.StudentClassDTO;
import model.StudentEnrolmentDTO;
import service.StudentClassManager;
import service.StudentEnrolmentManager;
import service.StudentManager;

/**
 * Servlet implementation class StudentEnrollment
 */
@WebServlet("/StudentEnrolment")
public class StudentEnrolment extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public StudentEnrolment() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("11111111");
		StudentEnrolmentDTO sed=new StudentEnrolmentDTO();
		sed.setClassid(request.getParameter("id"));
		sed.setMatricnumber("E0090");
		
		StudentEnrolmentManager sem = new StudentEnrolmentManager();
		sem.addEnrollment(sed);
		
		ArrayList<StudentClassDTO> classList = null;
		StudentClassManager classManager = new StudentClassManager();
		try {
			classList = classManager.checkCourse(classManager.getUntakenClassesWithNumberEnrolled("E0090"), new StudentClassDAOImpl().gettakenClasses("E0090"));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("classList", classList);
		String path = "/view/StudentClass.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}
}
