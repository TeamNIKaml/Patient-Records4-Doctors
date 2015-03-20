package com.teamNikAml.doctorpatient.fragments;

import java.util.ArrayList;
import java.util.Calendar;
import android.app.Fragment;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.AdapterView.OnItemSelectedListener;

import com.teamNikAml.doctorpatient.activity.R;
import com.teamNikAml.doctorpatient.activity.R.id;
import com.teamNikAml.doctorpatient.database.DatabaseConstants;
import com.teamNikAml.doctorpatient.database.IDatabaseUtility;
import com.teamNikAml.doctorpatient.database.PatientDetailAccess;

public class BillFragment extends Fragment {

	private Spinner incomeSpinner;
	private ListView incomeListView;
	private ArrayAdapter<String> spinnerAdapter, listAdapter;
	private ArrayList<String> adapterList;
	IDatabaseUtility database;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.fragment_bills, container,
				false);
		
		incomeSpinner = (Spinner) rootView.findViewById(id.spinner_income);
		incomeListView = (ListView) rootView.findViewById(id.listView_income);

		spinnerAdapter = new ArrayAdapter<String>(getActivity(), R.layout.spinnertext, new String[]{"This Month","This Year"});
		incomeSpinner.setAdapter(spinnerAdapter);
		
		incomeSpinner.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int pos, long id) {
				// TODO Auto-generated method stub
				adapterList = new ArrayList<String>();
				database = new PatientDetailAccess(getActivity().getApplicationContext(), null, null,0);
				Calendar c = Calendar.getInstance();
				int year = c.get(Calendar.YEAR);
				int month = c.get(Calendar.MONTH)+1;
				if (incomeSpinner.getSelectedItem().toString().equals("This Month")) {
					String mon="";
					if (month<10) {
						mon = "0"+month;
					}
					for (int i = c.get(Calendar.DAY_OF_MONTH); i > 0; i--) {
						adapterList.add(fetchDataByDay(i+"-"+mon+"-"+year));
					}

				} else {
					 String[] heading = { "January", "February", "March", "April", "May", "June",
						    "July", "August", "September", "October", "November", "December"};
					 for (int i = month-1; i >=0; i--) {
						 String temp = "%-";
						 if (i<9) {
							 temp = "%-0";
						}
						adapterList.add(heading[i]+"  "+fetchDataByMonth(temp+(i+1)+"-"+year));
						System.out.println(temp+(i+1)+"-"+year);
					}
				}
				listAdapter = new ArrayAdapter<String>(getActivity().getApplicationContext(), R.layout.patient_list_view,
						R.id.textView_patient_listview, adapterList);
				incomeListView.setAdapter(listAdapter);
				
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub

			}
		});
		
		return rootView;
	}
	
	String fetchDataByDay(String str){
		Cursor cursor = null;
		String result = "";
		try{
			 cursor = database.rawQuery("SELECT "+DatabaseConstants.CaseSummary.FEES+" FROM " + DatabaseConstants.TABLE_CASESUMMARY + " WHERE " 
						+ DatabaseConstants.PatientDetailTable.DATE + "=?", new String[] { str });
		}catch(Exception e){

		}
		int count = 0;
		if (cursor != null) {
			result = str+"  Appointments- "+cursor.getCount();
			if (cursor.moveToFirst()) {
				do {
					count = count + cursor.getInt(0);

				} while (cursor.moveToNext());
			}
			result = result + "  Income- "+ count;
		    cursor.close();
		}
		return result;
	}
	
	String fetchDataByMonth(String str){
		Cursor cursor = null;
		String result = "";
		try{
			 cursor = database.rawQuery("SELECT "+DatabaseConstants.CaseSummary.FEES+" FROM " + DatabaseConstants.TABLE_CASESUMMARY + " WHERE " 
						+ DatabaseConstants.PatientDetailTable.DATE + " LIKE ?", new String[] { str });
		}catch(Exception e){

		}
		int count = 0;
		if (cursor != null) {
			result = "  Appointments- "+cursor.getCount();
			if (cursor.moveToFirst()) {
				do {
					count = count + cursor.getInt(0);

				} while (cursor.moveToNext());
			}
			result = result + "  Income- "+ count;
		    cursor.close();
		}
		return result;
	}
}
