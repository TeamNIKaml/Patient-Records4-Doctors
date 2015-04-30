package com.teamNikAml.doctorpatient.fragments;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.teamNikAml.doctorpatient.activity.R;
import com.teamNikAml.doctorpatient.activity.R.id;

public class BackupFragment extends Fragment {

	Button old, importdb, exportdb;
	Thread t = null;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.fragment_backup, container,
				false);
		old = (Button) rootView.findViewById(id.button_add_old_appointment);
		importdb = (Button) rootView.findViewById(id.button_import_db);
		exportdb = (Button) rootView.findViewById(id.button_export_db);
		
		old.setOnClickListener(listener);
		importdb.setOnClickListener(listener);
		exportdb.setOnClickListener(listener);
		
		return rootView;
	}

	OnClickListener listener = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId()) {

			case id.button_add_old_appointment:
				FragmentTransaction ft = getActivity().getFragmentManager()
				.beginTransaction();
				Fragment mFrag = new OldAppointmentFragment();
				ft.replace(R.id.frame_container, mFrag);
				ft.commit();
				break;
			case id.button_import_db:
				try {
			        File sd = Environment.getExternalStorageDirectory();
			        File data = Environment.getDataDirectory();
			        if (data.exists()) {
			            String originalDBPath = "//data//"+ "com.teamNikAml.doctorpatient.activity" +"//databases//"+"PatientRecordsDatabase.db";
			            String currentDBPath = "PatientRecordBackup.db";
			            File currentDB = new File(sd, currentDBPath);
			            File backupDB = new File(data, originalDBPath);

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
			                Toast.makeText(getActivity(), "Import Completed", Toast.LENGTH_SHORT).show();
			            }
			        }
			    } catch (Exception e) {
			    }
				
				break;
			case id.button_export_db:
				
				Toast.makeText(getActivity(), "Exporting", Toast.LENGTH_SHORT).show();
				t = new Thread() {
					@Override
					public void run() {
						try {
					        File sd = Environment.getExternalStorageDirectory();
					        File data = Environment.getDataDirectory();

					        if (sd.canWrite()) {
					            String currentDBPath = "//data//"+ "com.teamNikAml.doctorpatient.activity" +"//databases//"+"PatientRecordsDatabase.db";
					            String backupDBPath = "PatientRecordBackup.db";
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
					}
				};
				if (t != null) {
					t.start();
				}
				break;

			default:
				break;
			}
			
		}
	};
	
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