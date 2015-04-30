package com.teamNikAml.doctorpatient.fragments;

import java.util.ArrayList;

import com.teamNikAml.doctorpatient.activity.R;
import com.teamNikAml.doctorpatient.activity.R.id;
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
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

public class PatientVisitDetailFragment extends DialogFragment {
	
	Bundle b;
	ArrayList<PatientVisitDetailObject> al = new ArrayList<PatientVisitDetailObject>(); 
	
	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		
		View view = getActivity().getLayoutInflater().inflate(R.layout.fragment_visit_detail, null);
		ListView listView = (ListView) view.findViewById(id.listView_vist_detail);
		
		b = getArguments();
		String id = b.getString("patient_id");
		String date = b.getString("date");
		String time = b.getString("time");
		
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
				temcursor = database.query(string, null, "id=? AND date=? AND time=?" ,new String[]{id,date,time}, null, null, null);
			}
			sb = new StringBuilder();
			if (temcursor.moveToFirst()) {
				do {

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
				String temp = string.replaceAll("(.)(\\p{Lu})", "$1 $2");

				 al.add(new PatientVisitDetailObject(temp, sb));
			}
		}
		
		PatientVisitDetailObject[] objectItemData = new PatientVisitDetailObject[al.size()] ;
		al.toArray(objectItemData);
		PatientVisitDetailAdapter adapter = new PatientVisitDetailAdapter(getActivity().getApplicationContext(), R.layout.list_view_custom, objectItemData,getActivity().getLayoutInflater());
		ListView listViewItems = new ListView(getActivity().getApplicationContext());
		listViewItems.setAdapter(adapter);
		
		
		final Dialog dlg = new AlertDialog.Builder(getActivity()).setView(listViewItems).create();
		
		listView.setAdapter(adapter);
		final Dialog dlg1 = new AlertDialog.Builder(getActivity()).setView(view).create();
		listView.setOnItemLongClickListener(new OnItemLongClickListener() {

			@Override
			public boolean onItemLongClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub

				String process =  ((TextView)arg1.findViewById(R.id.textView_process)).getText().toString();
				String note =  ((TextView)arg1.findViewById(R.id.textView_process_note)).getText().toString();
				
				  b.putString("table", process);
				  b.putString("note", note);
				  DialogFragment dialog = new DetailUpdateFragment();
				  dialog.setArguments(b);
				  dialog.show(getFragmentManager(), "Detail Update");
				  
				return false;
			}


		});
		

		return dlg1;
	}

}
