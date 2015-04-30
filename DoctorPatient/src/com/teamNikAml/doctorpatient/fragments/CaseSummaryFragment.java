package com.teamNikAml.doctorpatient.fragments;

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

import com.teamNikAml.doctorpatient.activity.R;
import com.teamNikAml.doctorpatient.activity.R.id;
import com.teamNikAml.doctorpatient.application.GeneralClass;
import com.teamNikAml.doctorpatient.application.MyApplication;
import com.teamNikAml.doctorpatient.application.PatientDiagnosisCache;
import com.teamNikAml.doctorpatient.database.DatabaseConstants;
import com.teamNikAml.doctorpatient.database.DatabaseConstants.ReportByDay;
import com.teamNikAml.doctorpatient.database.IDatabaseUtility;
import com.teamNikAml.doctorpatient.database.PatientDetailAccess;

public class CaseSummaryFragment extends DialogFragment {

	Button save;
	EditText process, note, fees;

	MyApplication myApp;
	PatientDiagnosisCache pdc;

	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = getActivity().getLayoutInflater().inflate(R.layout.fragment_case_summary, null);
		save = (Button) view.findViewById(id.button_save_process);
		process = (EditText) view.findViewById(id.edittext_process);
		note = (EditText) view.findViewById(id.edittext_note_process);
		fees = (EditText) view.findViewById(id.edittext_fee);
		process.setHint("Case Report");
		note.setHint("Prescription");
		
		myApp = (MyApplication) getActivity().getApplication();
		pdc = myApp.getPatientdiagnosischache();
		
		String tempProcess = pdc.getCsProcess();
		String tempNote = pdc.getCsNote();
		int tempfee = pdc.getCsFees();
		if (tempProcess.length()>0) {
			process.setText(tempProcess);
		}
		if (tempNote.length()>0) {
			note.setText(tempNote);
		}
		if (tempfee > 0) {
			fees.setText(String.valueOf(tempfee));
		}
		
		final Dialog dlg = new AlertDialog.Builder(getActivity()).setView(view).create();
		
		save.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String p = process.getText().toString().trim();
				String n = note.getText().toString().trim();
				String ftemp = fees.getText().toString().trim();
				int f =0;
				if (ftemp.length()>0) {
					f = Integer.parseInt(ftemp);
				}
				
				
				GeneralClass gc = myApp.getGeneralClass();
	
				Bundle b = getArguments();
				String s = b.getString("patient_id");
				
				ContentValues cv = new ContentValues();
				cv.put(DatabaseConstants.CaseSummary.ID, s);
				cv.put(DatabaseConstants.CaseSummary.PROCESS, p);
				cv.put(DatabaseConstants.CaseSummary.NOTES, n);
				cv.put(DatabaseConstants.CaseSummary.FEES, f);
				cv.put(DatabaseConstants.CaseSummary.DATE, gc.getCurrentDate());
				cv.put(DatabaseConstants.CaseSummary.TIME, gc.getCurrentTime());
				
				IDatabaseUtility database = new PatientDetailAccess(getActivity().getApplicationContext(), null, null,0);
				if (database != null) {
					long rowid = pdc.getStatusFlagcs();
					if (rowid==0) {
						rowid = database.insert(DatabaseConstants.TABLE_CASESUMMARY, null, cv);
						pdc.setStatusFlagcs(rowid);
						
/*						String selectQuery = "SELECT * FROM " +  DatabaseConstants.TABLE_REPORTBYDAY + " WHERE "
						+ ReportByDay.TID + "= (SELECT MAX("+ ReportByDay.TID +")  FROM "+DatabaseConstants.TABLE_REPORTBYDAY+")";
						Cursor cc = database.rawQuery(selectQuery, null);*/
					} else {
						database.update(DatabaseConstants.TABLE_CASESUMMARY, cv, "_id=?", new String[]{String.valueOf(rowid)});
					}

					pdc.setCsProcess(p);
					pdc.setCsNote(n);
					pdc.setCsFees(f);
				}

				
				dlg.dismiss();
			}
		});
		return dlg;
	}

	
}
