package com.teamNikAml.doctorpatient.fragments;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.ContentValues;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.teamNikAml.doctorpatient.activity.R;
import com.teamNikAml.doctorpatient.activity.R.id;
import com.teamNikAml.doctorpatient.application.MyApplication;
import com.teamNikAml.doctorpatient.application.PatientDiagnosisCache;
import com.teamNikAml.doctorpatient.database.DatabaseConstants;
import com.teamNikAml.doctorpatient.database.IDatabaseUtility;
import com.teamNikAml.doctorpatient.database.PatientDetailAccess;

public class ChiefComplaintFragment extends DialogFragment {

	Button save;
	EditText process, note;
	
	MyApplication myApp;
	PatientDiagnosisCache pdc;

	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = getActivity().getLayoutInflater().inflate(R.layout.fragment_chief_complaint, null);
		save = (Button) view.findViewById(id.button_save_chief_complaint);
		process = (EditText) view.findViewById(id.edittext_chief_complaint);
		note = (EditText) view.findViewById(id.edittext_note_chief_complaint);
		
		myApp = (MyApplication) getActivity().getApplication();
		pdc = myApp.getPatientdiagnosischache();
		
		String tempProcess = pdc.getCcProcess();
		String tempNote = pdc.getCcNote();
		if (tempProcess.length()>0) {
			process.setText(tempProcess);
		}
		if (tempNote.length()>0) {
			note.setText(tempNote);
		}
		
		final Dialog dlg = new AlertDialog.Builder(getActivity()).setView(view).create();
		
		save.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String p = process.getText().toString().trim();
				String n = note.getText().toString().trim();
				
				Calendar c = Calendar.getInstance();

				SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
				String formattedDate = df.format(c.getTime());
	
				Bundle b = getArguments();
				String s = b.getString("patient_id");
				
				ContentValues cv = new ContentValues();
				cv.put(DatabaseConstants.ChiefComplaint.ID, pdc.getPatientId());
				cv.put(DatabaseConstants.ChiefComplaint.PROCESS, p);
				cv.put(DatabaseConstants.ChiefComplaint.NOTES, n);
				cv.put(DatabaseConstants.ChiefComplaint.DATE, formattedDate);
				
				
				IDatabaseUtility database = new PatientDetailAccess(getActivity().getApplicationContext(), null, null,0);
				if (database != null) {
					long rowid = pdc.getStatusFlagcc();
					if (rowid==0) {
						 rowid = database.insert(DatabaseConstants.TABLE_CHIEFCOMPLAINT, null, cv);
						pdc.setStatusFlagcc(rowid);
					} else {
						database.update(DatabaseConstants.TABLE_CHIEFCOMPLAINT, cv, "_id=?", new String[]{String.valueOf(rowid)});
					}

					pdc.setCcProcess(p);
					pdc.setCcNote(n);
				}

				
				dlg.dismiss();
			}
		});
		return dlg;
	}

	
}
