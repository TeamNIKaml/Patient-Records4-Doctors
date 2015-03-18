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
	Button familyHistory, socialHistory, allergies, currentMedications;
	Button investigationsAndLabResults, PhysicalExamination, provisionalDiagnosis;
	Button differentialDiagnosis, systemExamination, caseSummary, recentVisit;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.fragment_patient_diagnosis,
				container, false);
		patientDetail = (Button) rootView.findViewById(id.button_patient_details_update);
		chiefComplaint = (Button) rootView.findViewById(id.button_chief_complaints);
		historyOfIllness = (Button) rootView.findViewById(id.button_history_of_illness);
		medicalHistory = (Button) rootView.findViewById(id.button_medical_history);
		familyHistory = (Button) rootView.findViewById(id.button_family_history);
		socialHistory = (Button) rootView.findViewById(id.button_social_history);
		allergies = (Button) rootView.findViewById(id.button_allergies);
		currentMedications = (Button) rootView.findViewById(id.button_current_medications);
		investigationsAndLabResults = (Button) rootView.findViewById(id.button_laboratory_results);
		PhysicalExamination = (Button) rootView.findViewById(id.button_physical_examination);
		provisionalDiagnosis = (Button) rootView.findViewById(id.button_provisional_diagnosis);		
		systemExamination = (Button) rootView.findViewById(id.button_system_examination);
		differentialDiagnosis = (Button) rootView.findViewById(id.button_differential_diagnosis);
		caseSummary = (Button) rootView.findViewById(id.button_case_summary);
		recentVisit = (Button) rootView.findViewById(id.button_view_patient_history);

		
		
		
		b = getArguments();
		String s = b.getString("patient_id");

		chiefComplaint.setOnClickListener(myListener);
		historyOfIllness.setOnClickListener(myListener);
		patientDetail.setOnClickListener(myListener);
		medicalHistory.setOnClickListener(myListener);
		familyHistory.setOnClickListener(myListener);
		socialHistory.setOnClickListener(myListener);
		allergies.setOnClickListener(myListener);
		currentMedications.setOnClickListener(myListener);
		investigationsAndLabResults.setOnClickListener(myListener);
		PhysicalExamination.setOnClickListener(myListener);
		provisionalDiagnosis.setOnClickListener(myListener);
		systemExamination.setOnClickListener(myListener);
		differentialDiagnosis.setOnClickListener(myListener);
		caseSummary.setOnClickListener(myListener);
		recentVisit.setOnClickListener(myListener);
		
		return rootView;
	}

	OnClickListener myListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			DialogFragment dialog = null;

			switch (v.getId()) {

			case id.button_patient_details_update:
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
			case id.button_social_history:
				dialog = new SocialHistoryFragment(); 
				break;
			case id.button_allergies:
				dialog = new AllergiesFragment();
				break;
			case id.button_current_medications:
				dialog = new CurrentMedicationsFragment();
				break;
			case id.button_laboratory_results:
				dialog = new InvestigationsAndLabResultsFragemnt();
				break;
			case id.button_physical_examination:
				dialog = new PhysicalExaminationFragment();
				break;
			case id.button_provisional_diagnosis:
				dialog = new ProvisionalDiagnosisFragment();
				break;
			case id.button_system_examination:
				dialog = new SystemExaminationFragment();
				break;
			case id.button_differential_diagnosis:
				dialog = new DifferentialDiagnosis();
				break;
			case id.button_case_summary:
				dialog = new CaseSummaryFragment();
				break;
			case id.button_view_patient_history:
				dialog = new RecentVisitFragment();
				break;
				
			default:
				break;
			}

			if (dialog != null) {
				dialog.setArguments(b);
				dialog.show(getFragmentManager(), "Process Dialog");
			}
		}
	};
}
