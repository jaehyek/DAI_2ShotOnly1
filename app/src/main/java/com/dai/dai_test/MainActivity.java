package com.dai.dai_test;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

	String TAG = "PASTE";
	private static final int REQUEST_EXTERNAL_STORAGE = 2;
    private static final int REQUEST_CAMERA = 1;
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);		
		setContentView(R.layout.activity_main);
		
		checkPermission(REQUEST_CAMERA);
		
		findViewById(R.id.btn_cameraStart).setOnClickListener(mClickListener);
	}
	

	Button.OnClickListener mClickListener = new View.OnClickListener() {		
		public void onClick(View v) {
			////Toast toast;			 
			switch (v.getId()) {
			case R.id.btn_cameraStart:				
				Intent intent = new Intent(MainActivity.this, CamPreviewActivity.class);
                startActivity(intent);
				break;			
			}
		}
	};
	
	private void checkPermission(int id) {        
        switch(id) {
        case REQUEST_EXTERNAL_STORAGE:
        	if (checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    != PackageManager.PERMISSION_GRANTED
                    || checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                    != PackageManager.PERMISSION_GRANTED) {

                // Should we show an explanation?
                if (shouldShowRequestPermissionRationale(Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                    // Explain to the user why we need to write the permission.
                    Toast.makeText(this, "Read/Write external storage", Toast.LENGTH_SHORT).show();
                }

                requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE},
                		REQUEST_EXTERNAL_STORAGE);
            } else {
                Log.e(TAG, "permission authorized");                
            }
        	break;
        	
        case REQUEST_CAMERA:
        	if (checkSelfPermission(Manifest.permission.CAMERA)
                    != PackageManager.PERMISSION_GRANTED) {
        		
        		// Should we show an explanation?
                if (shouldShowRequestPermissionRationale(Manifest.permission.CAMERA)) {
                    // Explain to the user why we need to write the permission.
                    Toast.makeText(this, "camera", Toast.LENGTH_SHORT).show();
                }
                
                requestPermissions(new String[]{Manifest.permission.CAMERA},
                		REQUEST_CAMERA);
                
        		
        	} else {
                Log.e(TAG, "permission authorized");
                
            }
        	break;
        }        
    }
	
	@Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case REQUEST_EXTERNAL_STORAGE:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED
                        && grantResults[1] == PackageManager.PERMISSION_GRANTED) {
                	;
                } else {
                    Log.d(TAG, "Permission always deny");
                }
                break;
                
            case REQUEST_CAMERA:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            		checkPermission(REQUEST_EXTERNAL_STORAGE);

                } else {
                    Log.d(TAG, "Permission always deny");
                }
                break;
        }
    }
}
