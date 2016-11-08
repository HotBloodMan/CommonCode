package com.example.dl_lib;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;

public interface IHost {
	
	void setContentView(int layout);
	void onStartActivity(Intent intent);
	void onStartActivityForResult(Intent intent, int requestCode);
	View findViewById(int id);
	Context getApplicationContext();
	String getPackageName();
	void finish();
	void setResult(int resultCode);
	void setResult(int resultCode,Intent data);
	Activity getParent();
}
