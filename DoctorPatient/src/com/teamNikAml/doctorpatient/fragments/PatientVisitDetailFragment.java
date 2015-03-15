package com.teamNikAml.doctorpatient.fragments;

import com.teamNikAml.doctorpatient.activity.R;
import com.teamNikAml.doctorpatient.activity.R.id;
import com.teamNikAml.doctorpatient.database.DatabaseConstants;
import com.teamNikAml.doctorpatient.database.IDatabaseUtility;
import com.teamNikAml.doctorpatient.database.PatientDetailAccess;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class PatientVisitDetailFragment extends DialogFragment {
	
	 StringBuilder finalreport = new StringBuilder();
	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = getActivity().getLayoutInflater().inflate(R.layout.fragment_visit_detail, null);
		TextView detail = (TextView) view.findViewById(id.textView_visit_detail);
		
		Bundle b = getArguments();
		String id = b.getString("patient_id");
		String date = b.getString("date");
		
		IDatabaseUtility database = new PatientDetailAccess(getActivity().getApplicationContext(), null, null,0);
		Cursor temcursor = null;
		String[] tables = {DatabaseConstants.TABLE_CHIEFCOMPLAINT,DatabaseConstants.TABLE_HISTORYOFTHEPRESENTILLNESS,
				DatabaseConstants.TABLE_CURRENTMEDICATIONS,DatabaseConstants.TABLE_PHYSICALEXAMINATION,
				DatabaseConstants.TABLE_SYSTEMEXAMINATION,DatabaseConstants.TABLE_DIFFERENTIALDIAGNOSIS,
				DatabaseConstants.TABLE_PROVISIONALDIAGNOSIS,DatabaseConstants.TABLE_INVESTIGATIONSANDLABRESULTS,
				DatabaseConstants.TABLE_CASESUMMARY};
		StringBuilder sb = null;
		for (String string : tables) {
			
			if (database != null) {
				temcursor = database.query(string, null, "id=? AND date=?" ,new String[]{id,date}, null, null, null);
			}
			sb = new StringBuilder();
			if (temcursor.moveToFirst()) {
				do {
					sb.append(temcursor.getString(1));
					//sb.append("\n");
					sb.append(temcursor.getString(2));
					sb.append("\n");
				} while (temcursor.moveToNext());
			}
			if (sb.length()>0) {
				String temp = string.replaceAll("Table", "").replaceAll("(.)(\\p{Lu})", "$1 $2");
				finalreport.append(temp);
				finalreport.append("\n");
				finalreport.append("-------------------------------\n");
				finalreport.append(sb);
				finalreport.append("\n");
			}
			
		}
		
		if (sb != null) {
			detail.setText(finalreport);
		}
		
		final Dialog dlg = new AlertDialog.Builder(getActivity()).setView(view).create();

		return dlg;
	}

}
