package task1;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Test {
	public static void main(String[] args) {
      
		Student student1= new Student("HS1","Le An",2004);
		Student student2= new Student("HS2","Binh An",2006);
		Student student3= new Student("HS3","Nguyen C",2004);
		
		List<Student> students_1= new ArrayList<>();
		students_1.add(student1);
		students_1.add(student2);
		students_1.add(student3);
		
		List<Student> students_2= new ArrayList<>();
		students_2.add(student1);
		students_2.add(student3);
		
		Course course_1= new Course("0023F", "Cau truc du lieu", "TH", students_1, "Thay Du");
		Course course_2= new Course("0025F", "Lap trinh nang cao", "TH", students_2, "Thay Du");
	
	    List<Course> courses= new ArrayList<>();
	    courses.add(course_1);
	    courses.add(course_2);
	    
	    Faculty f1= new Faculty("CNTT", "Dai hoc Nong Lam", courses);
	    
	    //Method getMaxPracticalCourse
	    Course course= f1.getMaxPracticalCourse();
	    System.out.println("Max Practical Course: "+course);
	    
	    //Method groupStudentsByYear
	    Map<Integer,List<Student>> map= f1.groupStudentByYear();
	    System.out.println("Group student by year: "+map);
	    
	    //Method filterCourses
	    Set<Course> set= f1.filterCourses("TH");
	    System.out.println("Filter courses by type: "+set);
	}
}
