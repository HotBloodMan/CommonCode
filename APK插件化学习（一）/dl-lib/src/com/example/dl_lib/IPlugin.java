package com.example.dl_lib;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public interface IPlugin extends IHostContainer {
	void finish();
	 Activity getParent();
	void startActivityForResult(Intent intent, int requestCode);
	void startActivity(Intent intent);
	String getPackageName();
	void setContentView(int layoutResID);
	Context getApplicationContext();
	View findViewById(int id);
	Context getContext();
	void setResult(int resultCode);
	void setResult(int resultCode,Intent data);
	
	
	void onStop();

	void onStart();

	void onResume();

	void onDestroy();

	void onCreate(Bundle savedInstanceState);

	void onNewIntent(Intent intent);

	void onActivityResult(int requestCode, int resultCode, Intent data);

	void onBackPressed();
	
	

}
