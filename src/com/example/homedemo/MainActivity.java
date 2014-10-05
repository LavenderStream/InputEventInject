package com.example.homedemo;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;
import android.os.Build;

public class MainActivity extends Activity
{
	Button mButton;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Toast.makeText(this, "123", Toast.LENGTH_SHORT).show();
	//	mButton = (Button) super.findViewById(R.id.button);
	}
	
	public void callBackHome(View view){  
		new Thread() {
			public void run() {
				InputCmd.runKeyEvent(KeyEvent.KEYCODE_HOME);
			}
		}.start();
	}
}
