package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.StudentDTO;
import service.LecProcessManager;
import service.StudentManager;

/**
 * Servlet implementation class ClassEnrollList
 */
@WebServlet("/classenrolllist")
public class ClassEnrollList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ClassEnrollList() {
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
		// TODO Auto-generated method stub
		int page = 1;
		int recordsPerPage = 3;
		if (request.getParameter("page") != null)
			page = Integer.parseInt(request.getParameter("page"));

		LecProcessManager lpm = new LecProcessManager();
		ArrayList<StudentDTO> slist = lpm.findenrollstudent(request.getParameter("id"), (page - 1) * recordsPerPage,
				recordsPerPage);
		
		int noOfRecords=lpm.getnoofrecord(request.getParameter("id"));
		int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
		
		request.setAttribute("students", slist);
		 request.setAttribute("noOfPages", noOfPages);
	        request.setAttribute("currentPage", page);
		RequestDispatcher rd = request.getRequestDispatcher("/view/ClassEnrollList.jsp");
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
