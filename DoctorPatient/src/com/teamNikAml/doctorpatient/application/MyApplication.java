package com.teamNikAml.doctorpatient.application;

import com.teamNikAml.doctorpatient.database.PatientDetailAccess;

import android.app.Application;

public class MyApplication extends Application {

	PatientDetailAccess patientDetailAccess;

	public MyApplication() {
		super();
		// TODO Auto-generated constructor stub
		this.patientDetailAccess = null;
	}

	public PatientDetailAccess getPatientDetailAccess() {
		return patientDetailAccess;
	}

	public void setPatientDetailAccess(PatientDetailAccess patientDetailAccess) {
		this.patientDetailAccess = patientDetailAccess;
	}
	
	

}