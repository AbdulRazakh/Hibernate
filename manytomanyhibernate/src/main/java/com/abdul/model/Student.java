package com.abdul.model;

import java.util.Set;

public class Student {
	
	private int studentId;
	private String studentName;
	private int marks;
	private Set course;
	
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	public Set getCourse() {
		return course;
	}
	public void setCourse(Set course) {
		this.course = course;
	}
	
}
