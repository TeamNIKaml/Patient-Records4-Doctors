package com.teamNikAml.doctorpatient.fragments;

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
import com.teamNikAml.doctorpatient.application.GeneralClass;
import com.teamNikAml.doctorpatient.application.MyApplication;
import com.teamNikAml.doctorpatient.application.PatientDiagnosisCache;
import com.teamNikAml.doctorpatient.database.DatabaseConstants;
import com.teamNikAml.doctorpatient.database.IDatabaseUtility;
import com.teamNikAml.doctorpatient.database.PatientDetailAccess;

public class HistoryOfThePresentIllness extends DialogFragment {

	Button save;
	EditText process, note;

	MyApplication myApp;
	PatientDiagnosisCache pdc;

	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = getActivity().getLayoutInflater().inflate(R.layout.fragment_history_of_the_present_illness, null);
		save = (Button) view.findViewById(id.button_history_ofthe_present_illness);
		process = (EditText) view.findViewById(id.edittext_history_ofthe_present_illness);
		note = (EditText) view.findViewById(id.edittext_note_history_ofthe_present_illness);
		
		myApp = (MyApplication) getActivity().getApplication();
		pdc = myApp.getPatientdiagnosischache();
		
		String tempProcess = pdc.getHpiProcess();
		String tempNote = pdc.getHpiNote();
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
				
				GeneralClass gc = myApp.getGeneralClass();
				
				Bundle b = getArguments();
				String s = b.getString("patient_id");
				
				ContentValues cv = new ContentValues();
				cv.put(DatabaseConstants.HistoryOfThePresentIllness.ID, s);
				cv.put(DatabaseConstants.HistoryOfThePresentIllness.PROCESS, p);
				cv.put(DatabaseConstants.HistoryOfThePresentIllness.NOTES, n);
				cv.put(DatabaseConstants.HistoryOfThePresentIllness.DATE, gc.getCurrentDate());
				cv.put(DatabaseConstants.HistoryOfThePresentIllness.TIME, gc.getCurrentTime());
				
				IDatabaseUtility database = new PatientDetailAccess(getActivity().getApplicationContext(), null, null,0);
				if (database != null) {
					long rowid = pdc.getStatusFlaghpi();
					if (rowid==0) {
						 rowid = database.insert(DatabaseConstants.TABLE_HISTORYOFTHEPRESENTILLNESS, null, cv);
						pdc.setStatusFlaghpi(rowid);
					} else {
						database.update(DatabaseConstants.TABLE_HISTORYOFTHEPRESENTILLNESS, cv, "_id=?", new String[]{String.valueOf(rowid)});
					}

					pdc.setHpiProcess(p);
					pdc.setHpiNote(n);
				}


				dlg.dismiss();
			}
		});
		return dlg;
	}

	
}
