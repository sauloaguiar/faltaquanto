package com.saulo.faltaquanto.model;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Course {
	
	private String name;
	private double average;
	private List<Grade> grades;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAverage() {
		calculateAverage();
		DecimalFormat df = new DecimalFormat("#.00");
		return df.format(average);
	}

	private void calculateAverage() {
		double accumulator = 0.0;
		double weight = 0.0;
		for (Grade g : grades) {
			accumulator += g.getValue() * g.getWeight();
			weight += g.getWeight();
		}
		average = accumulator/weight;
	}

	public void setAverage(double average) {
		this.average = average;
	}

	public List<Grade> getGrades() {
		return grades;
	}

	public void setGrades(List<Grade> grades) {
		this.grades = grades;
	}

	public Course(String courseName) {
		name = courseName;
		this.grades = new ArrayList<Grade>();
	}
	
	public Course(String name, double average) {
		this.name = name;
		this.average = average;
		this.grades = new ArrayList<Grade>();
	}

	public void addGrade(Grade grade) {
		if (this.grades.contains(grade)) {
			grades.remove(grade);
		} 
		this.grades.add(grade);
		calculateAverage();
	}
}
