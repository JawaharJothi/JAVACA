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
import model.ClassDTO;
import service.ClassManager;

/**
 * Servlet implementation class ClassProcess
 */
@WebServlet("/classprocess")
public class ClassProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ClassProcess() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response) {
		ClassManager cm = new ClassManager();
		ClassDTO cto = new ClassDTO();
		cto.setClassID(request.getParameter("id"));
		cto.setClassSize(Integer.parseInt((request.getParameter("size")).trim()));
		cto.setStartDate(request.getParameter("sdate"));
		cto.setEndDate(request.getParameter("edate"));
		cto.setCredit(request.getParameter("credit"));
		cto.setCourseName(request.getParameter("cbClassID"));
		String ins = request.getParameter("ins");
		if (ins.equalsIgnoreCase("true")) {
			cm.insertClass(cto);
		} else {
			cm.UpdateClass(cto);
		}
		ArrayList<ClassDTO> cls = new ArrayList<ClassDTO>();
		cls = cm.findAllClass();
		request.setAttribute("classes", cls);
		RequestDispatcher rd = request.getRequestDispatcher("/view/Class.jsp");
		try {
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
