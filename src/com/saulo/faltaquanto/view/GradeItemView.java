package com.saulo.faltaquanto.view;

import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

import android.content.Context;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.saulo.faltaquanto.R;
import com.saulo.faltaquanto.model.Grade;

@EViewGroup(R.layout.course_grade_item)
public class GradeItemView extends LinearLayout {

	@ViewById TextView courseGradeItemLabel;
	@ViewById TextView courseGradeItemValue;
	@ViewById TextView courseGradeItemWeight;
	
	public GradeItemView(Context context) {
		super(context);
	}
	
	public void bind(Grade grade) {
		courseGradeItemLabel.setText(grade.getName());
		courseGradeItemValue.setText(String.valueOf(grade.getValue()));
		courseGradeItemWeight.setText(String.valueOf(grade.getWeight()));
	}

}
