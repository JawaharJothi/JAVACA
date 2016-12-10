package service;

import java.util.ArrayList;

import org.omg.PortableServer.ThreadPolicyOperations;

import data.StudentClassDAO;
import data.DAOException;
import data.DaoFactory;
import model.StudentClassDTO;

public class StudentClassManager {
	private StudentClassDAO classDAO;

	public StudentClassManager() {
		super();
		classDAO = DaoFactory.getClassDAO();
	}



	//this refers to classes to all that are not completed, this suggests that enrolled classes would still be included
	public ArrayList<StudentClassDTO> getUntakenClassesWithNumberEnrolled(String matricNumber) throws DAOException {
		return removeFullClasses(classDAO.getNumberEnrolled(classDAO.getUntakenClasses(matricNumber))) ;
				
	}
	
	
	//this method removes classes that are full
	public ArrayList<StudentClassDTO> removeFullClasses(ArrayList<StudentClassDTO> classList){
		ArrayList<StudentClassDTO> newList = new ArrayList<StudentClassDTO>();
		
		for(StudentClassDTO s:classList){
			if(s.getNumberEnrolled()<s.getClassSize()){
				newList.add(s);
			}
		}
		return newList;
		
	}

	
	
	public ArrayList<StudentClassDTO> getEnrolledClasses(String matricNumber) throws DAOException {
		return classDAO.gettakenClasses(matricNumber);
	}

	
	public ArrayList<StudentClassDTO> showClassList(String matricNumber){
		ArrayList<StudentClassDTO> newList = new ArrayList<StudentClassDTO>();
		ArrayList<StudentClassDTO> enrolledClasses=null;
		ArrayList<StudentClassDTO> untakenClasses=null;
		try {
			enrolledClasses = getEnrolledClasses(matricNumber);
//			for(StudentClassDTO s:enrolledClasses){
//				System.out.println(s.getClassID());
//			}
			
//			System.out.println(enrolledClasses.get(0).getStartDate());
//			System.out.println(enrolledClasses.get(0).getEndDate());
//			
//			
//			System.out.println("start date before end date:"+ (enrolledClasses.get(0).getStartDate().before(enrolledClasses.get(0).getEndDate())));
//			System.out.println("End Date After start date:"+ (enrolledClasses.get(0).getEndDate().after(enrolledClasses.get(0).getStartDate())));
//			System.out.println("start date After end date:"+ (enrolledClasses.get(0).getStartDate().after(enrolledClasses.get(0).getEndDate())));
			
			
		} catch (DAOException e) {
			e.printStackTrace();
		}
		try {
			untakenClasses=getUntakenClassesWithNumberEnrolled(matricNumber);
//			for(StudentClassDTO s:untakenClasses){
//				System.out.println(s.getClassID());
//			}
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		for(StudentClassDTO i:untakenClasses){
			Boolean addTo = true;
			for(StudentClassDTO j:enrolledClasses){
				
				System.out.println("Untaken ClassID:"+ i.getClassID());
				System.out.println("Untaken Start Date:"+i.getStartDate());
				System.out.println("Untaken End Date:"+i.getEndDate());
				System.out.println("Enrolled Start Date:"+j.getStartDate());
				System.out.println("Enrolled End Date:"+j.getEndDate());
				System.out.println("Untaken start before Enrolled End:"+ i.getStartDate().before(j.getEndDate()));
				System.out.println("Untaken End after taken Start:"+i.getEndDate().after(j.getStartDate()));
				if(((i.getStartDate().before(j.getEndDate())&&i.getStartDate().after(j.getStartDate()))||(i.getEndDate().after(j.getStartDate())&&i.getEndDate().before(j.getEndDate())))||(i.getStartDate().before(j.getStartDate())&&i.getEndDate().after(j.getEndDate()))){
					addTo=false;
				}

			}
			if(addTo==true){
				newList.add(i);
			}
			
		}
		return newList;
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
//	public ArrayList<StudentClassDTO> checkCourse(ArrayList<StudentClassDTO> list,
//			ArrayList<StudentClassDTO> classTakenlist) {
//		
//		ArrayList<StudentClassDTO> newList = new ArrayList<StudentClassDTO>();
//		
//		
//
//		System.out.println("!!this is class taken lsit size"+classTakenlist.size());
//		
//		for (int i = 0; i < list.size(); i++) {
//			System.out.println("this is class"+list.get(i).getClassID());
//			
//			Boolean addTo=true;
//			System.out.println("Start date of i's"+list.get(i).getStartDate());
//			System.out.println("End date of i's"+list.get(i).getEndDate());
//			for (int j = 0; j < classTakenlist.size(); j++) {
//				System.out.println("Start date of j's"+classTakenlist.get(j).getStartDate());
//				System.out.println("End date of j's"+classTakenlist.get(j).getEndDate());
//				if(list.get(i).getStartDate().before(classTakenlist.get(j).getEndDate())||list.get(i).getEndDate().after(classTakenlist.get(j).getStartDate())){
//					
//					addTo = false;
//
//				}
//			}
//			if(addTo==true){
//				newList.add(list.get(i));
//			}
//			
//			
//				
//			
//		}
//
//
//		return newList;
//
//	}

}

//if (classTakenlist.size() == 0) {
//System.out.println("does it come here?2");
//return list;
//} else {




//if ((classTakenlist.get(j).getStartDate().after(list.get(i).getEndDate())
//|| classTakenlist.get(j).getEndDate().before(list.get(i).getStartDate()))
//		&& (j == classTakenlist.size() - 1)&&(classTakenlist.get(j).getClassID()!=list.get(i).getClassID())) {
//newList.add(list.get(i));
//}