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
import com.teamNikAml.doctorpatient.database.DatabaseConstants;
import com.teamNikAml.doctorpatient.database.IDatabaseUtility;
import com.teamNikAml.doctorpatient.database.PatientDetailAccess;

public class PastMedicalHistoryFragment  extends DialogFragment {

	Button save;
	EditText process, note;


	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = getActivity().getLayoutInflater().inflate(R.layout.fragment_past_medical_history, null);
		save = (Button) view.findViewById(id.button_past_medical_history);
		process = (EditText) view.findViewById(id.edittext_past_medical_history);
		note = (EditText) view.findViewById(id.edittext_note_past_medical_history);
		
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
				cv.put(DatabaseConstants.PastMedicalHistory.ID, s);
				cv.put(DatabaseConstants.PastMedicalHistory.PROCESS, p);
				cv.put(DatabaseConstants.PastMedicalHistory.NOTES, n);
				cv.put(DatabaseConstants.PastMedicalHistory.DATE, formattedDate);
				
				IDatabaseUtility database = new PatientDetailAccess(getActivity().getApplicationContext(), null, null,0);
				if (database != null) {
					database.insert(DatabaseConstants.TABLE_PASTMEDICALHISTORY, null, cv);
				}

				
				dlg.dismiss();
			}
		});
		return dlg;
	}

	
}
