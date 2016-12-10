package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import data.DAOException;

import model.StudentClassDTO;
import model.User;
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

		//Retrieves User by using HTTPSession established
		User user = new User();
		user = (User)request.getSession().getAttribute("profile");
		
		//Creates new classManager service class to access list of available courses
		StudentClassManager classManager = new StudentClassManager();
		
		ArrayList<StudentClassDTO> classList = classManager.showClassList(user.getUserID());
		
		//stores in request so as to enable usage in forwarded jsp
		request.setAttribute("classList", classList);
		
		//creates a dispatcher and forwards to jsp page
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);

	}
}
