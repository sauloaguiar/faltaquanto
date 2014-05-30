package com.saulo.faltaquanto.activities;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ItemClick;
import org.androidannotations.annotations.OnActivityResult;
import org.androidannotations.annotations.ViewById;

import android.app.Activity;
import android.content.Intent;
import android.widget.ListView;

import com.saulo.faltaquanto.R;
import com.saulo.faltaquanto.adapter.CourseListAdapter;

@EActivity(R.layout.course_list)
public class CourseListActivity extends Activity {
	
	private static final int REQUEST_CODE = 1;

	@ViewById ListView courseList;
	
	@Bean CourseListAdapter adapter;
	
	@AfterViews
	void bindAdapter(){
		courseList.setAdapter(adapter);
	}
	
	@ItemClick
	void courseListItemClicked(int position) {
		Intent data = new Intent(this, GradeListActivity_.class);
		data.putExtra("position", position);
		startActivity(data);
	}
	
	@Click(R.id.addCourseButton)
	void addCourseButtonClicked(){
		startActivityForResult(new Intent(this, CreateCourseDialogActivity_.class), REQUEST_CODE);
	}
	
	@OnActivityResult(REQUEST_CODE)
	protected void onActivityResult(int resultCode) {
		if (resultCode == RESULT_OK) {
			adapter.notifyDataSetChanged();
		}
	}
}
