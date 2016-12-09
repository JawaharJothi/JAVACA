package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CourseDTO;
import service.CourseCRUDManager;

/**
 * Servlet implementation class CourseCreate
 */
@WebServlet(description = "Admin role: Create a course", urlPatterns = { "/CourseCreate" })
public class CourseCreate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CourseCreate() {
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

	private void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CourseCRUDManager cMan = new CourseCRUDManager();
		CourseDTO c = new CourseDTO();
		c.setCourseName(request.getParameter("courseName"));
		c.setTypeOfCourse(request.getParameter("typeOfCourse"));
		c.setLecturerID(request.getParameter("lecturerID"));
		
		if(cMan.findOneCourse(c) != null){
			cMan.updateCourse(c);
		} 
		else{
			cMan.insertCourse(c);
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("/CourseLoad");
		rd.forward(request, response);
	}

}
