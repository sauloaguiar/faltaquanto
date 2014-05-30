package com.saulo.faltaquanto.activities;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.annotations.WindowFeature;

import android.app.Activity;
import android.view.Window;
import android.widget.EditText;

import com.saulo.faltaquanto.R;
import com.saulo.faltaquanto.model.CourseFinder;
import com.saulo.faltaquanto.model.InMemoryCourseFinder;

@WindowFeature(Window.FEATURE_NO_TITLE)
@EActivity(R.layout.create_course_dialog)
public class CreateCourseDialogActivity extends Activity {

	@Bean(InMemoryCourseFinder.class)
	CourseFinder finder;
	
	@ViewById(R.id.createCourseDialogInput)
	EditText disciplineName;
	
	@Click(R.id.createCourseDialogButtonNo)
	public void no(){
		finish();
	}
	
	@Click(R.id.createCourseDialogButtonYes)
	public void yes(){
		finder.addCourse(disciplineName.getText().toString());
		setResult(RESULT_OK, null);
		finish();
	}
	
}

