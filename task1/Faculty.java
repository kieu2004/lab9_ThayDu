package task1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Faculty {
	private String name;
	private String address;
	private List<Course> courses;

	public Faculty(String name, String address, List<Course> courses) {
		this.name = name;
		this.address = address;
		this.courses = courses;
	}
	
	@Override
	public String toString() {
		return "Faculty [name=" + name + ", address=" + address + ", courses=" + courses + "]";
	}

	public Course getMaxPracticalCourse() {
		Course re = null;
		for (Course course : courses) {
			if (course.getType().equalsIgnoreCase("TH")) {
				if (re == null) {
					re = course;
				} else if (course.isMoreStudent(re)) {
					re = course;
				}

			}
		}
		return re;
	}
	
	public Map<Integer,List<Student>> groupStudentByYear(){
		Map<Integer, List<Student>> map= new HashMap<>();
		
		for (Course course : courses) {
			for (Student student : course.getStudents()) {
				int key=student.getYear();
				List<Student> values= new ArrayList<>();
				if(!map.containsKey(key)) {
					values.add(student);
				}else {
					values=map.get(key);
					if(!values.contains(student)) {
						values.add(student);
					}
				}
				map.put(key, values);
			}
		}
		
		return map;
	}
	
	public Set<Course> filterCourses(String type){   //type:TH or LT
		Set<Course> re= new HashSet<>();
		for (Course course : courses) {
			if(course.getType().equalsIgnoreCase(type)) {
				re.add(course);
			}
		}
		
		Set<Course> set= new TreeSet<>(new Comparator<Course>() {

			@Override
			public int compare(Course o1, Course o2) {
				return o2.getStudents().size()-o1.getStudents().size();
			}
		});
		
		set.addAll(re);
		
		return set;
	}

}
