package com.teamNikAml.doctorpatient.application;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class GeneralClass {
	
	Calendar c = Calendar.getInstance();
    SimpleDateFormat date = new SimpleDateFormat("dd-MM-yyyy",java.util.Locale.getDefault());
    SimpleDateFormat time = new SimpleDateFormat("HH:mm",java.util.Locale.getDefault());
    
    public String getCurrentDate(){
    	return date.format(c.getTime());
    }
    public String getCurrentTime(){
    	return time.format(c.getTime()); 
    }
    
    public void setCalender(Calendar c){
    	this.c = c;
    }

}
