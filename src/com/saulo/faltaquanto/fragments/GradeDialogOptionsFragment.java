package com.saulo.faltaquanto.fragments;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ItemClick;
import org.androidannotations.annotations.ViewById;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.saulo.faltaquanto.R;
import com.saulo.faltaquanto.model.Extra;
import com.saulo.faltaquanto.model.Presence;

@EFragment(R.layout.course_grade_dialog_list)
public class GradeDialogOptionsFragment extends DialogFragment {

	
	@ViewById ListView courseGradeDialogList;
	String[] options = new String[]{"Delete", "Add Extra"};
	
	GradeOptionsListener listener;
	int pos;
	@AfterViews
	void after(){
		pos = getArguments().getInt("position");
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), 
											android.R.layout.simple_list_item_1, 
											android.R.id.text1,
											options);
		courseGradeDialogList.setAdapter(adapter);
	}
	
	public void subscribe(GradeOptionsListener listener) {
		this.listener = listener;
	}
	
	@ItemClick
	void courseGradeDialogListItemClicked(int position){
		switch (position) {
		case 0:
			listener.onDeleteSelected(pos);
			break;
		case 1:
			listener.onExtraPointAdded(new Presence());
			break;
		default:
			break;
		}
		dismiss();
	}
	
	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		Dialog dialog = super.onCreateDialog(savedInstanceState);
		dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
		return dialog;
	}
	
	public interface GradeOptionsListener {
		void onExtraPointAdded(Extra extra);
		void onDeleteSelected(int position);
	}
} 
