package com.teamNikAml.doctorpatient.fragments;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import android.app.Fragment;
import android.content.ContentValues;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.teamNikAml.doctorpatient.activity.R;
import com.teamNikAml.doctorpatient.activity.R.id;
import com.teamNikAml.doctorpatient.application.MyApplication;
import com.teamNikAml.doctorpatient.database.DatabaseConstants;
import com.teamNikAml.doctorpatient.database.IDatabaseUtility;
import com.teamNikAml.doctorpatient.database.PatientDetailAccess;

public class ChiefComplaintFragment extends Fragment {

	EditText process, note;
	Button button;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.fragment_chief_complaint, container,
				false);

		process = (EditText) rootView.findViewById(id.edittext_chief_complaint);
		note = (EditText) rootView.findViewById(id.edittext_note_chief_complaint);
		button = (Button) rootView.findViewById(id.button_save_chief_complaint);
		
		button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String p = process.getText().toString().trim();
				String n = note.getText().toString().trim();
				
				Calendar c = Calendar.getInstance();

				SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
				String formattedDate = df.format(c.getTime());
	
				ContentValues cv = new ContentValues();
				cv.put(DatabaseConstants.ChiefComplaint.ID, 1);
				cv.put(DatabaseConstants.ChiefComplaint.PROCESS, p);
				cv.put(DatabaseConstants.ChiefComplaint.NOTES, n);
				cv.put(DatabaseConstants.ChiefComplaint.DATE, formattedDate);
				
				
				IDatabaseUtility database = ((MyApplication) getActivity()
						.getApplication()).getPatientDetailAccess();
				if (database == null) {
					((MyApplication) getActivity().getApplication())
							.setPatientDetailAccess(new PatientDetailAccess(
									getActivity().getApplicationContext(),
									null, null, 0));
					database = ((MyApplication) getActivity().getApplication())
							.getPatientDetailAccess();
				}

				database.insert(DatabaseConstants.TABLE_CHIEFCOMPLAINT, null, cv);
				
			}
		});
		
		return rootView;
	}
}
