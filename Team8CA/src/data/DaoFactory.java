package data;


public class DaoFactory {

	public static UserDAO getUserDao(){
		UserDAO udao = new UserDAOImpl();
		return udao;
	}
	
	public static LecturerDAO getLecturerDao(){
		LecturerDAO ldao = new LecturerDAOImpl();
		return ldao;
	}
	
	public static LecProcessDAO getLecturerProcessDao(){
		LecProcessDAO lpdao = new LecProcessDAOImpl();
		return lpdao;
	}
	public static StudentDAO getStudentDao(){
		StudentDAO sdao = new StudentDAOImpl();
		return sdao;
	}
	
	public static StudentGradingDAO getStudentGradingDao(){
		StudentGradingDAO sgdao= new StudentGradingDAOImpl();
		return sgdao;
	}

}
