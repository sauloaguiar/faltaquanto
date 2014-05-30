package com.saulo.faltaquanto.activities;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Extra;
import org.androidannotations.annotations.ItemClick;
import org.androidannotations.annotations.ViewById;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.widget.ListView;
import android.widget.Toast;

import com.saulo.faltaquanto.R;
import com.saulo.faltaquanto.adapter.CourseGradeListAdapter;

@EActivity(R.layout.course_grades_list)
public class GradeListActivity extends Activity {

	@Extra("position")
	int position;
	
	@Bean CourseGradeListAdapter adapter;
	
	@ViewById ListView gradeList;
	
	@Click(R.id.addGradeButton)
	void click(){
		createDialog();
	}
	
	@AfterViews
	void bindAdapter(){
		adapter.setPosition(position);
		gradeList.setAdapter(adapter);
	}
	
	@ItemClick
	void gradeListItemClicked(int position){
		Toast.makeText(this, "pos: " + position, Toast.LENGTH_SHORT).show();
	}
	
	void createDialog(){
		// 1. Instantiate an AlertDialog.Builder with its constructor
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		
		LayoutInflater inflater = getLayoutInflater();

		// 2. Chain together various setter methods to set the dialog characteristics
		builder.setView(inflater.inflate(R.layout.course_grade_addition_dialog, null))
				.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						
					}
				})
				.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						
					}
				});

		// 3. Get the AlertDialog from create()
		AlertDialog dialog = builder.create();
		dialog.show();
	}
	
}
