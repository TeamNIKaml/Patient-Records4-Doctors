package com.teamNikAml.doctorpatient.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase.CursorFactory;

public class PatientDetailAccess extends DatabaseConfig implements IDatabaseUtility{

	public PatientDetailAccess(Context context, String name,
			CursorFactory factory, int version) {
		super(context, name, factory, version);
		// TODO Auto-generated constructor stub
	}

	@Override
	public long insert(String table, String nullColumnHack, ContentValues values) {
		// TODO Auto-generated method stub
		return prdDataBase.insert(table, nullColumnHack, values);
	}

	@Override
	public Cursor query(String table, String[] columns, String selection,
			String[] selectionArgs, String groupBy, String having,
			String orderBy) {
		// TODO Auto-generated method stub
		return prdDataBase.query(table, columns, selection, selectionArgs, groupBy, having, orderBy);
	}

	@Override
	public int update(String table, ContentValues values, String whereClause,
			String[] whereArgs) {
		// TODO Auto-generated method stub
		return prdDataBase.update(table, values, whereClause, whereArgs);
	}

	@Override
	public int delete(String table, String whereClause, String[] whereArgs) {
		// TODO Auto-generated method stub
		return prdDataBase.delete(table, whereClause, whereArgs);
	}

	@Override
	public Cursor rawQuery(String sql, String[] selectionArgs) {
		// TODO Auto-generated method stub
		return prdDataBase.rawQuery(sql, selectionArgs);
	}

	@Override
	public long insertWithOnConflict(String table, String nullColumnHack,
			ContentValues initialValues, int conflictAlgorithm) {
		// TODO Auto-generated method stub
		return prdDataBase.insertWithOnConflict(table, nullColumnHack, initialValues, conflictAlgorithm);
	}



}
