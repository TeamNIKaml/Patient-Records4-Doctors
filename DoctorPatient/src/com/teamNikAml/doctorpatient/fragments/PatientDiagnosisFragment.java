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
	Button chiefComplaint, historyOfIllness, patientDetail, medicalHistory;
	Button familyHistory;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.fragment_patient_diagnosis,
				container, false);
		chiefComplaint = (Button) rootView.findViewById(id.button_chief_complaints);
		historyOfIllness = (Button) rootView.findViewById(id.button_history_of_illness);
		patientDetail = (Button) rootView.findViewById(id.button_patient_details_update);
		medicalHistory = (Button) rootView.findViewById(id.button_medical_history);
		familyHistory = (Button) rootView.findViewById(id.button_family_history);
		
		b = getArguments();
		String s = b.getString("patient_id");

		chiefComplaint.setOnClickListener(myListener);
		historyOfIllness.setOnClickListener(myListener);
		patientDetail.setOnClickListener(myListener);
		medicalHistory.setOnClickListener(myListener);
		familyHistory.setOnClickListener(myListener);
		return rootView;
	}

	OnClickListener myListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			DialogFragment dialog = null;

			switch (v.getId()) {

			case id.button_patient_details_update:
				System.out.println("+++++++++++++++");
				dialog = new PatientDetailFragment();
				break;
			case id.button_chief_complaints:
				dialog = new ChiefComplaintFragment();
				break;
			case id.button_history_of_illness:
				dialog = new HistoryOfThePresentIllness();
				break;
			case id.button_medical_history:
				dialog = new PastMedicalHistoryFragment();
				break;
			case id.button_family_history:
				dialog = new FamilyDiseasesFragment(); 
				break;
				
				
			default:
				break;
			}

			if (dialog != null) {
				dialog.setArguments(b);
				dialog.show(getChildFragmentManager(), "Process Dialog");
			}
		}
	};
}
