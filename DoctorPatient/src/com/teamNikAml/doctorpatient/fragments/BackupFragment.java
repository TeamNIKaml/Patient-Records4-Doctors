package com.teamNikAml.doctorpatient.fragments;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.teamNikAml.doctorpatient.activity.R;


/*import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;*/

public class BackupFragment extends Fragment {

	

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.fragment_backup, container,
				false);

		try {
	        File sd = Environment.getExternalStorageDirectory();
	        File data = Environment.getDataDirectory();

	        if (data.canWrite()) {
	            String currentDBPath = "//data//"+ "com.teamNikAml.doctorpatient.activity" +"//databases//"+"PatientRecordsDatabase";
	            String backupDBPath = "DatabaseBackup";
	            File currentDB = new File(data, currentDBPath);
	            File backupDB = new File(data, backupDBPath);

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
/*
	@Override
	public void onConnectionFailed(ConnectionResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onConnected(Bundle arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onConnectionSuspended(int arg0) {
		// TODO Auto-generated method stub
		
	}*/
	
	
}
