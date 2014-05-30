package com.saulo.faltaquanto.view;

import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

import android.content.Context;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.saulo.faltaquanto.R;
import com.saulo.faltaquanto.model.Course;

@EViewGroup(R.layout.course_item)
public class CourseItemView extends LinearLayout {

	@ViewById TextView courseName;
	@ViewById TextView courseAverage;

	public CourseItemView(Context context) {
		super(context);
	}

	public void bind(Course course) {
		courseName.setText(course.getName());
		courseAverage.setText(String.valueOf(course.getAverage()));
	}
}
