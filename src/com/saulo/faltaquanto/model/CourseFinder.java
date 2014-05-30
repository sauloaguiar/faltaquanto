package com.saulo.faltaquanto.model;

import java.util.List;

public interface CourseFinder {
	
	public List<Course> findAll();
	public void addCourse(String course);
	public List<Grade> getAllGradesByPosition(int position);
	
}
