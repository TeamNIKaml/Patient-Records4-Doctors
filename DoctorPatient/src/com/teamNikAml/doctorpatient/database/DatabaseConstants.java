package com.teamNikAml.doctorpatient.database;

public class DatabaseConstants {
	
	public static final String DATABASE_NAME = "PatientRecordsDatabase";
	public static final int DATABASE_VERSION = 1;
	
	/*********************************************************************************/
	
	public static final String TABLE_PATIENTDETAIL = "PatientDetailTable";

	public static class PatientDetailTable {
		public static final String ID = "_id";
		public static final String NAME = "name";
		public static final String SEX = "sex";
		public static final String AGE = "age";
		public static final String EMAIL = "email";
		public static final String CONTACTNO = "contactno";
		public static final String OTHERNOTES = "othernotes";

	}

	public static final	String CREATE_TABLE_PATIENTDETAIL = 
			"create table if not exists " + TABLE_PATIENTDETAIL + " ( "
			+ PatientDetailTable.ID + " INTEGER PRIMARY KEY, "
			+ PatientDetailTable.NAME + " VARACHAR, "
			+ PatientDetailTable.SEX + " VARACHAR, "
			+ PatientDetailTable.AGE + " INTEGER, "
			+ PatientDetailTable.EMAIL + " VARACHAR, "
			+ PatientDetailTable.CONTACTNO + " VARACHAR, "
			+ PatientDetailTable.OTHERNOTES + " VARACHAR);" ;
	
	/************************************************************************************/

	public static final String TABLE_PRESENTINGILLNESS = "PresentingIllnessTable";
	
	public static class PresentingIllness {
		public static final String ID ="id";
		public static final String PRESENTINGILLNESS = "presentingillness";
		public static final String NOTES = "pinotes";
	}
	
	public static final	String CREATE_TABLE_PRESENTINGILLNESS = 
			"create table if not exists " + TABLE_PRESENTINGILLNESS + " ( "
			+ PresentingIllness.ID + " INTEGER PRIMARY KEY, "
			+ PresentingIllness.PRESENTINGILLNESS + " VARACHAR, "
			+ PresentingIllness.NOTES + " VARACHAR);" ;
	
	
	/************************************************************************************/
	
	public static final String TABLE_PROVISIONALDIAGNOSIS = "ProvisionalDiagnosisTable";
	
	public static class Provisionaldiagnosis {
		public static final String ID ="id";
		public static final String PROVISIONALDIAGNOSIS = "provisionaldiagnosis";
		public static final String NOTES = "pdnotes";
	}
	
	public static final	String CREATE_TABLE_PROVISIONALDIAGNOSIS = 
			"create table if not exists " + TABLE_PROVISIONALDIAGNOSIS + " ( "
			+ Provisionaldiagnosis.ID + " INTEGER PRIMARY KEY, "
			+ Provisionaldiagnosis.PROVISIONALDIAGNOSIS + " VARACHAR, "
			+ Provisionaldiagnosis.NOTES + " VARACHAR);" ;
	
	/****************************************************************************************/
	
	public static final String TABLE_INVESTIGATION = "InvestigationTable";
	
	public static class Investigation {
		public static final String ID ="id";
		public static final String INVESTIGATION = "investigation";
		public static final String NOTES = "investigationnotes";
	}
	
	public static final	String CREATE_TABLE_INVESTIGATION = 
			"create table if not exists " + TABLE_INVESTIGATION + " ( "
			+ Investigation.ID + " INTEGER PRIMARY KEY, "
			+ Investigation.INVESTIGATION + " VARACHAR, "
			+ Investigation.NOTES + " VARACHAR);" ;
	
	/**************************************************************************************/
	
	public static final String TABLE_EXAMINATION = "ExaminationTable";
	
	public static class Examination {
		public static final String ID ="id";
		public static final String EXAMINATION = "examination";
		public static final String NOTES = "examinationnotes";
	}
	
	public static final	String CREATE_TABLE_EXAMINATION = 
			"create table if not exists " + TABLE_EXAMINATION + " ( "
			+ Examination.ID + " INTEGER PRIMARY KEY, "
			+ Examination.EXAMINATION + " VARACHAR, "
			+ Examination.NOTES + " VARACHAR);" ;
	
	/*************************************************************************************/
	
	public static final String TABLE_FINALDIAGNOSIS = "FinaldiagnosisTable";
	
	public static class Finaldiagnosis {
		public static final String ID ="id";
		public static final String FINALDIAGNOSIS = "finaldiagnosis";
		public static final String NOTES = "fdnotes";
	}
	
	public static final	String CREATE_TABLE_FINALDIAGNOSIS = 
			"create table if not exists " + TABLE_FINALDIAGNOSIS + " ( "
			+ Finaldiagnosis.ID + " INTEGER PRIMARY KEY, "
			+ Finaldiagnosis.FINALDIAGNOSIS + " VARACHAR, "
			+ Finaldiagnosis.NOTES + " VARACHAR);" ;
	
	/****************************************************************************************/
}
