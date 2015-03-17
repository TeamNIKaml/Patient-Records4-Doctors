package com.teamNikAml.doctorpatient.fragments;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.ContentValues;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.teamNikAml.doctorpatient.activity.R;
import com.teamNikAml.doctorpatient.activity.R.id;
import com.teamNikAml.doctorpatient.application.MyApplication;
import com.teamNikAml.doctorpatient.database.DatabaseConstants;
import com.teamNikAml.doctorpatient.database.IDatabaseUtility;
import com.teamNikAml.doctorpatient.database.PatientDetailAccess;

public class NewPatientFragment extends Fragment {

	private Spinner sex;
	private String[] sexValues = { "Male", "Female" };
	private EditText name, age, email, contact, othernotes;
	private Button ok;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_new_patient,
				container, false);

		sex = (Spinner) rootView.findViewById(id.spinner_sex);
		ArrayAdapter<String> mySexAdapter = new ArrayAdapter<String>(
				getActivity().getApplicationContext(), R.layout.spinner_layout,
				R.id.textView_spinnertext, sexValues);
		sex.setAdapter(mySexAdapter);
		name = (EditText) rootView.findViewById(id.edittext_name);
		age = (EditText) rootView.findViewById(id.edittext_age);
		email = (EditText) rootView.findViewById(id.edittext_email);
		contact = (EditText) rootView.findViewById(id.edittext_phone);
		othernotes = (EditText) rootView.findViewById(id.edittext_others);
		ok = (Button) rootView.findViewById(id.button_save_patient);

		ok.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				ContentValues cv = new ContentValues();
				cv.put(DatabaseConstants.PatientDetailTable.NAME, name
						.getText().toString().trim());
				cv.put(DatabaseConstants.PatientDetailTable.SEX, sex
						.getSelectedItem().toString().trim());
				cv.put(DatabaseConstants.PatientDetailTable.AGE, age.getText()
						.toString().trim());
				cv.put(DatabaseConstants.PatientDetailTable.EMAIL, email
						.getText().toString().trim());
				cv.put(DatabaseConstants.PatientDetailTable.CONTACTNO, contact
						.getText().toString().trim());
				cv.put(DatabaseConstants.PatientDetailTable.OTHERNOTES,
						othernotes.getText().toString().trim());

				IDatabaseUtility database = new PatientDetailAccess(getActivity().getApplicationContext(), null, null,0);
				long id = 0;
				if (database != null) {
					id = database.insert(DatabaseConstants.TABLE_PATIENTDETAIL, null, cv);
				}
				
				MyApplication myApp = (MyApplication) getActivity().getApplication();
				myApp.addNewPatientNamewithIdToList(name.getText().toString().trim()+" \t" + "ID -"+id);
				
				FragmentTransaction t = getActivity().getFragmentManager()
						.beginTransaction();
				Fragment mFrag = new PatientFragment();
				t.replace(R.id.frame_container, mFrag);
				t.commit();
			}
		});
		return rootView;
	}

}
