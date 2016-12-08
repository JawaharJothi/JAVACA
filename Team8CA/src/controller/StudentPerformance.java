package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import model.StudentPerformanceDTO;
import service.LecProcessManager;

/**
 * Servlet implementation class StudentPerformance
 */
@WebServlet("/sperformance")
public class StudentPerformance extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentPerformance() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
	}
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
			StudentPerformanceDTO sp=new StudentPerformanceDTO();
			LecProcessManager lpm = new LecProcessManager();
			ArrayList<StudentPerformanceDTO> splist = lpm.findstudentperformance(id);
			request.setAttribute("id", id);
			request.setAttribute("splist", splist);
			RequestDispatcher rd = request.getRequestDispatcher("/viewlecturer/StudentPerformance.jsp");
			rd.forward(request, response);
		
	}

}
