package com.teamNikAml.doctorpatient.application;

import java.util.ArrayList;

import com.teamNikAml.doctorpatient.database.DatabaseConstants;
import com.teamNikAml.doctorpatient.database.IDatabaseUtility;
import com.teamNikAml.doctorpatient.database.PatientDetailAccess;

import android.app.Application;
import android.database.Cursor;

public class MyApplication extends Application {

	private ArrayList<String> nameArry = null;
	private PatientDiagnosisCache patientdiagnosischache;
	private GeneralClass generalClass;

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		setPatientNamesWithId();
		setPatientdiagnosischache();
	}

	public void setPatientNamesWithId() {

		Thread t = new Thread() {

			public void run() {

				nameArry = new ArrayList<String>();

				IDatabaseUtility database = new PatientDetailAccess(
						getApplicationContext(), null, null, 0);
				Cursor temcursor = null;
				if (database != null) {
					temcursor = database
							.query(DatabaseConstants.TABLE_PATIENTDETAIL,
									new String[] {
											DatabaseConstants.PatientDetailTable.ID,
											DatabaseConstants.PatientDetailTable.NAME },
									null, null, null, null, null);
				}

				if (temcursor.moveToFirst()) {
					do {
						nameArry.add(temcursor.getString(1) + " \t" + "ID -"
								+ temcursor.getString(0));

					} while (temcursor.moveToNext());
				}
			}
		};

		t.start();

	}
	
	public ArrayList<String> getPatientNamesWithId(){
		return nameArry;
		
	}
	
	public void addNewPatientNamewithIdToList(String nameWithId){
		nameArry.add(nameWithId);
	}

	public PatientDiagnosisCache getPatientdiagnosischache() {
		return patientdiagnosischache;
	}

	public void setPatientdiagnosischache() {
		this.patientdiagnosischache = new PatientDiagnosisCache();
	}

	public void initializeGeneralClass(){
		generalClass = new GeneralClass();
	}
	public GeneralClass getGeneralClass(){
		return generalClass;
	}
	
}