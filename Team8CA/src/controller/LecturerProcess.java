package controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import model.LecturerDTO;
import service.LecturerManager;

/**
 * Servlet implementation class LecturerProcess
 */
@WebServlet("/lecturerprocess")
public class LecturerProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LecturerProcess() {
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
		RequestDispatcher rd=null;
		LecturerManager lm = new LecturerManager();
		LecturerDTO lecturer = new LecturerDTO();
		lecturer.setLecturerID(request.getParameter("id"));
		lecturer.setLecturername(request.getParameter("name"));
		lecturer.setDob(request.getParameter("dob"));
		lecturer.setPhone(Integer.parseInt(request.getParameter("phone")));
		lecturer.setEmail(request.getParameter("email"));
		lecturer.setLectureraddress(request.getParameter("address"));
		lecturer.setDegree(request.getParameter("edu"));
		lecturer.setPassword(request.getParameter("password"));
		String ins = (String) request.getParameter("ins");
		if (ins.equalsIgnoreCase("true")) {
			lm.inserLecturer(lecturer);
			request.setAttribute("id", request.getParameter("id"));
			request.setAttribute("name", request.getParameter("name"));
			request.setAttribute("password", request.getParameter("password"));
			request.setAttribute("email", request.getParameter("email"));
			rd = request.getRequestDispatcher("/view/Email.jsp");
		} else {
			lm.updateLecturer(lecturer);
			ArrayList<LecturerDTO> data = lm.findallLecturer();
			request.setAttribute("lecturers", data);
			rd = request.getRequestDispatcher("/view/Lecturer.jsp");
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
