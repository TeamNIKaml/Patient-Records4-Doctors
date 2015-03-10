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
	}
	
	public static final	String CREATE_TABLE_CHIEFCOMPLAINT = 
			"create table if not exists " + TABLE_CHIEFCOMPLAINT + " ( "
			+ ChiefComplaint.ID + " INTEGER PRIMARY KEY, "
			+ ChiefComplaint.PROCESS + " VARACHAR, "
			+ ChiefComplaint.NOTES + " VARACHAR);" ;
	
	
	/************************************************************************************/
	
	public static final String TABLE_HISTORYOFTHEPRESENTILLNESS = "HistoryOfThePresentIllness";
	
	public static class HistoryOfThePresentIllness {
		public static final String ID ="id";
		public static final String PROCESS = "historyofthepresentillness";
		public static final String NOTES = "notes";
	}
	
	public static final	String CREATE_TABLE_HISTORYOFTHEPRESENTILLNESS = 
			"create table if not exists " + TABLE_HISTORYOFTHEPRESENTILLNESS + " ( "
			+ HistoryOfThePresentIllness.ID + " INTEGER PRIMARY KEY, "
			+ HistoryOfThePresentIllness.PROCESS + " VARACHAR, "
			+ HistoryOfThePresentIllness.NOTES + " VARACHAR);" ;
	
	/****************************************************************************************/
	
	public static final String TABLE_PASTMEDICALHISTORY = "PastMedicalHistory";
	
	public static class PastMedicalHistory {
		public static final String ID ="id";
		public static final String PROCESS = "pastmedicalhistory";
		public static final String NOTES = "notes";
	}
	
	public static final	String CREATE_TABLE_PASTMEDICALHISTORY = 
			"create table if not exists " + TABLE_PASTMEDICALHISTORY + " ( "
			+ PastMedicalHistory.ID + " INTEGER PRIMARY KEY, "
			+ PastMedicalHistory.PROCESS + " VARACHAR, "
			+ PastMedicalHistory.NOTES + " VARACHAR);" ;
	
	/**************************************************************************************/
	
	public static final String TABLE_REVIEWOFSYSTEMS = "ReviewOfSystems";
	
	public static class ReviewOfSystems {
		public static final String ID ="id";
		public static final String PROCESS = "reviewofsystems";
		public static final String NOTES = "notes";
	}
	
	public static final	String CREATE_TABLE_REVIEWOFSYSTEMS = 
			"create table if not exists " + TABLE_REVIEWOFSYSTEMS + " ( "
			+ ReviewOfSystems.ID + " INTEGER PRIMARY KEY, "
			+ ReviewOfSystems.PROCESS + " VARACHAR, "
			+ ReviewOfSystems.NOTES + " VARACHAR);" ;
	
	/*************************************************************************************/
	
	public static final String TABLE_FAMILYDISEASES = "FamilyDiseases";
	
	public static class FamilyDiseases {
		public static final String ID ="id";
		public static final String PROCESS = "familydiseases";
		public static final String NOTES = "notes";
	}
	
	public static final	String CREATE_TABLE_FAMILYDISEASES = 
			"create table if not exists " + TABLE_FAMILYDISEASES + " ( "
			+ FamilyDiseases.ID + " INTEGER PRIMARY KEY, "
			+ FamilyDiseases.PROCESS + " VARACHAR, "
			+ FamilyDiseases.NOTES + " VARACHAR);" ;
	
	/****************************************************************************************/
	
	public static final String TABLE_CHILDHOODDISEASES = "ChildhoodDiseases";
	
	public static class ChildhoodDiseases {
		public static final String ID ="id";
		public static final String PROCESS = "childhooddiseases";
		public static final String NOTES = "notes";
	}
	
	public static final	String CREATE_TABLE_CHILDHOODDISEASES = 
			"create table if not exists " + TABLE_CHILDHOODDISEASES + " ( "
			+ ChildhoodDiseases.ID + " INTEGER PRIMARY KEY, "
			+ ChildhoodDiseases.PROCESS + " VARACHAR, "
			+ ChildhoodDiseases.NOTES + " VARACHAR);" ;
	
	/****************************************************************************************/
	
	public static final String TABLE_SOCIALHISTORY = "SocialHistory";
	
	public static class SocialHistory {
		public static final String ID ="id";
		public static final String PROCESS = "socialhistory";
		public static final String NOTES = "notes";
	}
	
	public static final	String CREATE_TABLE_SOCIALHISTORY = 
			"create table if not exists " + TABLE_SOCIALHISTORY + " ( "
			+ SocialHistory.ID + " INTEGER PRIMARY KEY, "
			+ SocialHistory.PROCESS + " VARACHAR, "
			+ SocialHistory.NOTES + " VARACHAR);" ;
	
	/****************************************************************************************/
	
	public static final String TABLE_ALLERGIES = "Allergies";
	
	public static class Allergies {
		public static final String ID ="id";
		public static final String PROCESS = "allergies";
		public static final String NOTES = "notes";
	}
	
	public static final	String CREATE_TABLE_ALLERGIES = 
			"create table if not exists " + TABLE_ALLERGIES + " ( "
			+ Allergies.ID + " INTEGER PRIMARY KEY, "
			+ Allergies.PROCESS + " VARACHAR, "
			+ Allergies.NOTES + " VARACHAR);" ;
	
	/****************************************************************************************/
	
	public static final String TABLE_SEXUAL = "Sexual";
	
	public static class Sexual {
		public static final String ID ="id";
		public static final String PROCESS = "sexual";
		public static final String NOTES = "notes";
	}
	
	public static final	String CREATE_TABLE_SEXUAL = 
			"create table if not exists " + TABLE_SEXUAL + " ( "
			+ Sexual.ID + " INTEGER PRIMARY KEY, "
			+ Sexual.PROCESS + " VARACHAR, "
			+ Sexual.NOTES + " VARACHAR);" ;
	
	/****************************************************************************************/
	
	
	public static final String TABLE_CONCLUSIONANDCLOSURE = "ConclusionAndClosure";
	
	public static class ConclusionAndClosure {
		public static final String ID ="id";
		public static final String PROCESS = "conclusionandclosure";
		public static final String NOTES = "notes";
	}
	
	public static final	String CREATE_TABLE_CONCLUSIONANDCLOSURE = 
			"create table if not exists " + TABLE_CONCLUSIONANDCLOSURE + " ( "
			+ ConclusionAndClosure.ID + " INTEGER PRIMARY KEY, "
			+ ConclusionAndClosure.PROCESS + " VARACHAR, "
			+ ConclusionAndClosure.NOTES + " VARACHAR);" ;
	
	/****************************************************************************************/
	
}
