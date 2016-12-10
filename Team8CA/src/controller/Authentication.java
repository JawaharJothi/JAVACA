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

import exception.NotFoundException;
import model.User;
import service.UserService;

/**
 * Servlet implementation class Authentication
 */
@WebServlet("/Authentiation")
public class Authentication extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Authentication() {
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

		String u = request.getParameter("username");
		String p = request.getParameter("password");

		User user1 = new User();
		user1.setUserID(u);
		user1.setPassword(p);
		UserService service = new UserService();
		User user = new User();
		
		
		user = service.authenticate(user1);
		if(service.check(user1)){
			HttpSession session = request.getSession();
			session.setAttribute("profile", user);
			if(user.getRole().equalsIgnoreCase("administrator")){
				RequestDispatcher rd = request.getRequestDispatcher("/sload");
				rd.forward(request, response);
			}
			if(user.getRole().equalsIgnoreCase("lecturer")){
				RequestDispatcher rd = request.getRequestDispatcher("/loadlc");
				rd.forward(request, response);
			}
			
			if(user.getRole().equalsIgnoreCase("student")){
				RequestDispatcher rd = request.getRequestDispatcher("/loadclass");
				rd.forward(request, response);
			}
		}
		else{
			RequestDispatcher rd = request.getRequestDispatcher("/LogIn.jsp");
			rd.forward(request, response);
		}
		
		
		
		
	


	}
}
