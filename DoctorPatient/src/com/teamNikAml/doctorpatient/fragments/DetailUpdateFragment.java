package com.teamNikAml.doctorpatient.fragments;

import com.teamNikAml.doctorpatient.activity.R;
import com.teamNikAml.doctorpatient.activity.R.id;
import com.teamNikAml.doctorpatient.application.MyApplication;
import com.teamNikAml.doctorpatient.application.PatientDiagnosisCache;
import com.teamNikAml.doctorpatient.database.DatabaseConstants;
import com.teamNikAml.doctorpatient.database.IDatabaseUtility;
import com.teamNikAml.doctorpatient.database.PatientDetailAccess;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.ContentValues;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class DetailUpdateFragment extends DialogFragment {

	Button save;
	EditText process, note;
	
	MyApplication myApp;
	PatientDiagnosisCache pdc;
	
	String pid, date, time , table;
	
	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		
		View view = getActivity().getLayoutInflater().inflate(R.layout.fragment_general, null);
		save = (Button) view.findViewById(id.button_save_process);
		process = (EditText) view.findViewById(id.edittext_process);
		note = (EditText) view.findViewById(id.edittext_note_process);
		
		Bundle b = getArguments();
		pid = b.getString("patient_id");
		date = b.getString("date");
		time = b.getString("time");
		String table1 = b.getString("table");
		String note1 = b.getString("note");
	    table = table1.replaceAll("\\s+","");
	    
		
/*		int i = note1.indexOf("\n\n");
		String process1 = note1.substring(0, i);
		String processnote1 = note1.substring(i+2);*/
	    String process1 = "", processnote1 = "";
	    
		IDatabaseUtility database = new PatientDetailAccess(getActivity().getApplicationContext(), null, null,0);
		Cursor temcursor = null;
		
		if (database != null) {
			temcursor = database.query(table, null, "id=? AND date=? AND time=?" ,new String[]{String.valueOf(pid),date,time}, null, null, null);
		}
		
		if (temcursor.moveToFirst()) {
			process1 = temcursor.getString(2);
			processnote1 = temcursor.getString(3);
		}

				
		this.process.setText(process1);
		this.note.setText(processnote1);
		
		save.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String p = process.getText().toString().trim();
				String n = note.getText().toString().trim();
				
				ContentValues cv = new ContentValues();
				cv.put("id", pid);
				cv.put(table.toLowerCase(), p);
				cv.put("notes", n);
				
				
				IDatabaseUtility database = new PatientDetailAccess(getActivity().getApplicationContext(), null, null,0);
				if (database != null) {

						database.update(table, cv, "id=? And date=? And time=?", new String[]{String.valueOf(pid),date,time});	

				}
				dismiss();
			}
		});
		
		final Dialog dlg = new AlertDialog.Builder(getActivity()).setView(view).create();
		return dlg;
	}
	
	

}
