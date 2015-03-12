package com.teamNikAml.doctorpatient.fragments;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.ContentValues;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
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

public class PatientDetailFragment extends DialogFragment {

	private Spinner sex;
	private String[] sexValues = { "Male", "Female" };
	private EditText name, age, email, contact, othernotes;
	private Button ok;
	Bundle bundle;
	String patientID ;
	IDatabaseUtility database;
    Dialog dlg;
	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		
		View view = getActivity().getLayoutInflater().inflate(R.layout.fragment_new_patient, null);
		
		sex = (Spinner) view.findViewById(id.spinner_sex);
		ArrayAdapter<String> mySexAdapter = new ArrayAdapter<String>(
				getActivity().getApplicationContext(), R.layout.spinner_layout,
				R.id.textView_spinnertext, sexValues);
		sex.setAdapter(mySexAdapter);
		name = (EditText) view.findViewById(id.edittext_name);
		age = (EditText) view.findViewById(id.edittext_age);
		email = (EditText) view.findViewById(id.edittext_email);
		contact = (EditText) view.findViewById(id.edittext_phone);
		othernotes = (EditText) view.findViewById(id.edittext_others);
		ok = (Button) view.findViewById(id.button_save_patient);
		
		bundle = getArguments();
		patientID = bundle.getString("patient_id");
		
		database = ((MyApplication) getActivity()
				.getApplication()).getPatientDetailAccess();
		if (database == null) {
			((MyApplication) getActivity().getApplication())
					.setPatientDetailAccess(new PatientDetailAccess(
							getActivity().getApplicationContext(),
							null, null, 0));
			database = ((MyApplication) getActivity().getApplication())
					.getPatientDetailAccess();
		}
		String selection = "_id=?";
		String[] selectionArgs = {patientID};
		Cursor c = database.query(DatabaseConstants.TABLE_PATIENTDETAIL, null,selection ,selectionArgs, null, null, null);
		//c = database.rawQuery("SELECT * FROM "+DatabaseConstants.TABLE_PATIENTDETAIL +" WHERE _id = ?", selectionArgs);
		
		if (c.moveToFirst()) {
			name.setText(c.getString(1));
			if (c.getString(2).equals("Female")) {
				sex.setSelection(1);
			}
			age.setText(c.getString(3));
			email.setText(c.getString(4));
			contact.setText(c.getString(5));
			othernotes.setText(c.getString(6));
		}
		
		dlg = new AlertDialog.Builder(getActivity()).setView(view).create();
		
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
				if (database != null) {
					String selection = "_id=?";
					String[] selectionArgs = {patientID};
					database.update(DatabaseConstants.TABLE_PATIENTDETAIL, cv, selection, selectionArgs);
				}
				
				dlg.dismiss();
			}
			
		});
		
		return dlg;
	}
	
	

}
