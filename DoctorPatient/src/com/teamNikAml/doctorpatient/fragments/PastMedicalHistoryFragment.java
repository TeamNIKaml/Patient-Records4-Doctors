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
import com.teamNikAml.doctorpatient.database.DatabaseConstants;
import com.teamNikAml.doctorpatient.database.IDatabaseUtility;
import com.teamNikAml.doctorpatient.database.PatientDetailAccess;

public class PastMedicalHistoryFragment  extends DialogFragment {

	Button save;
	EditText process, note;

	String s;
	Bundle b;
	IDatabaseUtility database;

	int flag =0;
	String selection;
	
	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = getActivity().getLayoutInflater().inflate(R.layout.fragment_past_medical_history, null);
		save = (Button) view.findViewById(id.button_past_medical_history);
		process = (EditText) view.findViewById(id.edittext_past_medical_history);
		note = (EditText) view.findViewById(id.edittext_note_past_medical_history);
		
		b = getArguments();
		s = b.getString("patient_id");
		
		database = new PatientDetailAccess(getActivity().getApplicationContext(), null, null,0);
		Cursor c = null;
		if (database != null) {
			selection = "id=?";
			String[] selectionArgs = {s};
		    c = database.query(DatabaseConstants.TABLE_PASTMEDICALHISTORY, null,selection ,selectionArgs, null, null, null);

			
		}

		if (c.moveToFirst()) {

			process.setText(c.getString(2));
			note.setText(c.getString(3));
			flag = 1;
		}
		
		final Dialog dlg = new AlertDialog.Builder(getActivity()).setView(view).create();
		
		save.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String p = process.getText().toString().trim();
				String n = note.getText().toString().trim();
				
				GeneralClass gc = new GeneralClass();
				
				ContentValues cv = new ContentValues();
				cv.put(DatabaseConstants.PastMedicalHistory.ID, s);
				cv.put(DatabaseConstants.PastMedicalHistory.PROCESS, p);
				cv.put(DatabaseConstants.PastMedicalHistory.NOTES, n);
				cv.put(DatabaseConstants.PastMedicalHistory.DATE, gc.getCurrentDate());
				cv.put(DatabaseConstants.PastMedicalHistory.TIME, gc.getCurrentTime());
				
				database = new PatientDetailAccess(getActivity().getApplicationContext(), null, null,0);
				if (database != null) {
					if (flag == 0) {
						database.insert(DatabaseConstants.TABLE_PASTMEDICALHISTORY, null, cv);		
					} else {
						database.update(DatabaseConstants.TABLE_PASTMEDICALHISTORY, cv, selection, new String[]{s});
					}
				}

				
				dlg.dismiss();
			}
		});
		return dlg;
	}

	
}
