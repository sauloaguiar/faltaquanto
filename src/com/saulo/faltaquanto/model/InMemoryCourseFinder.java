package com.saulo.faltaquanto.model;

import java.util.ArrayList;
import java.util.List;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.EBean.Scope;

@EBean(scope = Scope.Singleton)
public class InMemoryCourseFinder implements CourseFinder {

	List<Course> list = new ArrayList<Course>();
	
	public InMemoryCourseFinder() {
		Course fisica = new Course("Fisica");
		fisica.addGrade(new Grade("prova1", 5.0));
		fisica.addGrade(new Grade("prova2", 7.0));
		list.add(fisica);
		list.add(new Course("Quimica"));
	}
	
	@Override
	public List<Course> findAll() {
		return list;
	}

	@Override
	public void addCourse(String discipline) {
		list.add(new Course(discipline));
	}

	@Override
	public List<Grade> getAllGradesByPosition(int position) {
		return list.get(position).getGrades();
	}

	@Override
	public void addGrade(Grade grade, int courseIndex) {
		list.get(courseIndex).addGrade(grade);
	}

	@Override
	public void addExtraToGrade(Extra extra, int position) {
		list.get(position).getGrades().get(0).addExtra(extra);
	}

	@Override
	public void deleteGrade(int courseIndex, int gradeIndex) {
		list.get(courseIndex).getGrades().remove(gradeIndex);
	}

}
