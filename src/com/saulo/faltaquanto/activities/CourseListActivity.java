package com.saulo.faltaquanto.activities;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ItemClick;
import org.androidannotations.annotations.ItemLongClick;
import org.androidannotations.annotations.OptionsItem;
import org.androidannotations.annotations.OptionsMenu;
import org.androidannotations.annotations.ViewById;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import com.saulo.faltaquanto.R;
import com.saulo.faltaquanto.adapter.CourseListAdapter;
import com.saulo.faltaquanto.fragments.CourseDialogFragment.CourseListener;
import com.saulo.faltaquanto.fragments.CourseDialogFragment_;
import com.saulo.faltaquanto.model.Course;

@EActivity(R.layout.course_list)
@OptionsMenu(R.menu.main)
public class CourseListActivity extends FragmentActivity implements CourseListener{
	
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
	
	@ItemLongClick
	void courseListItemLongClicked(Course course){
		Toast.makeText(getApplicationContext(), "Long Clicked", Toast.LENGTH_SHORT).show();
	}
	
	@Click(R.id.addCourseButton)
	void addCourseButtonClicked(){
		FragmentManager manager = getSupportFragmentManager();
		CourseDialogFragment_ courseDialogFragment_ = new CourseDialogFragment_();
		courseDialogFragment_.subscribe(this);
		courseDialogFragment_.show(manager, "course_dialog");
	}
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		return super.onCreateOptionsMenu(menu);
	}
		// Associate searchable configuration with the SearchView
		/*SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
		SearchView searchView = (SearchView) menu.findItem(R.id.searchCourse).getActionView();
		searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));*/
	
	@OptionsItem
	void removeCourse(){
		Toast.makeText(getApplicationContext(), "Clicked", Toast.LENGTH_SHORT).show();
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.removeCourse:
		
			break;
		default:
			break;
		}
		return super.onOptionsItemSelected(item);
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		adapter.notifyDataSetChanged();
	}

	@Override
	public void onConfirmClicked(String course) {
		adapter.addCourse(new Course(course));
	}
}
