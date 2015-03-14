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

	public static final String TABLE_CHIEFCOMPLAINT = "ChiefComplaintTable";
	
	public static class ChiefComplaint {
		public static final String ID ="id";
		public static final String PROCESS = "chiefcomplaint";
		public static final String NOTES = "notes";
		public static final String DATE = "date";
	}
	
	public static final	String CREATE_TABLE_CHIEFCOMPLAINT = 
			"create table if not exists " + TABLE_CHIEFCOMPLAINT + " ( "
			+ ChiefComplaint.ID + " INTEGER, "
			+ ChiefComplaint.PROCESS + " VARACHAR, "
			+ ChiefComplaint.NOTES + " VARACHAR, "
			+ ChiefComplaint.DATE + " VARACHAR);" ;
	
	
	/************************************************************************************/
	
	public static final String TABLE_HISTORYOFTHEPRESENTILLNESS = "HistoryOfThePresentIllness";
	
	public static class HistoryOfThePresentIllness {
		public static final String ID ="id";
		public static final String PROCESS = "historyofthepresentillness";
		public static final String NOTES = "notes";
		public static final String DATE = "date";
	}
	
	public static final	String CREATE_TABLE_HISTORYOFTHEPRESENTILLNESS = 
			"create table if not exists " + TABLE_HISTORYOFTHEPRESENTILLNESS + " ( "
			+ HistoryOfThePresentIllness.ID + " INTEGER, "
			+ HistoryOfThePresentIllness.PROCESS + " VARACHAR, "
			+ HistoryOfThePresentIllness.NOTES + " VARACHAR, "
			+ HistoryOfThePresentIllness.DATE + " VARACHAR);" ;
	
	/****************************************************************************************/
	
	public static final String TABLE_PASTMEDICALHISTORY = "PastMedicalHistory";
	
	public static class PastMedicalHistory {
		public static final String ID ="id";
		public static final String PROCESS = "pastmedicalhistory";
		public static final String NOTES = "notes";
		public static final String DATE = "date";
	}
	
	public static final	String CREATE_TABLE_PASTMEDICALHISTORY = 
			"create table if not exists " + TABLE_PASTMEDICALHISTORY + " ( "
			+ PastMedicalHistory.ID + " INTEGER PRIMARY KEY NOT NULL, "
			+ PastMedicalHistory.PROCESS + " VARACHAR, "
			+ PastMedicalHistory.NOTES + " VARACHAR, "
			+ PastMedicalHistory.DATE + " VARACHAR);" ;
	
	/**************************************************************************************/
	
	public static final String TABLE_CURRENTMEDICATIONS = "CurrentMedications";
	
	public static class CurrentMedications {
		public static final String ID ="id";
		public static final String PROCESS = "currentmedications";
		public static final String NOTES = "notes";
		public static final String DATE = "date";
	}
	
	public static final	String CREATE_TABLE_CURRENTMEDICATIONS = 
			"create table if not exists " + TABLE_CURRENTMEDICATIONS + " ( "
			+ CurrentMedications.ID + " INTEGER, "
			+ CurrentMedications.PROCESS + " VARACHAR, "
			+ CurrentMedications.NOTES + " VARACHAR, "
			+ CurrentMedications.DATE + " VARACHAR);" ;
	
	/*************************************************************************************/
	
	public static final String TABLE_FAMILYDISEASES = "FamilyDiseases";
	
	public static class FamilyDiseases {
		public static final String ID ="id";
		public static final String PROCESS = "familydiseases";
		public static final String NOTES = "notes";
		public static final String DATE = "date";
	}
	
	public static final	String CREATE_TABLE_FAMILYDISEASES = 
			"create table if not exists " + TABLE_FAMILYDISEASES + " ( "
			+ FamilyDiseases.ID + " INTEGER PRIMARY KEY NOT NULL, "
			+ FamilyDiseases.PROCESS + " VARACHAR, "
			+ FamilyDiseases.NOTES + " VARACHAR, "
			+ FamilyDiseases.DATE + " VARACHAR);" ;
	
	/****************************************************************************************/
	
	public static final String TABLE_PHYSICALEXAMINATION = "PhysicalExamination";
	
	public static class PhysicalExamination {
		public static final String ID ="id";
		public static final String PROCESS = "physicalexamination";
		public static final String NOTES = "notes";
		public static final String DATE = "date";
	}
	
	public static final	String CREATE_TABLE_PHYSICALEXAMINATION = 
			"create table if not exists " + TABLE_PHYSICALEXAMINATION + " ( "
			+ PhysicalExamination.ID + " INTEGER, "
			+ PhysicalExamination.PROCESS + " VARACHAR, "
			+ PhysicalExamination.NOTES + " VARACHAR, "
			+ PhysicalExamination.DATE + " VARACHAR);" ;
	
	/****************************************************************************************/
	
	public static final String TABLE_SOCIALHISTORY = "SocialHistory";
	
	public static class SocialHistory {
		public static final String ID ="id";
		public static final String PROCESS = "socialhistory";
		public static final String NOTES = "notes";
		public static final String DATE = "date";
	}
	
	public static final	String CREATE_TABLE_SOCIALHISTORY = 
			"create table if not exists " + TABLE_SOCIALHISTORY + " ( "
			+ SocialHistory.ID + " INTEGER PRIMARY KEY NOT NULL, "
			+ SocialHistory.PROCESS + " VARACHAR, "
			+ SocialHistory.NOTES + " VARACHAR, "
			+ SocialHistory.DATE + " VARACHAR);" ;
	
	/****************************************************************************************/
	
	public static final String TABLE_ALLERGIES = "Allergies";
	
	public static class Allergies {
		public static final String ID ="id";
		public static final String PROCESS = "allergies";
		public static final String NOTES = "notes";
		public static final String DATE = "date";
	}
	
	public static final	String CREATE_TABLE_ALLERGIES = 
			"create table if not exists " + TABLE_ALLERGIES + " ( "
			+ Allergies.ID + " INTEGER PRIMARY KEY NOT NULL, "
			+ Allergies.PROCESS + " VARACHAR, "
			+ Allergies.NOTES + " VARACHAR, "
			+ Allergies.DATE + " VARACHAR);" ;
	
	/****************************************************************************************/
	
	public static final String TABLE_INVESTIGATIONSANDLABRESULTS = "InvestigationsAndLabResults";
	
	public static class InvestigationsAndLabResults {
		public static final String ID ="id";
		public static final String PROCESS = "investigationsandlabresults";
		public static final String NOTES = "notes";
		public static final String DATE = "date";
	}
	
	public static final	String CREATE_TABLE_INVESTIGATIONSANDLABRESULTS = 
			"create table if not exists " + TABLE_INVESTIGATIONSANDLABRESULTS + " ( "
			+ InvestigationsAndLabResults.ID + " INTEGER, "
			+ InvestigationsAndLabResults.PROCESS + " VARACHAR, "
			+ InvestigationsAndLabResults.NOTES + " VARACHAR, "
			+ InvestigationsAndLabResults.DATE + " VARACHAR);" ;
	
	/****************************************************************************************/
	
	
	public static final String TABLE_PROVISIONALDIAGNOSIS = "ProvisionalDiagnosis";
	
	public static class ProvisionalDiagnosis {
		public static final String ID ="id";
		public static final String PROCESS = "provisionaldiagnosis";
		public static final String NOTES = "notes";
		public static final String DATE = "date";
	}
	
	public static final	String CREATE_TABLE_PROVISIONALDIAGNOSIS = 
			"create table if not exists " + TABLE_PROVISIONALDIAGNOSIS + " ( "
			+ ProvisionalDiagnosis.ID + " INTEGER, "
			+ ProvisionalDiagnosis.PROCESS + " VARACHAR, "
			+ ProvisionalDiagnosis.NOTES + " VARACHAR, "
			+ ProvisionalDiagnosis.DATE + " VARACHAR);" ;
	
	/****************************************************************************************/
	
}
