package com.teamNikAml.doctorpatient.application;

import com.teamNikAml.doctorpatient.database.PatientDetailAccess;

import android.app.Application;

public class MyApplication extends Application {

	PatientDetailAccess patientDetailAccess;


	public PatientDetailAccess getPatientDetailAccess() {
		return patientDetailAccess;
	}

	public void setPatientDetailAccess(PatientDetailAccess patientDetailAccess) {
		this.patientDetailAccess = patientDetailAccess;
	}

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		patientDetailAccess = new PatientDetailAccess(getApplicationContext(), null, null, 0);
	}
	
	

}