package com.teamNikAml.doctorpatient.database;

import java.util.ArrayList;

import android.database.Cursor;

public class PatientDetailUnit {
	
	private int id;
	private String name;
	private String sex;
	private int age;
	private String email;
	private String contactNo;
	private String otherNotes;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getDob() {
		return email;
	}
	public void setDob(String email) {
		this.email = email;
	}
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	public String getNotes() {
		return otherNotes;
	}
	public void setNotes(String otherNotes) {
		this.otherNotes = otherNotes;
	}

	public ArrayList<PatientDetailUnit> getPatientArray(Cursor c) {
		
		ArrayList<PatientDetailUnit> pdu = new ArrayList<PatientDetailUnit>();
		PatientDetailUnit temp;
		if (c.moveToFirst()) {
			do {
				temp = new PatientDetailUnit();
				temp.setId(c.getInt(0));
				temp.setName(c.getString(1));
				temp.setSex(c.getString(2));
				temp.setAge(c.getInt(3));
				temp.setDob(c.getString(4));
				temp.setContactNo(c.getString(5));
				temp.setNotes(c.getString(6));

				pdu.add(temp);
			} while (c.moveToNext());
		}
		return pdu;
	}
}
