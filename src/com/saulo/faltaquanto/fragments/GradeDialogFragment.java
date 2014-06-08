package com.saulo.faltaquanto.fragments;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.widget.EditText;

import com.saulo.faltaquanto.R;

@EFragment(R.layout.course_grade_addition_dialog)
public class GradeDialogFragment extends DialogFragment {

	@ViewById EditText addGradeName;
	@ViewById EditText addGradeValue;
	@ViewById EditText addGradeWeight;
	GradeListener listener;
	
	@Click(R.id.confirmButtonGrade)
	public void confirm(){
		listener.onConfirmClicked(addGradeName.getText().toString(), addGradeValue.getText().toString(), addGradeWeight.getText().toString());
		dismiss();
	}
	
	@AfterViews
	public void render(){
		Bundle data = getArguments();
		addGradeName.setText(data.getString("name"));
		addGradeValue.setText(data.getString("grade"));
		addGradeWeight.setText(data.getString("weight"));
	}
	
	@Click(R.id.cancelButtonGrade)
	public void cancel(){
		dismiss();
	}
	
	public void subscribe(GradeListener listener){
		this.listener = listener;
	}
	
	public interface GradeListener {
		public void onConfirmClicked(String grade, String value, String weight);
	}
	
}
