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

public class FamilyDiseasesFragment extends DialogFragment {

	Button save;
	EditText process, note;


	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = getActivity().getLayoutInflater().inflate(R.layout.fragment_family_diseases, null);
		save = (Button) view.findViewById(id.button_save_family_diseases);
		process = (EditText) view.findViewById(id.edittext_family_diseases);
		note = (EditText) view.findViewById(id.edittext_note_family_diseases);
		
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
				cv.put(DatabaseConstants.FamilyDiseases.ID, s);
				cv.put(DatabaseConstants.FamilyDiseases.PROCESS, p);
				cv.put(DatabaseConstants.FamilyDiseases.NOTES, n);
				cv.put(DatabaseConstants.FamilyDiseases.DATE, formattedDate);
				
				IDatabaseUtility database = new PatientDetailAccess(getActivity().getApplicationContext(), null, null,0);
				if (database != null) {
					database.insert(DatabaseConstants.TABLE_FAMILYDISEASES, null, cv);
				}

				
				dlg.dismiss();
			}
		});
		return dlg;
	}

	
}
