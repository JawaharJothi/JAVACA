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
		String path = "/view/StudentClass.jsp";
		
		
		ArrayList<ClassDTO> classList = null;
		
		ClassManager classManager = new ClassManager();
		
		classList = classManager.getUntakenClassesWithNumberEnrolled("E0090");
		
//		for(ClassDTO c: classList){
//			
//			System.out.println(c.getClassID());
//			System.out.println(c.getCourseName());
//			System.out.println(c.getStartDate());
//			System.out.println(c.getEndDate());
//			System.out.println(c.getCredit());
//			System.out.println(c.getClassSize());
//		}
//		
		
		
		request.setAttribute("classList", classList);
//		request.setAttribute("numberEnrolledList", numberEnrolledList);
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
		
		
	}
}
