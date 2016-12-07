package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ClassCourseDTO;
import model.StudentGradingDTO;
import model.User;
import service.LecProcessManager;

/**
 * Servlet implementation class UpdateGrade
 */
@WebServlet("/updategrade")
public class UpdateGrade extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateGrade() {
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

		LecProcessManager lpmn=new LecProcessManager();
		ArrayList<StudentGradingDTO> slist = lpmn.findstudentforgrade(request.getParameter("cbClassID"));
		User user = new User();
		user = (User)request.getSession().getAttribute("profile");
		request.setAttribute("slists", slist);
		ArrayList<ClassCourseDTO> list = lpmn.findassignCourse(user.getUserID());
		request.setAttribute("courses", list);
		RequestDispatcher rd = request.getRequestDispatcher("/viewlecturer/StudentGrading.jsp");
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
