package com.teamNikAml.doctorpatient.fragments;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import com.teamNikAml.doctorpatient.activity.R;
import com.teamNikAml.doctorpatient.database.DatabaseConstants;
import com.teamNikAml.doctorpatient.database.IDatabaseUtility;
import com.teamNikAml.doctorpatient.database.PatientDetailAccess;
import com.teamNikAml.doctorpatient.graph.BarGraphFragment;
import com.teamNikAml.doctorpatient.graph.LineGraphFragment;
import com.teamNikAml.doctorpatient.graph.PieGraphFragment;

import android.app.Fragment;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.AdapterView.OnItemSelectedListener;

public class ManagementFragment extends Fragment {

	private ArrayAdapter<String> graphAdaptor,valueAdaptor;
	private List<String> graphList = new ArrayList<String>();

	private List<String> valueList = new ArrayList<String>();

	private LineGraphFragment lineGraphFragment;

	private BarGraphFragment barGraphFragment;

	private PieGraphFragment pieGraphFragment;

	private Spinner graphSpinner,valueSpinner;

	private String[] heading = { "January", "February", "March", "April", "May", "June",
		    "July", "August", "September", "October", "November", "December"};

	private double[] x = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
	private double[] income = { 2000, 2500, 2700, 3000, 2800, 3500, 1001, 2500, 3700, 2000, 2300, 2500 };

	private double[] expense = { 1001, 2500, 3700, 2000, 2300, 2500, 2000, 2500, 2700, 3000, 2800, 3500 };
	
	private String[] month = new String[12];
	private String[] year = new String[12];	
	private double[] newPatient = new double[12];
	private double[] noOfVisits = new double[12];	

	IDatabaseUtility database;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		database = new PatientDetailAccess(getActivity().getApplicationContext(), null, null,0);
		
		Calendar cal = Calendar.getInstance();
		int monthvalue = cal.get(Calendar.MONTH);
		int yearvalue = cal.get(Calendar.YEAR);
		int temp=monthvalue,j=11;
		for (int i = 0; i < 12; i++) {

			month[j] = heading[temp];
			year[j] = String.valueOf(yearvalue);
			
			String where = "%-";
			if (temp<9) {
				where = where+"0"+(temp+1)+"-"+yearvalue;
			}else{
				where = where+(temp+1)+"-"+yearvalue;
			}
			System.out.println(where);
			newPatient[j]=getNewPatientCount(where);
			
			if (temp==0) {
				temp=12;
				yearvalue--;
			}
			j--; temp--;
		}

		System.out.println(newPatient[11]);
		
		View rootView = inflater.inflate(R.layout.fragment_graph_container,
				container, false);

		init(rootView);

		return rootView;
	}

	private void init(View v) {
		// TODO Auto-generated method stub
		graphSpinner = (Spinner) v.findViewById(R.id.graphSpinner);
		
		valueSpinner = (Spinner) v.findViewById(R.id.valueSpinner);

		graphList.add("Line Graph");
		graphList.add("Bar Graph");
		graphList.add("Pie Chart");
		
		
		valueList.add("Income");
		valueList.add("Expense");
		valueList.add("Income vs Expense");

		graphAdaptor = new ArrayAdapter<String>(getActivity()
				.getApplicationContext(), R.layout.spinnertext, graphList);

		graphSpinner.setAdapter(graphAdaptor);
		
		
		valueAdaptor = new ArrayAdapter<String>(getActivity().getApplicationContext(),
				R.layout.spinnertext, valueList);

		valueSpinner.setAdapter(valueAdaptor);

		setLineGraphData("income");

		getFragmentManager().beginTransaction()
				.add(R.id.graph_container, lineGraphFragment).commit();

		checkFragment();

		graphSpinner.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int pos, long id) {
				// TODO Auto-generated method stub

				checkFragment();

			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub

			}
		});
		
		valueSpinner.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int pos, long id) {
				// TODO Auto-generated method stub

				checkFragment();

			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub

			}
		});
		
		

	}

	private void setPieGraphData(String name) {
		
		pieGraphFragment = new PieGraphFragment();

		if (name.equalsIgnoreCase("income")) {


			pieGraphFragment.setPieChartValues(income);
			pieGraphFragment.setPieFragmenttName(heading);
		}

		else if (name.equalsIgnoreCase("expense")) {


			pieGraphFragment.setPieChartValues(expense);
			pieGraphFragment.setPieFragmenttName(heading);
		}

		else {
			double[] value = { 16528, 13234 };
			String[] pieName = { "Income", "Expense" };

			pieGraphFragment.setPieChartValues(value);
			pieGraphFragment.setPieFragmenttName(pieName);

		}

		

	}

	private void setBarGraphData(String name) {
		// TODO Auto-generated method stub

		barGraphFragment = new BarGraphFragment();


		if (name.equalsIgnoreCase("income")) {

			barGraphFragment.setxHeading(heading);
			barGraphFragment.setyValue(income);

			barGraphFragment.SeriesAdd(name);
			barGraphFragment.SeriesRendererAdd(Color.BLUE, true);
			barGraphFragment.MultipleSeriesRendererInit(
					Color.argb(100, 50, 50, 50), Color.WHITE);
			barGraphFragment.MultipleSeriesRendererAdd();

		}

		else if (name.equalsIgnoreCase("expense")) {

			barGraphFragment.setxHeading(heading);
			barGraphFragment.setyValue(expense);

			barGraphFragment.SeriesAdd(name);
			barGraphFragment.SeriesRendererAdd(Color.GREEN, true);
			barGraphFragment.MultipleSeriesRendererInit(
					Color.argb(100, 50, 50, 50), Color.WHITE);
			barGraphFragment.MultipleSeriesRendererAdd();

		}

		else {

			barGraphFragment.setxHeading(heading);
			barGraphFragment.setyValue(income);

			barGraphFragment.SeriesAdd(name);
			barGraphFragment.SeriesRendererAdd(Color.BLUE, true);
			barGraphFragment.MultipleSeriesRendererInit(
					Color.argb(100, 50, 50, 50), Color.BLUE);
			barGraphFragment.MultipleSeriesRendererAdd();

			barGraphFragment.setxHeading(heading);
			barGraphFragment.setyValue(expense);

			barGraphFragment.SeriesAdd(name);
			barGraphFragment.SeriesRendererAdd(Color.GREEN, true);
			barGraphFragment.MultipleSeriesRendererAdd();

		}

	}

	private void setLineGraphData(String name) {
		// TODO Auto-generated method stub

		lineGraphFragment = new LineGraphFragment();

		if (name.equalsIgnoreCase("income")) {
			lineGraphFragment.setxValue(x);
			lineGraphFragment.setyValue(income);
			lineGraphFragment.setxHeading(heading);

			lineGraphFragment.SeriesAdd(name);
			lineGraphFragment.SeriesRendererAdd(Color.BLUE, true);
			lineGraphFragment.MultipleSeriesRendererInit(
					Color.argb(100, 50, 50, 50), Color.WHITE);
			lineGraphFragment.MultipleSeriesRendererAdd();
		}

		else if (name.equalsIgnoreCase("expense")) {

			lineGraphFragment.setxValue(x);
			lineGraphFragment.setyValue(expense);
			lineGraphFragment.setxHeading(heading);

			lineGraphFragment.SeriesAdd(name);
			lineGraphFragment.SeriesRendererAdd(Color.GREEN, true);
			lineGraphFragment.MultipleSeriesRendererInit(
					Color.argb(100, 50, 50, 50), Color.WHITE);
			lineGraphFragment.MultipleSeriesRendererAdd();

		}

		else {

			lineGraphFragment.setxValue(x);
			lineGraphFragment.setyValue(income);
			lineGraphFragment.setxHeading(heading);

			lineGraphFragment.SeriesAdd(name);
			lineGraphFragment.SeriesRendererAdd(Color.BLUE, true);
			lineGraphFragment.MultipleSeriesRendererInit(
					Color.argb(100, 50, 50, 50), Color.WHITE);
			lineGraphFragment.MultipleSeriesRendererAdd();

			lineGraphFragment.setyValue(expense);

			lineGraphFragment.SeriesAdd("expense");
			lineGraphFragment.SeriesRendererAdd(Color.GREEN, true);
			lineGraphFragment.MultipleSeriesRendererAdd();

		}

	}

	private void checkFragment() {
		// TODO Auto-generated method stub

		if (graphSpinner.getSelectedItem().toString() == "Bar Graph") {

			setBarGraphData(valueSpinner.getSelectedItem().toString());
			getFragmentManager().beginTransaction()
					.replace(R.id.graph_container, barGraphFragment).commit();

		} else if (graphSpinner.getSelectedItem().toString() == "Line Graph") {

			setLineGraphData(valueSpinner.getSelectedItem().toString());

			getFragmentManager().beginTransaction()
					.replace(R.id.graph_container, lineGraphFragment).commit();

		} else {
			setPieGraphData(valueSpinner.getSelectedItem().toString());
			getFragmentManager().beginTransaction()
					.replace(R.id.graph_container, pieGraphFragment).commit();

		}

	}
	
	int getNewPatientCount(String str){
		Cursor cursor = null;
		try{
			 cursor = database.rawQuery("SELECT COUNT (*) FROM " + DatabaseConstants.TABLE_PATIENTDETAIL + " WHERE " 
						+ DatabaseConstants.PatientDetailTable.DATE + " LIKE ?", new String[] { str });
		}catch(Exception e){

		}

		int count = 0;
		if (cursor != null) {
			if (cursor.moveToFirst()) {
			    count= cursor.getInt(0);
			}
			System.out.println("cursor is not null");
		    cursor.close();
		}
		return count;
	}

}
