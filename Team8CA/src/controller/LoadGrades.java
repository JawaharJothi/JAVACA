package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import model.CourseGradeDTO;
import service.GradeManager;

/**
 * Servlet implementation class LoadGrades
 */
@WebServlet("/LoadGrades")
public class LoadGrades extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoadGrades() {
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
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = "/view/StudentGrades.jsp";
		GradeManager gradeManager = new GradeManager();
		
		ArrayList<CourseGradeDTO> courseGradeList = null;
		courseGradeList = gradeManager.findPastGrades("E0090");
		double CAP = 0;
		CAP = gradeManager.ComputeCAP("E0090");
		request.setAttribute("courseGradeList", courseGradeList);
		request.setAttribute("CAP", CAP);
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
		
		
	}

}
