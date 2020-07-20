/**
 * Homework 5 - GPA Calculator
 * Zachery Morris - ztm4qv
 */
import java.util.ArrayList;


/**
 * Creates Course object.
 * @author Zachery Morris
 * 
 */
public class Course {
	private String courseName;
	private double grade;
	private int creditHours;
	private ArrayList<Course> buildCourse;
	
	public ArrayList<Course> getBuildCourse() {
		return buildCourse;
	}

	public Course(int creditHours) {
		this.courseName = "";
		this.grade = 0.0;
		this.creditHours = creditHours;
	}
	
	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public double getGrade() {
		return grade;
	}

	public void setGrade(double grade) {
		this.grade = grade;
	}

	public int getCreditHours() {
		return creditHours;
	}

	public void setCreditHours(int creditHours) {
		this.creditHours = creditHours;
	}
	
	public Course() {
		this.courseName = "";
		this.creditHours = 0;
		this.grade = 0.0;
		this.buildCourse = new ArrayList<Course>();
	}
	
	public Course(int creditHours, String courseName) {
		this.courseName = courseName;
		this.grade = 0.0;
		this.creditHours = creditHours;
		this.buildCourse = new ArrayList<Course>();
	}
	
	public Course(int creditHours, double grade) {
		this.grade = grade;
		this.creditHours = creditHours;
		this.buildCourse = new ArrayList<Course>();
	}
	
	public Course(int creditHours, double grade, String courseName) {
		this.courseName = courseName;
		this.grade = grade;
		this.creditHours = creditHours;
		this.buildCourse = new ArrayList<Course>();
	}
	
}
