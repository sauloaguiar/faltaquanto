package com.saulo.faltaquanto.activities;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Extra;
import org.androidannotations.annotations.ItemClick;
import org.androidannotations.annotations.ItemLongClick;
import org.androidannotations.annotations.ViewById;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.widget.ListView;

import com.saulo.faltaquanto.R;
import com.saulo.faltaquanto.adapter.CourseGradeListAdapter;
import com.saulo.faltaquanto.fragments.GradeDialogFragment.GradeListener;
import com.saulo.faltaquanto.fragments.GradeDialogOptionsFragment.GradeOptionsListener;
import com.saulo.faltaquanto.fragments.GradeDialogFragment_;
import com.saulo.faltaquanto.fragments.GradeDialogOptionsFragment_;
import com.saulo.faltaquanto.model.Grade;

@EActivity(R.layout.course_grades_list)
public class GradeListActivity extends FragmentActivity implements GradeListener, GradeOptionsListener{

	@Extra("position")
	int position;
	
	@Bean CourseGradeListAdapter adapter;
	
	@ViewById ListView gradeList;
	
	@Click(R.id.addGradeButton)
	void click(){
		createDialog(new Bundle());
	}
	
	@AfterViews
	void bindAdapter(){
		adapter.setPosition(position);
		adapter.initAdapter();
		gradeList.setAdapter(adapter);
	}
	
	@ItemLongClick
	void gradeListItemLongClicked(int position){
		FragmentManager manager = getSupportFragmentManager();
		GradeDialogOptionsFragment_ d = new GradeDialogOptionsFragment_();
		Bundle data = new Bundle();
		data.putInt("position", position);
		d.setArguments(data);
		d.subscribe(this);
		d.show(manager, "");
	}
	
	@ItemClick
	void gradeListItemClicked(Grade grade){
		Bundle data = new Bundle();
		data.putString("name", grade.getName());
		data.putString("grade", String.valueOf(grade.getValue()));
		data.putString("weight", String.valueOf(grade.getWeight()));
		createDialog(data);
	}
	
	void createDialog(Bundle data){
		FragmentManager manager = getSupportFragmentManager();
		GradeDialogFragment_ dialogFragment_ = new GradeDialogFragment_();
		dialogFragment_.setArguments(data);
		dialogFragment_.subscribe(this);
		dialogFragment_.show(manager, "grade_dialog");
	}

	@Override
	public void onConfirmClicked(String grade, String value, String weight) {
		adapter.addGrade(new Grade(grade, Double.valueOf(value), Double.valueOf(weight)));
	}

	@Override
	public void onExtraPointAdded(com.saulo.faltaquanto.model.Extra extra) {
		adapter.addExtraToGrade(extra);
	}

	@Override
	public void onDeleteSelected(int position) {
		adapter.deleteGrade(position);
	}
	
}
