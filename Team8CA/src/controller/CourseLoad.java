package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.CourseDTO;
import model.LecturerDTO;
import service.CourseCRUDManager;
import service.LecturerManager;

/**
 * Servlet implementation class CourseLoad
 */
@WebServlet(description = "Admin role: course CRUD homepage", urlPatterns = { "/CourseLoad" })
public class CourseLoad extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CourseLoad() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CourseCRUDManager cMan = new CourseCRUDManager();
		ArrayList<CourseDTO> cList = new ArrayList<CourseDTO>();
		cList = cMan.findAllCourse();
		
		LecturerManager lMan = new LecturerManager();
		ArrayList<LecturerDTO> lecturerList = new ArrayList<LecturerDTO>();
		lecturerList = lMan .findallLecturer();
				
		HttpSession session=request.getSession();   
		request.setAttribute("courseList", cList);
		session.setAttribute("lecturerList", lecturerList);
		RequestDispatcher rd = request.getRequestDispatcher("/view/CourseCRUD.jsp");
		rd.forward(request, response);
	}

}
