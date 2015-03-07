package com.teamNikAml.doctorpatient.fragments;

import java.util.ArrayList;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.database.Cursor;
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
import com.teamNikAml.doctorpatient.database.DatabaseConstants;
import com.teamNikAml.doctorpatient.database.IDatabaseUtility;
import com.teamNikAml.doctorpatient.database.PatientDetailAccess;

public class PatientFragment extends Fragment {

	private EditText searchView;
	private ListView listView;
	private ArrayAdapter<String> adapter;
	private Button button;

	private ArrayList<String> nameArry;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.fragment_new_patient_reg,
				container, false);

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
				t.commit();
			}
		});

		nameArry = new ArrayList<String>();

		IDatabaseUtility database = ((MyApplication) getActivity()
				.getApplication()).getPatientDetailAccess();
		if (database == null) {
			((MyApplication) getActivity().getApplication())
					.setPatientDetailAccess(new PatientDetailAccess(
							getActivity().getApplicationContext(), null, null,
							0));
			database = ((MyApplication) getActivity().getApplication())
					.getPatientDetailAccess();
		}

		Cursor temcursor = database.query(
				DatabaseConstants.TABLE_PATIENTDETAIL, new String[] {
						DatabaseConstants.PatientDetailTable.ID,
						DatabaseConstants.PatientDetailTable.NAME }, null,
				null, null, null, null);

		if (temcursor.moveToFirst()) {
			do {
				nameArry.add(temcursor.getString(1) + " \t" + "ID -"
						+ temcursor.getString(0));

			} while (temcursor.moveToNext());
		}

		adapter = new ArrayAdapter<String>(getActivity()
				.getApplicationContext(), android.R.layout.simple_list_item_1,
				nameArry);
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
/*				String item = ((TextView) arg1).getText().toString();

				Intent intent = new Intent(getApplicationContext(),
						ViewPatientRecord.class);
				intent.putExtra("name", item.substring(item.length() - 1));
				startActivity(intent);*/

			}
		});

		return rootView;
	}
}
