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
import service.StudentManager;

/**
 * Servlet implementation class AddStudent
 */
@WebServlet("/studentprocess")
public class AddStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddStudent() {
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
		RequestDispatcher rd =null;
		StudentManager sm = new StudentManager();
		StudentDTO sdto = new StudentDTO();
		sdto.setMatricno(request.getParameter("id"));
		sdto.setStudentname(request.getParameter("name"));
		sdto.setDateofbirth(request.getParameter("dob"));
		sdto.setPhone(Integer.parseInt(request.getParameter("phone")));
		sdto.setEmail(request.getParameter("email"));
		sdto.setAddress(request.getParameter("address"));
		sdto.setPassword(request.getParameter("password"));
	
		sdto.setStatus(request.getParameter("status"));
		String ins = (String) request.getParameter("ins");
		if (ins.equalsIgnoreCase("true")) {
			request.setAttribute("id", request.getParameter("id"));
			request.setAttribute("name", request.getParameter("name"));
			request.setAttribute("password", request.getParameter("password"));
			request.setAttribute("email", request.getParameter("email"));
			rd = request.getRequestDispatcher("/view/Email.jsp");
			sm.insertStudent(sdto);
		} else {
			
			sm.updateStudent(sdto);
			int page = 1;
			int recordsPerPage = 8;
			if (request.getParameter("page") != null){
				page = Integer.parseInt(request.getParameter("page"));
			}
			else{
				page =1;
			}
			ArrayList<StudentDTO> slist = sm.findallStudents( (page - 1) * recordsPerPage,
					recordsPerPage);
			int noOfRecords = sm.gtnoofrecord();
			int noOfPages = (int) Math.ceil(noOfRecords*1.0/recordsPerPage);
			request.setAttribute("students", slist);
			request.setAttribute("noOfPages", noOfPages);
			request.setAttribute("currentPage", page);

			rd = request.getRequestDispatcher("/view/Student.jsp");
		}
		
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
