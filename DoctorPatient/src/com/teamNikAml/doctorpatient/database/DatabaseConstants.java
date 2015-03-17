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
		public static final String TID = "_id";
		public static final String ID ="id";
		public static final String PROCESS = "chiefcomplaint";
		public static final String NOTES = "notes";
		public static final String DATE = "date";
	}
	
	public static final	String CREATE_TABLE_CHIEFCOMPLAINT = 
			"create table if not exists " + TABLE_CHIEFCOMPLAINT + " ( "
			+ ChiefComplaint.TID + " INTEGER PRIMARY KEY, "
			+ ChiefComplaint.ID + " INTEGER, "
			+ ChiefComplaint.PROCESS + " VARACHAR, "
			+ ChiefComplaint.NOTES + " VARACHAR, "
			+ ChiefComplaint.DATE + " VARACHAR);" ;
	
	
	/************************************************************************************/
	
	public static final String TABLE_HISTORYOFTHEPRESENTILLNESS = "HistoryOfThePresentIllness";
	
	public static class HistoryOfThePresentIllness {
		public static final String TID = "_id";
		public static final String ID ="id";
		public static final String PROCESS = "historyofthepresentillness";
		public static final String NOTES = "notes";
		public static final String DATE = "date";
	}
	
	public static final	String CREATE_TABLE_HISTORYOFTHEPRESENTILLNESS = 
			"create table if not exists " + TABLE_HISTORYOFTHEPRESENTILLNESS + " ( "
			+ HistoryOfThePresentIllness.TID + " INTEGER PRIMARY KEY, "
			+ HistoryOfThePresentIllness.ID + " INTEGER, "
			+ HistoryOfThePresentIllness.PROCESS + " VARACHAR, "
			+ HistoryOfThePresentIllness.NOTES + " VARACHAR, "
			+ HistoryOfThePresentIllness.DATE + " VARACHAR);" ;
	
	/****************************************************************************************/
	
	public static final String TABLE_PASTMEDICALHISTORY = "PastMedicalHistory";
	
	public static class PastMedicalHistory {
		public static final String TID = "_id";
		public static final String ID ="id";
		public static final String PROCESS = "pastmedicalhistory";
		public static final String NOTES = "notes";
		public static final String DATE = "date";
	}
	
	public static final	String CREATE_TABLE_PASTMEDICALHISTORY = 
			"create table if not exists " + TABLE_PASTMEDICALHISTORY + " ( "
			+ PastMedicalHistory.TID + " INTEGER PRIMARY KEY, "
			+ PastMedicalHistory.ID + " INTEGER UNIQUE NOT NULL, "
			+ PastMedicalHistory.PROCESS + " VARACHAR, "
			+ PastMedicalHistory.NOTES + " VARACHAR, "
			+ PastMedicalHistory.DATE + " VARACHAR);" ;
	
	/**************************************************************************************/
	
	public static final String TABLE_CURRENTMEDICATIONS = "CurrentMedications";
	
	public static class CurrentMedications {
		public static final String TID = "_id";
		public static final String ID ="id";
		public static final String PROCESS = "currentmedications";
		public static final String NOTES = "notes";
		public static final String DATE = "date";
	}
	
	public static final	String CREATE_TABLE_CURRENTMEDICATIONS = 
			"create table if not exists " + TABLE_CURRENTMEDICATIONS + " ( "
			+ CurrentMedications.TID + " INTEGER PRIMARY KEY, "
			+ CurrentMedications.ID + " INTEGER, "
			+ CurrentMedications.PROCESS + " VARACHAR, "
			+ CurrentMedications.NOTES + " VARACHAR, "
			+ CurrentMedications.DATE + " VARACHAR);" ;
	
	/*************************************************************************************/
	
	public static final String TABLE_FAMILYDISEASES = "FamilyDiseases";
	
	public static class FamilyDiseases {
		public static final String TID = "_id";
		public static final String ID ="id";
		public static final String PROCESS = "familydiseases";
		public static final String NOTES = "notes";
		public static final String DATE = "date";
	}
	
	public static final	String CREATE_TABLE_FAMILYDISEASES = 
			"create table if not exists " + TABLE_FAMILYDISEASES + " ( "
			+ FamilyDiseases.TID + " INTEGER PRIMARY KEY, "
			+ FamilyDiseases.ID + " INTEGER UNIQUE NOT NULL, "
			+ FamilyDiseases.PROCESS + " VARACHAR, "
			+ FamilyDiseases.NOTES + " VARACHAR, "
			+ FamilyDiseases.DATE + " VARACHAR);" ;
	
	/****************************************************************************************/
	
	public static final String TABLE_PHYSICALEXAMINATION = "PhysicalExamination";
	
	public static class PhysicalExamination {
		public static final String TID = "_id";
		public static final String ID ="id";
		public static final String PROCESS = "physicalexamination";
		public static final String NOTES = "notes";
		public static final String DATE = "date";
	}
	
	public static final	String CREATE_TABLE_PHYSICALEXAMINATION = 
			"create table if not exists " + TABLE_PHYSICALEXAMINATION + " ( "
			+ PhysicalExamination.TID + " INTEGER PRIMARY KEY, "
			+ PhysicalExamination.ID + " INTEGER, "
			+ PhysicalExamination.PROCESS + " VARACHAR, "
			+ PhysicalExamination.NOTES + " VARACHAR, "
			+ PhysicalExamination.DATE + " VARACHAR);" ;
	
	/****************************************************************************************/
	
	public static final String TABLE_SOCIALHISTORY = "SocialHistory";
	
	public static class SocialHistory {
		public static final String TID = "_id";
		public static final String ID ="id";
		public static final String PROCESS = "socialhistory";
		public static final String NOTES = "notes";
		public static final String DATE = "date";
	}
	
	public static final	String CREATE_TABLE_SOCIALHISTORY = 
			"create table if not exists " + TABLE_SOCIALHISTORY + " ( "
			+ SocialHistory.TID + " INTEGER PRIMARY KEY, "
			+ SocialHistory.ID + " INTEGER UNIQUE NOT NULL, "
			+ SocialHistory.PROCESS + " VARACHAR, "
			+ SocialHistory.NOTES + " VARACHAR, "
			+ SocialHistory.DATE + " VARACHAR);" ;
	
	/****************************************************************************************/
	
	public static final String TABLE_ALLERGIES = "Allergies";
	
	public static class Allergies {
		public static final String TID = "_id";
		public static final String ID ="id";
		public static final String PROCESS = "allergies";
		public static final String NOTES = "notes";
		public static final String DATE = "date";
	}
	
	public static final	String CREATE_TABLE_ALLERGIES = 
			"create table if not exists " + TABLE_ALLERGIES + " ( "
			+ Allergies.TID + " INTEGER PRIMARY KEY, "
			+ Allergies.ID + " INTEGER UNIQUE NOT NULL, "
			+ Allergies.PROCESS + " VARACHAR, "
			+ Allergies.NOTES + " VARACHAR, "
			+ Allergies.DATE + " VARACHAR);" ;
	
	/****************************************************************************************/
	
	public static final String TABLE_INVESTIGATIONSANDLABRESULTS = "InvestigationsAndLabResults";
	
	public static class InvestigationsAndLabResults {
		public static final String TID = "_id";
		public static final String ID ="id";
		public static final String PROCESS = "investigationsandlabresults";
		public static final String NOTES = "notes";
		public static final String DATE = "date";
	}
	
	public static final	String CREATE_TABLE_INVESTIGATIONSANDLABRESULTS = 
			"create table if not exists " + TABLE_INVESTIGATIONSANDLABRESULTS + " ( "
			+ InvestigationsAndLabResults.TID + " INTEGER PRIMARY KEY, "
			+ InvestigationsAndLabResults.ID + " INTEGER, "
			+ InvestigationsAndLabResults.PROCESS + " VARACHAR, "
			+ InvestigationsAndLabResults.NOTES + " VARACHAR, "
			+ InvestigationsAndLabResults.DATE + " VARACHAR);" ;
	
	/****************************************************************************************/
	
	
	public static final String TABLE_PROVISIONALDIAGNOSIS = "ProvisionalDiagnosis";
	
	public static class ProvisionalDiagnosis {
		public static final String TID = "_id";
		public static final String ID ="id";
		public static final String PROCESS = "provisionaldiagnosis";
		public static final String NOTES = "notes";
		public static final String DATE = "date";
	}
	
	public static final	String CREATE_TABLE_PROVISIONALDIAGNOSIS = 
			"create table if not exists " + TABLE_PROVISIONALDIAGNOSIS + " ( "
			+ ProvisionalDiagnosis.TID + " INTEGER PRIMARY KEY, "
			+ ProvisionalDiagnosis.ID + " INTEGER, "
			+ ProvisionalDiagnosis.PROCESS + " VARACHAR, "
			+ ProvisionalDiagnosis.NOTES + " VARACHAR, "
			+ ProvisionalDiagnosis.DATE + " VARACHAR);" ;
	
	/****************************************************************************************/
	
	public static final String TABLE_SYSTEMEXAMINATION = "SystemExamination";
	
	public static class SystemExamination {
		public static final String TID = "_id";
		public static final String ID ="id";
		public static final String PROCESS = "systemexamination";
		public static final String NOTES = "notes";
		public static final String DATE = "date";
	}
	
	public static final	String CREATE_TABLE_SYSTEMEXAMINATION = 
			"create table if not exists " + TABLE_SYSTEMEXAMINATION + " ( "
			+ SystemExamination.TID + " INTEGER PRIMARY KEY, "
			+ SystemExamination.ID + " INTEGER, "
			+ SystemExamination.PROCESS + " VARACHAR, "
			+ SystemExamination.NOTES + " VARACHAR, "
			+ SystemExamination.DATE + " VARACHAR);" ;
	
	/****************************************************************************************/
	
	public static final String TABLE_DIFFERENTIALDIAGNOSIS = "DifferentialDiagnosis";
	
	public static class DifferentialDiagnosis {
		public static final String TID = "_id";
		public static final String ID ="id";
		public static final String PROCESS = "differentialdiagnosis";
		public static final String NOTES = "notes";
		public static final String DATE = "date";
	}
	
	public static final	String CREATE_TABLE_DIFFERENTIALDIAGNOSIS = 
			"create table if not exists " + TABLE_DIFFERENTIALDIAGNOSIS + " ( "
			+ DifferentialDiagnosis.TID + " INTEGER PRIMARY KEY, "
			+ DifferentialDiagnosis.ID + " INTEGER, "
			+ DifferentialDiagnosis.PROCESS + " VARACHAR, "
			+ DifferentialDiagnosis.NOTES + " VARACHAR, "
			+ DifferentialDiagnosis.DATE + " VARACHAR);" ;
	
	/****************************************************************************************/
	
	public static final String TABLE_CASESUMMARY = "CaseSummary";
	
	public static class CaseSummary {
		public static final String TID = "_id";
		public static final String ID ="id";
		public static final String PROCESS = "casesummary";
		public static final String NOTES = "notes";
		public static final String DATE = "date";
	}
	
	public static final	String CREATE_TABLE_CASESUMMARY = 
			"create table if not exists " + TABLE_CASESUMMARY + " ( "
			+ CaseSummary.TID + " INTEGER PRIMARY KEY, "
			+ CaseSummary.ID + " INTEGER, "
			+ CaseSummary.PROCESS + " VARACHAR, "
			+ CaseSummary.NOTES + " VARACHAR, "
			+ CaseSummary.DATE + " VARACHAR);" ;
	
	/****************************************************************************************/
	
	
	
}
