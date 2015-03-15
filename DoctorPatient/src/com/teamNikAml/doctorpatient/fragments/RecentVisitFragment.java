package com.teamNikAml.doctorpatient.fragments;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.teamNikAml.doctorpatient.activity.R;
import com.teamNikAml.doctorpatient.activity.R.id;
import com.teamNikAml.doctorpatient.database.DatabaseConstants;
import com.teamNikAml.doctorpatient.database.IDatabaseUtility;
import com.teamNikAml.doctorpatient.database.PatientDetailAccess;

public class RecentVisitFragment extends DialogFragment{

	ListView listView;
	HashSet <String> dateArry;
	private ArrayAdapter<String> adapter;
	
	Bundle b;
	String s;
	IDatabaseUtility database;
	
	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		
		View view = getActivity().getLayoutInflater().inflate(R.layout.fragment_recent_visit, null);
		listView = (ListView) view.findViewById(id.listView_recent_visit);
		
		dateArry = new HashSet<String>();
		database = new PatientDetailAccess(getActivity().getApplicationContext(), null, null,0);
		final Dialog dlg = new AlertDialog.Builder(getActivity()).setView(view).create();

		Cursor temcursor = null;
		b = getArguments();
		s = b.getString("patient_id");
		if (database != null) {
			temcursor = database.query(DatabaseConstants.TABLE_CASESUMMARY, new String[] {
							DatabaseConstants.CaseSummary.DATE },"id=?" ,new String[]{s}, null, null, null);
		}

		if (temcursor.moveToFirst()) {
			do {
				dateArry.add(temcursor.getString(0) + " \t" + "Fees -");

			} while (temcursor.moveToNext());
		}
		ArrayList<String> tempdateArry = new ArrayList<String>(dateArry);
		Collections.reverse(tempdateArry);
		adapter = new ArrayAdapter<String>(getActivity()
				.getApplicationContext(), R.layout.patient_list_view,
				R.id.textView_patient_listview, tempdateArry);
		listView.setAdapter(adapter);
				
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				
				  String item =  ((TextView)arg1.findViewById(id.textView_patient_listview)).getText().toString();
				  Bundle args = new Bundle();
				  int i = item.indexOf(' ');
				  args.putString("date",item.substring(0, i)); 
				  args.putString("patient_id",s); 

				  DialogFragment dialog = new PatientVisitDetailFragment();
				  dialog.setArguments(args);
				  dialog.show(getChildFragmentManager(), "Visit Detail");
			}
		});
		
		

		return dlg;
	}

	
}
