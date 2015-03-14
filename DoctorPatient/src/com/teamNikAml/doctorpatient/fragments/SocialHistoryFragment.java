package com.teamNikAml.doctorpatient.fragments;

import java.text.SimpleDateFormat;
import java.util.Calendar;

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
import com.teamNikAml.doctorpatient.database.DatabaseConstants;
import com.teamNikAml.doctorpatient.database.IDatabaseUtility;
import com.teamNikAml.doctorpatient.database.PatientDetailAccess;

public class SocialHistoryFragment  extends DialogFragment {

	Button save;
	EditText process, note;
	
	Bundle b;
	String s;
	IDatabaseUtility database;
	
	int flag =0;
	String selection;

	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = getActivity().getLayoutInflater().inflate(R.layout.fragment_social_history, null);
		save = (Button) view.findViewById(id.button_social_history);
		process = (EditText) view.findViewById(id.edittext_social_history);
		note = (EditText) view.findViewById(id.edittext_note_social_history);
		
		b = getArguments();
		s = b.getString("patient_id");
		
		database = new PatientDetailAccess(getActivity().getApplicationContext(), null, null,0);
		Cursor c = null;
		if (database != null) {
			selection = "id=?";
			String[] selectionArgs = {s};
		    c = database.query(DatabaseConstants.TABLE_SOCIALHISTORY, null,selection ,selectionArgs, null, null, null);

			
		}

		if (c.moveToFirst()) {

			process.setText(c.getString(1));
			note.setText(c.getString(2));
			flag = 1;
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
				
				ContentValues cv = new ContentValues();
				cv.put(DatabaseConstants.SocialHistory.ID, s);
				cv.put(DatabaseConstants.SocialHistory.PROCESS, p);
				cv.put(DatabaseConstants.SocialHistory.NOTES, n);
				cv.put(DatabaseConstants.SocialHistory.DATE, formattedDate);
				
				IDatabaseUtility database = new PatientDetailAccess(getActivity().getApplicationContext(), null, null,0);
				if (database != null) {
					if (flag == 0) {
						database.insert(DatabaseConstants.TABLE_SOCIALHISTORY, null, cv);
					} else {
						database.update(DatabaseConstants.TABLE_SOCIALHISTORY, cv, selection, new String[]{s});
					}
				}

				
				dlg.dismiss();
			}
		});
		return dlg;
	}

	
}
