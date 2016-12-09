package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.ClassDAO;
import data.DaoFactory;
import model.ClassDTO;
import service.ClassManager;


/**
 * Servlet implementation class LoadClass
 */
@WebServlet("/LoadClassEnrolled")
public class LoadClassEnrolled extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoadClassEnrolled() {
        super();
        // TODO Auto-generated constructor stub
    }

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
		String path = "/view/StudentClassEnrolled.jsp";
		
		System.out.println("ss");
		ArrayList<ClassDTO> classList = null;
		
		ClassManager classManager = new ClassManager();
		
		classList = classManager.getClassesWithNumberEnrolled("E0080");
		
		request.setAttribute("classList", classList);
		
		RequestDispatcher rd = request.getRequestDispatcher(path);
		
		rd.forward(request, response);
		
		
	}
}
