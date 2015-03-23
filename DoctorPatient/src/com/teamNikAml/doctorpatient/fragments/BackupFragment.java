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
import com.teamNikAml.doctorpatient.database.DatabaseConfig;


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
			
			System.out.println("dfsdfsddsds");
			
	        File sd = Environment.getExternalStorageDirectory();
	        File data = Environment.getDataDirectory();

	     
	            File currentDBPath = getActivity().getApplicationContext().getDatabasePath("PatientRecordsDatabase");
	            
	            File backupDBPath ;
	            backupDBPath = new File(getActivity().getApplicationContext().getFilesDir() + "/" + "DatabaseBackup" );
	    		
	            
	            
	            
	            System.out.println(currentDBPath.getPath());
	          
	            //File currentDB = new File(data, currentDBPath);
	           // File backupDB = new File(data, backupDBPath);

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
