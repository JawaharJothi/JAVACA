package data;

public class DaoFactory {

	public static UserDAO getUserDao() {
		UserDAO udao = new UserDAOImpl();
		return udao;
	}

	public static LecturerDAO getLecturerDao() {
		LecturerDAO ldao = new LecturerDAOImpl();
		return ldao;
	}

	public static LecProcessDAO getLecturerProcessDao() {
		LecProcessDAO lpdao = new LecProcessDAOImpl();
		return lpdao;
	}

	public static StudentDAO getStudentDao() {
		StudentDAO sdao = new StudentDAOImpl();
		return sdao;
	}

	public static StudentGradingDAO getStudentGradingDao() {
		StudentGradingDAO sgdao = new StudentGradingDAOImpl();
		return sgdao;
	}

	public static CourseGradeDAO getCourseGradeDAO() {
		return new CourseGradeDAOImpl();
	}

	public static StudentClassDAO getClassDAO() {

		return new StudentClassDAOImpl();
	}

	public static StudentEnrolmentDAO getStudentEnrolmentDAO() {
		StudentEnrolmentDAO sedao = new StudentEnrolmentDAOImpl();
		return sedao;

	}
}
