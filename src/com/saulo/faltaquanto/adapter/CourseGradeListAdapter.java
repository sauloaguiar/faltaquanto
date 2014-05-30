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

import com.saulo.faltaquanto.model.CourseFinder;
import com.saulo.faltaquanto.model.Grade;
import com.saulo.faltaquanto.model.InMemoryCourseFinder;
import com.saulo.faltaquanto.view.GradeItemView;
import com.saulo.faltaquanto.view.GradeItemView_;

@EBean
public class CourseGradeListAdapter extends BaseAdapter {

	List<Grade> grades;
	
	@Bean(InMemoryCourseFinder.class)
	CourseFinder finder;
	
	@RootContext
	Context context;
	
	int position;

	public void setPosition(int pos) {
		this.position = pos;
	}
	
	@AfterInject
	void initAdapter(){
		grades = finder.getAllGradesByPosition(position);
	}
	
	@Override
	public int getCount() {
		return grades.size();
	}

	@Override
	public Grade getItem(int position) {
		return grades.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		GradeItemView itemView = null;
		if ( convertView == null ) {
			itemView = GradeItemView_.build(context);
		} else {
			itemView = (GradeItemView) convertView;
		}
		
		itemView.bind(getItem(position));
		
		return itemView;
	}

}
