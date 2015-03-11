package com.teamNikAml.doctorpatient.fragments;

import android.app.DialogFragment;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

import com.teamNikAml.doctorpatient.activity.R;
import com.teamNikAml.doctorpatient.activity.R.id;

public class PatientDiagnosisFragment extends Fragment {

	Bundle b;
	Button chiefComplaint, historyOfIllness;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		View rootView = inflater.inflate(R.layout.fragment_patient_diagnosis, container,
				false);
		chiefComplaint = (Button) rootView.findViewById(id.button_chief_complaints);
		historyOfIllness = (Button) rootView.findViewById(id.button_history_of_illness);
		
		b = getArguments();
		String s = b.getString("patient_id");

		chiefComplaint.setOnClickListener(myListener);
		historyOfIllness.setOnClickListener(myListener);
		return rootView;
	}
	
	OnClickListener myListener = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			DialogFragment dialog = null;
			if (v.getId() == id.button_chief_complaints) {
				 dialog = new ChiefComplaintFragment();
			}else if (v.getId() == id.button_history_of_illness) {
				 dialog = new HistoryOfThePresentIllness();
			}
			
			
			if (dialog != null) {
				dialog.setArguments(b);
				dialog.show(getChildFragmentManager(), "Process Dialog");
			}
		}
	};
}
