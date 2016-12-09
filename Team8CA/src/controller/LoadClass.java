package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.StudentClassDAO;
import data.StudentClassDAOImpl;
import data.DAOException;
import data.DaoFactory;
import model.StudentClassDTO;
import service.StudentClassManager;

/**
 * Servlet implementation class LoadClass
 */
@WebServlet("/LoadClass")
public class LoadClass extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoadClass() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			doProcess(request, response);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			doProcess(request, response);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, DAOException {
		String path = "/view/StudentClass.jsp";

		ArrayList<StudentClassDTO> classList = null;
		System.out.println("aaaaa");
		StudentClassManager classManager = new StudentClassManager();
		System.out.println("bbbb");
		ArrayList<StudentClassDTO> takenclass = new ArrayList<StudentClassDTO>();
		takenclass = classManager.gettakenclass("E0090");

		classList = classManager.checkCourse(classManager.getUntakenClassesWithNumberEnrolled("E0090"), takenclass);
		System.out.println("eeeee");
		 for(StudentClassDTO c: classList){
		
		 System.out.println(c.getClassID());
		 System.out.println(c.getCourseName());
		 System.out.println(c.getStartDate());
		 System.out.println(c.getEndDate());
		 System.out.println(c.getCredit());
		 System.out.println(c.getClassSize());
		 }
		

		request.setAttribute("classList", classList);
		// request.setAttribute("numberEnrolledList", numberEnrolledList);
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);

	}
}
