package com.teamNikAml.doctorpatient.fragments;

import java.util.ArrayList;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.teamNikAml.doctorpatient.activity.R;
import com.teamNikAml.doctorpatient.activity.R.id;
import com.teamNikAml.doctorpatient.application.MyApplication;
import com.teamNikAml.doctorpatient.application.PatientDiagnosisCache;

public class PatientFragment extends Fragment {

	private EditText searchView;
	private ListView listView;
	private ArrayAdapter<String> adapter;
	private Button button;

	private ArrayList<String> nameArry = null;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.fragment_patients, container,
				false);

		searchView = (EditText) rootView.findViewById(R.id.editText_search);
		listView = (ListView) rootView.findViewById(R.id.list_patientName);
		button = (Button) rootView.findViewById(id.button_newPatient);

		button.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				FragmentTransaction t = getActivity().getFragmentManager()
						.beginTransaction();
				Fragment mFrag = new NewPatientFragment();
				t.replace(R.id.frame_container, mFrag);
				//t.addToBackStack(null);
				t.commit();
			}
		});

		
		MyApplication myApp = (MyApplication) getActivity().getApplication();
		nameArry = myApp.getPatientNamesWithId();
		if (nameArry == null) {
			myApp.setPatientNamesWithId();
			nameArry = myApp.getPatientNamesWithId();
		}
		
		adapter = new ArrayAdapter<String>(getActivity()
				.getApplicationContext(), R.layout.patient_list_view,
				R.id.textView_patient_listview, nameArry);
		listView.setAdapter(adapter);
		listView.setTextFilterEnabled(true);
		searchView.addTextChangedListener(new TextWatcher() {

			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				// TODO Auto-generated method stub
				if (s.length() > 0) {
					listView.setFilterText(s.toString());
				} else {
					listView.clearTextFilter();
				}
			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub

			}

			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub

			}
		});

		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				
				  String item =  ((TextView)arg1.findViewById(id.textView_patient_listview)).getText().toString();
				  Bundle args = new Bundle();
				  String pid = item.substring(item.lastIndexOf("-")+1);
				  args.putString("patient_id",pid); 
					
				  MyApplication myApp = (MyApplication) getActivity().getApplication();
				  PatientDiagnosisCache pdc = myApp.getPatientdiagnosischache();
				  if (pdc.getPatientId() != Integer.parseInt(pid)) {
					pdc.reSetPatientCache();
					pdc.setPatientId(Integer.parseInt(pid));
					myApp.initializeGeneralClass();
				  } 
				
				FragmentTransaction t = getActivity().getFragmentManager()
						.beginTransaction();
				Fragment mFrag = new PatientDiagnosisFragment();
				mFrag.setArguments(args);
				t.replace(R.id.frame_container, mFrag);
				//t.addToBackStack(null);
				t.commit();

			}
		});

		return rootView;
	}
}
