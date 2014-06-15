package com.saulo.faltaquanto.fragments;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import android.support.v4.app.DialogFragment;
import android.widget.EditText;

import com.saulo.faltaquanto.R;
import com.saulo.faltaquanto.model.CourseFinder;
import com.saulo.faltaquanto.model.InMemoryCourseFinder;

@EFragment(R.layout.create_course_dialog)
public class CourseDialogFragment extends DialogFragment {

	@Bean(InMemoryCourseFinder.class)
	CourseFinder finder;
	
	@ViewById(R.id.createCourseDialogInput)
	EditText disciplineName;
	
	CourseListener courseListener;
	
	@Click(R.id.createCourseDialogButtonNo)
	public void no(){
		dismiss();
	}
	
	@Click(R.id.createCourseDialogButtonYes)
	public void yes(){
		courseListener.onConfirmClicked(disciplineName.getText().toString());
		dismiss();
	}
	
	public void subscribe(CourseListener listener){
		this.courseListener = listener;
	}
	
	public interface CourseListener {
		public void onConfirmClicked(String course);
	}
	
}

