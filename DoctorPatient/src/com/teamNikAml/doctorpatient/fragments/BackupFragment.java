package com.teamNikAml.doctorpatient.fragments;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.teamNikAml.doctorpatient.activity.R;

public class BackupFragment extends Fragment {

	

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.fragment_backup, container,
				false);

		try {
	        File sd = Environment.getExternalStorageDirectory();
	        File data = Environment.getDataDirectory();

	        if (sd.canWrite()) {
	            String currentDBPath = "//data//"+ "com.teamNikAml.doctorpatient.activity" +"//databases//"+"PatientRecordsDatabase";
	            String backupDBPath = "PatientRecordBackup";
	            File currentDB = new File(data, currentDBPath);
	            File backupDB = new File(sd, backupDBPath);

	            if (currentDB.exists()) {
	                FileInputStream fileInputStream = new FileInputStream(currentDB);
					FileChannel src = fileInputStream.getChannel();
	                FileOutputStream fileOutputStream = new FileOutputStream(backupDB);
					FileChannel dst = fileOutputStream.getChannel();
	                dst.transferFrom(src, 0, src.size());
	                src.close();
	                dst.close();
	                fileInputStream.close();
	                fileOutputStream.close();
	            }
	        }
	    } catch (Exception e) {
	    }
		
		
		Calendar cal = Calendar.getInstance();
        Date currentLocalTime = cal.getTime();
        SimpleDateFormat date = new SimpleDateFormat("HH:mm"); 
        String localTime = date.format(currentLocalTime); 
        System.out.println(localTime);
		
		return rootView;
	}

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
	}

	@Override
	public void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
	}

	@Override
	public void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
	}

	
}



/*package com.teamNikAml.doctorpatient.fragments;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.teamNikAml.doctorpatient.activity.R;



public class BackupFragment extends Fragment {

	

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.fragment_backup, container,
				false);

		try {
     
	            File currentDBPath = getActivity().getApplicationContext().getDatabasePath("PatientRecordsDatabase");
	            
	            File backupDBPath ;
	            backupDBPath = new File(getActivity().getApplicationContext().getFilesDir() + "/" + "DatabaseBackup" );
	    		
	            if (currentDBPath.exists()) {
	                FileInputStream fileInputStream = new FileInputStream(currentDBPath);
					FileChannel src = fileInputStream.getChannel();
	                FileOutputStream fileOutputStream = new FileOutputStream(backupDBPath);
					FileChannel dst = fileOutputStream.getChannel();
	                dst.transferFrom(src, 0, src.size());
	                src.close();
	                dst.close();
	                
	                System.out.println(backupDBPath.getPath());
	                fileInputStream.close();
	                fileOutputStream.close();
	           
	        }
	    } catch (Exception e) {
	    	
	    	e.printStackTrace();
	    }
		return rootView;
	}

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
	}

	@Override
	public void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
	}

	@Override
	public void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
	}

	
}
*/