package com.teamNikAml.doctorpatient.fragments;

import java.util.ArrayList;

import com.teamNikAml.doctorpatient.activity.R;
import com.teamNikAml.doctorpatient.adaptor.PatientVisitDetailAdapter;
import com.teamNikAml.doctorpatient.adaptor.PatientVisitDetailObject;
import com.teamNikAml.doctorpatient.database.DatabaseConstants;
import com.teamNikAml.doctorpatient.database.IDatabaseUtility;
import com.teamNikAml.doctorpatient.database.PatientDetailAccess;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.ListView;

public class PatientVisitDetailFragment extends DialogFragment {
	
	 ArrayList<PatientVisitDetailObject> al = new ArrayList<PatientVisitDetailObject>(); 
	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		
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
					if (sb.length()>0) {
						sb.append("\n-----------------------------\n");
					}
					sb.append(temcursor.getString(2));
					if (temcursor.getString(2).length()>0) {
						sb.append("\n\n");	
					}
					sb.append(temcursor.getString(3));

					if (string.equals(DatabaseConstants.TABLE_CASESUMMARY)) {
						if (temcursor.getString(3).length()>0) {
							sb.append("\n");
						}
						sb.append("Fees - "+temcursor.getString(4));
					}
				} while (temcursor.moveToNext());
			}
			if (sb.length()>0) {
				String temp = string.replaceAll("Table", "").replaceAll("(.)(\\p{Lu})", "$1 $2");

				 al.add(new PatientVisitDetailObject(temp, sb));
			}
		}
		
		PatientVisitDetailObject[] objectItemData = new PatientVisitDetailObject[al.size()] ;
		al.toArray(objectItemData);
		PatientVisitDetailAdapter adapter = new PatientVisitDetailAdapter(getActivity().getApplicationContext(), R.layout.list_view_custom, objectItemData,getActivity().getLayoutInflater());
		ListView listViewItems = new ListView(getActivity().getApplicationContext());
		listViewItems.setAdapter(adapter);

		
		final Dialog dlg = new AlertDialog.Builder(getActivity()).setView(listViewItems).create();

		return dlg;
	}

}
