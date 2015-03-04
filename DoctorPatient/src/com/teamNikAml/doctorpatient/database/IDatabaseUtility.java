package com.teamNikAml.doctorpatient.database;

import android.content.ContentValues;
import android.database.Cursor;

public interface IDatabaseUtility {

	public long insert (String table, String nullColumnHack, ContentValues values);
	public Cursor query (String table, String[] columns, String selection, String[] selectionArgs, String groupBy, String having, String orderBy);
	public int update (String table, ContentValues values, String whereClause, String[] whereArgs);
	public int delete (String table, String whereClause, String[] whereArgs);
	public Cursor rawQuery (String sql, String[] selectionArgs);
}
