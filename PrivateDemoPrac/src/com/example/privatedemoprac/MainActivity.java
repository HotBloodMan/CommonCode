package com.example.privatedemoprac;

import com.example.privatedemoprac.MyTabWidget.OnTabSelectedListener;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends Activity implements OnTabSelectedListener {

	private MyTabWidget mTabWidget;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		init();
		initEvents();
	}
	private void init() {
		// TODO Auto-generated method stub
		mTabWidget = (MyTabWidget) findViewById(R.id.tab_widget);
	}
	private void initEvents() {
		mTabWidget.setOnTabSelectedListener(this);
	}

	@Override
	public void onTabSelected(int index) {
		// TODO Auto-generated method stub
		if(index==1){
			Log.d("TAG","index="+index);
		}
	}

	
}
