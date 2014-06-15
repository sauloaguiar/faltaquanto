package com.saulo.faltaquanto.adapter;

import java.util.ArrayList;
import java.util.List;

import org.androidannotations.annotations.EBean;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

@EBean
public class CourseGradeDialogListAdapter extends BaseAdapter{

	List<String> options = new ArrayList<String>();
	
	@Override
	public int getCount() {
		return options.size();
	}

	@Override
	public Object getItem(int position) {
		return options.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		return null;
	}

}
