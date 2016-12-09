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
import model.StudentDTO;
import service.StudentManager;

/**
 * Servlet implementation class StudentLoad
 */
@WebServlet("/sload")
public class StudentLoad extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentLoad() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    int page = 1;
    int recordsPerPage = 10;
  
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			doProcess(request, response);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			doProcess(request, response);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, DAOException {

int page = 1;
		int recordsPerPage = 8;
		if (request.getParameter("page") != null)
			page = Integer.parseInt(request.getParameter("page"));
		
		StudentManager sm = new StudentManager();
		ArrayList<StudentDTO> slist = sm.findallStudents( (page - 1) * recordsPerPage,
				recordsPerPage);
		int noOfRecords = sm.gtnoofrecord();
		int noOfPages = (int) Math.ceil(noOfRecords*1.0/recordsPerPage);
		request.setAttribute("students", slist);
		request.setAttribute("noOfPages", noOfPages);
		request.setAttribute("currentPage", page);
		
		RequestDispatcher rd = request.getRequestDispatcher("/view/Student.jsp");
		try {
			rd.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (request.getParameter("page") != null)
			page = Integer.parseInt(request.getParameter("page"));
		

	}

}
