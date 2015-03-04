package com.teamNikAml.doctorpatient.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseConfig extends SQLiteOpenHelper implements Runnable {

	protected SQLiteDatabase prdDataBase;
	
	public DatabaseConfig(Context context, String name, CursorFactory factory,
			int version) {
		super(context, name, factory, version);
		// TODO Auto-generated constructor stub
		Thread t = new Thread(this);
		t.start();

		try {
			if (t.isAlive()) {
				t.join();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL(DatabaseConstants.CREATE_TABLE_PATIENTDETAIL);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		prdDataBase.execSQL("DROP TABLE IF EXISTS " + DatabaseConstants.TABLE_PATIENTDETAIL);

		onCreate(prdDataBase);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		prdDataBase = getWritableDatabase();
	}

}
