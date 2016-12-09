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

import model.ClassDTO;
import model.CourseDTO;
import service.ClassManager;
import service.CourseManager;

/**
 * Servlet implementation class ClassLoad
 */
@WebServlet("/CLoad")
public class ClassLoad extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClassLoad() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response) {
		ClassManager cm = new ClassManager();
		CourseManager com = new CourseManager();
		ArrayList<ClassDTO> clsArr = new ArrayList<ClassDTO>();
		ArrayList<CourseDTO> couArr = new ArrayList<CourseDTO>();
		couArr = com.findAllCourse();
		for(CourseDTO course : couArr)
			System.out.println(course);
		clsArr = cm.findAllClass();
		HttpSession session = request.getSession();
		session.setAttribute("courses", couArr);
		request.setAttribute("classes", clsArr);
		RequestDispatcher rd = request.getRequestDispatcher("/view/Class.jsp");
		try {
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
