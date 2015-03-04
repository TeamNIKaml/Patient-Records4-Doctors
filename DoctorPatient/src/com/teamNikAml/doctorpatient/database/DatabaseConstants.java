package com.teamNikAml.doctorpatient.database;

public class DatabaseConstants {
	
	public static final String DATABASE_NAME = "PatientRecordsDatabase";
	public static final int DATABASE_VERSION = 1;
	public static final String TABLE_PATIENTDETAIL = "PatientDetailTable";

	public static class PatientDetailTable {
		public static final String ID = "_id";
		public static final String NAME = "name";
		public static final String SEX = "sex";
		public static final String AGE = "age";
		public static final String DOB = "dob";
		public static final String CONTACTNO = "contactno";
		public static final String NOTES = "notes";

	}

	public static final	String CREATE_TABLE_PATIENTDETAIL = 
			"create table if not exists " + DATABASE_NAME + " ( "
			+ PatientDetailTable.ID + " INTEGER PRIMARY KEY, "
			+ PatientDetailTable.NAME + " VARACHAR, "
			+ PatientDetailTable.SEX + " VARACHAR, "
			+ PatientDetailTable.AGE + " INTEGER, "
			+ PatientDetailTable.DOB + " VARACHAR, "
			+ PatientDetailTable.CONTACTNO + " VARACHAR, "
			+ PatientDetailTable.NOTES + " VARACHAR);" ;

}
