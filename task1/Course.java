package task1;

import java.util.List;

public class Course {
	private String id;
	private String title;
	private String type;
	private List<Student> students;
	private String lecturer;

	public Course(String id, String title, String type, List<Student> students, String lecturer) {
		this.id = id;
		this.title = title;
		this.type = type;
		this.students = students;
		this.lecturer = lecturer;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", title=" + title + ", type=" + type + ", students=" + students + ", lecturer="
				+ lecturer + "]";
	}

	public int getNumberStudent() {
		if(this.type.equalsIgnoreCase("TH")) {
			return this.students.size();
		}
		return 0;
	}
	
	public boolean isMoreStudent(Course other) {
		return this.getNumberStudent() > other.getNumberStudent();
	}

}
