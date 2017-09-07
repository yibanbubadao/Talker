package com.example.cameratest;

import java.util.List;

import android.app.Activity;
import android.hardware.Camera;
import android.hardware.Camera.Size;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends Activity {
	private static final String TAG = "MainActivity";
    private TextView mTextView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mTextView = (TextView)this.findViewById(R.id.text_view);
		
		
		
	}
	
	private String getCameraInfo(){
		Camera.CameraInfo cameraInfo = new Camera.CameraInfo();  
		StringBuilder all = new StringBuilder();  
		for(int cameraId=0; cameraId<Camera.getNumberOfCameras(); cameraId++)  
		{  
		       Camera.getCameraInfo( cameraId, cameraInfo);  
		       Camera camera = Camera.open(cameraId);  
		       Camera.Parameters params = camera.getParameters();  
		       List<Camera.Size> previewSIzes = params.getSupportedVideoSizes();  
		       Log.i(TAG,"Video supported sizes: " + cameraSizeToSting( previewSIzes));  
		       String one = cameraSizeToSting( previewSIzes);
		       all.append(""+cameraId).append(one);    
		}
		return all.toString();
	}
	
	public  String cameraSizeToSting(List<Size> sizes)  
	{  
	       StringBuilder s = new StringBuilder();  
	       for (Camera.Size size : sizes)  
	       {  
	           if (s.length() != 0)  
	                s.append(",");  
	           s.append(size.width).append('x').append(size.height);  
	        }  
	        return s.toString();  
	}
}
