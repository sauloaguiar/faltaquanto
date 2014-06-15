package com.saulo.faltaquanto.adapter;

import java.util.List;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.saulo.faltaquanto.model.Course;
import com.saulo.faltaquanto.model.CourseFinder;
import com.saulo.faltaquanto.model.InMemoryCourseFinder;
import com.saulo.faltaquanto.view.CourseItemView;
import com.saulo.faltaquanto.view.CourseItemView_;

@EBean
public class CourseListAdapter extends BaseAdapter {

	List<Course> courses;
	
	@Bean(InMemoryCourseFinder.class)
	CourseFinder finder;
	
	@RootContext
	Context context;
	
	@AfterInject
	void initAdapter(){
		courses = finder.findAll();
	}
	
	@Override
	public int getCount() {
		return courses.size();
	}

	@Override
	public Course getItem(int position) {
		return courses.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		CourseItemView itemView = null;
		if ( convertView == null ) {
			itemView = CourseItemView_.build(context);
		} else {
			itemView = (CourseItemView) convertView;
		}
		
		itemView.bind(getItem(position));
		
		return itemView;
	}

	public void addCourse(Course course) {
		courses.add(course);
		notifyDataSetChanged();
	}

}
