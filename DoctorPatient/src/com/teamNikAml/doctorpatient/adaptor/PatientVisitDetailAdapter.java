package com.teamNikAml.doctorpatient.adaptor;



import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.teamNikAml.doctorpatient.activity.R;

public class PatientVisitDetailAdapter extends ArrayAdapter<PatientVisitDetailObject> {

	Context mContext;
	int layoutResourceId;
	PatientVisitDetailObject data[] = null;
	LayoutInflater li=null;

	public PatientVisitDetailAdapter(Context mContext, int layoutResourceId,
			PatientVisitDetailObject[] data, LayoutInflater li) {

		super(mContext, layoutResourceId, data);

		this.layoutResourceId = layoutResourceId;
		this.mContext = mContext;
		this.data = data;
		this.li = li;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {


		if (convertView == null) {
			LayoutInflater inflater =  li;
			convertView = inflater.inflate(layoutResourceId, parent, false);
		}

		PatientVisitDetailObject objectItem = data[position];

		TextView textViewProcess = (TextView) convertView
				.findViewById(R.id.textView_process);
		textViewProcess.setText(objectItem.process);
		
		TextView textViewNote = (TextView) convertView
				.findViewById(R.id.textView_process_note);
		textViewNote.setText(objectItem.note.toString());

		return convertView;

	}

}