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

public class ProvisionalDiagnosisFragment  extends DialogFragment {

	Button save;
	EditText process, note;

	MyApplication myApp;
	PatientDiagnosisCache pdc;

	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = getActivity().getLayoutInflater().inflate(R.layout.fragment_general, null);
		save = (Button) view.findViewById(id.button_save_process);
		process = (EditText) view.findViewById(id.edittext_process);
		note = (EditText) view.findViewById(id.edittext_note_process);
		process.setHint("Provisional Diagnosis");
		
		myApp = (MyApplication) getActivity().getApplication();
		pdc = myApp.getPatientdiagnosischache();
		
		String tempProcess = pdc.getPdProcess();
		String tempNote = pdc.getPdNote();
		
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
				cv.put(DatabaseConstants.ProvisionalDiagnosis.ID, s);
				cv.put(DatabaseConstants.ProvisionalDiagnosis.PROCESS, p);
				cv.put(DatabaseConstants.ProvisionalDiagnosis.NOTES, n);
				cv.put(DatabaseConstants.ProvisionalDiagnosis.DATE, formattedDate);
				
				IDatabaseUtility database = new PatientDetailAccess(getActivity().getApplicationContext(), null, null,0);
				if (database != null) {
					long rowid = pdc.getStatusFlagpd();
					if (rowid==0) {
						 rowid = database.insert(DatabaseConstants.TABLE_PROVISIONALDIAGNOSIS, null, cv);
						pdc.setStatusFlagpd(rowid);
					} else {
						database.update(DatabaseConstants.TABLE_PROVISIONALDIAGNOSIS, cv, "_id=?", new String[]{String.valueOf(rowid)});
					}

					pdc.setPdProcess(p);
					pdc.setPdNote(n);
				}

				
				dlg.dismiss();
			}
		});
		return dlg;
	}

	
}
