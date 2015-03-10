package com.teamNikAml.doctorpatient.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseConfig extends SQLiteOpenHelper{

	protected SQLiteDatabase prdDataBase;
	
	public DatabaseConfig(Context context, String name, CursorFactory factory,
			int version) {
		super(context, name, factory, version);
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
		db.execSQL(DatabaseConstants.CREATE_TABLE_REVIEWOFSYSTEMS);
		db.execSQL(DatabaseConstants.CREATE_TABLE_FAMILYDISEASES);
		db.execSQL(DatabaseConstants.CREATE_TABLE_CHILDHOODDISEASES);
		db.execSQL(DatabaseConstants.CREATE_TABLE_SOCIALHISTORY);
		db.execSQL(DatabaseConstants.CREATE_TABLE_ALLERGIES);
		db.execSQL(DatabaseConstants.CREATE_TABLE_SEXUAL);
		db.execSQL(DatabaseConstants.CREATE_TABLE_CONCLUSIONANDCLOSURE);
		//db.execSQL("INSERT INTO "+DatabaseConstants.TABLE_PRESENTINGILLNESS+" VALUES ( 1, xxxx, yyyyy);");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		prdDataBase.execSQL("DROP TABLE IF EXISTS " + DatabaseConstants.TABLE_PATIENTDETAIL);
		prdDataBase.execSQL("DROP TABLE IF EXISTS " + DatabaseConstants.TABLE_CHIEFCOMPLAINT);
		prdDataBase.execSQL("DROP TABLE IF EXISTS " + DatabaseConstants.TABLE_HISTORYOFTHEPRESENTILLNESS);
		prdDataBase.execSQL("DROP TABLE IF EXISTS " + DatabaseConstants.TABLE_PASTMEDICALHISTORY);
		prdDataBase.execSQL("DROP TABLE IF EXISTS " + DatabaseConstants.TABLE_REVIEWOFSYSTEMS);
		prdDataBase.execSQL("DROP TABLE IF EXISTS " + DatabaseConstants.TABLE_FAMILYDISEASES);
		prdDataBase.execSQL("DROP TABLE IF EXISTS " + DatabaseConstants.TABLE_CHILDHOODDISEASES);
		prdDataBase.execSQL("DROP TABLE IF EXISTS " + DatabaseConstants.TABLE_SOCIALHISTORY);
		prdDataBase.execSQL("DROP TABLE IF EXISTS " + DatabaseConstants.TABLE_ALLERGIES);
		prdDataBase.execSQL("DROP TABLE IF EXISTS " + DatabaseConstants.TABLE_SEXUAL);
		prdDataBase.execSQL("DROP TABLE IF EXISTS " + DatabaseConstants.TABLE_CONCLUSIONANDCLOSURE);
		
		onCreate(prdDataBase);
	}



}
