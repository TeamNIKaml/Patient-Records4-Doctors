package com.teamNikAml.doctorpatient.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseConfig extends SQLiteOpenHelper{

	protected SQLiteDatabase prdDataBase;
	
	public DatabaseConfig(Context context, String name, CursorFactory factory,
			int version) {
		super(context, DatabaseConstants.DATABASE_NAME, factory, DatabaseConstants.DATABASE_VERSION);
		// TODO Auto-generated constructor stub
		prdDataBase = getWritableDatabase();
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL(DatabaseConstants.CREATE_TABLE_PATIENTDETAIL);
		db.execSQL(DatabaseConstants.CREATE_TABLE_CHIEFCOMPLAINT);
		db.execSQL(DatabaseConstants.CREATE_TABLE_HISTORYOFTHEPRESENTILLNESS);
		db.execSQL(DatabaseConstants.CREATE_TABLE_PASTMEDICALHISTORY);
		db.execSQL(DatabaseConstants.CREATE_TABLE_CURRENTMEDICATIONS);
		db.execSQL(DatabaseConstants.CREATE_TABLE_FAMILYDISEASES);
		db.execSQL(DatabaseConstants.CREATE_TABLE_PHYSICALEXAMINATION);
		db.execSQL(DatabaseConstants.CREATE_TABLE_SOCIALHISTORY);
		db.execSQL(DatabaseConstants.CREATE_TABLE_ALLERGIES);
		db.execSQL(DatabaseConstants.CREATE_TABLE_INVESTIGATIONSANDLABRESULTS);
		db.execSQL(DatabaseConstants.CREATE_TABLE_PROVISIONALDIAGNOSIS);
		db.execSQL(DatabaseConstants.CREATE_TABLE_SYSTEMEXAMINATION);
		db.execSQL(DatabaseConstants.CREATE_TABLE_DIFFERENTIALDIAGNOSIS);
		db.execSQL(DatabaseConstants.CREATE_TABLE_CASESUMMARY);
		db.execSQL(DatabaseConstants.CREATE_TABLE_REPORTBYDAY);
		db.execSQL(DatabaseConstants.CREATE_TABLE_REPORTBYMONTH);
		db.execSQL(DatabaseConstants.CREATE_TABLE_REPORTBYYEAR);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		prdDataBase.execSQL("DROP TABLE IF EXISTS " + DatabaseConstants.TABLE_PATIENTDETAIL);
		prdDataBase.execSQL("DROP TABLE IF EXISTS " + DatabaseConstants.TABLE_CHIEFCOMPLAINT);
		prdDataBase.execSQL("DROP TABLE IF EXISTS " + DatabaseConstants.TABLE_HISTORYOFTHEPRESENTILLNESS);
		prdDataBase.execSQL("DROP TABLE IF EXISTS " + DatabaseConstants.TABLE_PASTMEDICALHISTORY);
		prdDataBase.execSQL("DROP TABLE IF EXISTS " + DatabaseConstants.TABLE_CURRENTMEDICATIONS);
		prdDataBase.execSQL("DROP TABLE IF EXISTS " + DatabaseConstants.TABLE_FAMILYDISEASES);
		prdDataBase.execSQL("DROP TABLE IF EXISTS " + DatabaseConstants.TABLE_PHYSICALEXAMINATION);
		prdDataBase.execSQL("DROP TABLE IF EXISTS " + DatabaseConstants.TABLE_SOCIALHISTORY);
		prdDataBase.execSQL("DROP TABLE IF EXISTS " + DatabaseConstants.TABLE_ALLERGIES);
		prdDataBase.execSQL("DROP TABLE IF EXISTS " + DatabaseConstants.TABLE_INVESTIGATIONSANDLABRESULTS);
		prdDataBase.execSQL("DROP TABLE IF EXISTS " + DatabaseConstants.TABLE_PROVISIONALDIAGNOSIS);
		prdDataBase.execSQL("DROP TABLE IF EXISTS " + DatabaseConstants.TABLE_SYSTEMEXAMINATION);
		prdDataBase.execSQL("DROP TABLE IF EXISTS " + DatabaseConstants.TABLE_DIFFERENTIALDIAGNOSIS);
		prdDataBase.execSQL("DROP TABLE IF EXISTS " + DatabaseConstants.TABLE_CASESUMMARY);
		prdDataBase.execSQL("DROP TABLE IF EXISTS " + DatabaseConstants.TABLE_REPORTBYDAY);
		prdDataBase.execSQL("DROP TABLE IF EXISTS " + DatabaseConstants.TABLE_REPORTBYMONTH);
		prdDataBase.execSQL("DROP TABLE IF EXISTS " + DatabaseConstants.TABLE_REPORTBYYEAR);
		
		onCreate(prdDataBase);
	}

	@Override
	public synchronized void close() {
		// TODO Auto-generated method stub
		super.close();
		prdDataBase.close();
	}

}
