package com.example.dl_lib;

import java.lang.reflect.Field;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class AbsPlugin extends Activity implements IPlugin, IHostContainer {

	private IHost mHost;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		if (mHost == null) {
			super.onCreate(savedInstanceState);
		}
	}

	@Override
	public void onStart() {
		if (mHost == null) {
			super.onStart();
		}

	}

	@Override
	public void onResume() {
		if (mHost == null) {
			super.onResume();
		}

	}

	@Override
	public void onStop() {
		if (mHost == null) {
			super.onStop();
		}

	}

	@Override
	public void onDestroy() {
		if (mHost == null) {
			super.onDestroy();
		}

	}

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {

	}

	@Override
	public void onNewIntent(Intent intent) {

	}

	@Override
	public View findViewById(int id) {
		if (mHost != null) {
			return mHost.findViewById(id);
		}
		return super.findViewById(id);
	}

	@Override
	public void setContentView(int layoutResID) {
		if (mHost != null) {
			mHost.setContentView(layoutResID);
		} else {
			super.setContentView(layoutResID);
		}

	}

	@Override
	public void finish() {
		if (mHost != null) {
			if (mHost.getParent() == null) {
				// 这里需要获取自己的result

				try {
					Field fields[] = Activity.class.getDeclaredFields();
					Field.setAccessible(fields, true);
					Field codeField = Activity.class
							.getDeclaredField("mResultCode");
					Field dataField = Activity.class
							.getDeclaredField("mResultData");
					codeField.setAccessible(true);
					dataField.setAccessible(true);
					int resultCode = codeField.getInt(this);
					Intent data = (Intent) dataField.get(this);
					mHost.setResult(resultCode, data);
				} catch (NoSuchFieldException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				// mResultCode;
				// mResultData;
			}
			mHost.finish();
		}
		super.finish();
	}

	@Override
	public void startActivityForResult(Intent intent, int requestCode) {
		if (mHost != null) {
			mHost.onStartActivityForResult(intent, requestCode);
		} else {
			super.startActivityForResult(intent, requestCode);
		}

	}

	@Override
	public void startActivity(Intent intent) {
		if (mHost != null) {
			mHost.onStartActivity(intent);
		} else {
			super.startActivity(intent);
		}

	}

	@Override
	public void setHost(IHost host) {
		mHost = host;
	}

	@Override
	public IHost getHost() {
		return mHost;
	}

	@Override
	public String getPackageName() {
		if (mHost != null) {
			return mHost.getPackageName();
		}
		return super.getPackageName();
	}

	@Override
	public Context getContext() {
		if (mHost != null)
			return (Context) mHost;
		return this;
	}

	@Override
	public Context getApplicationContext() {
		if (mHost != null) {
			return mHost.getApplicationContext();
		}
		return super.getApplicationContext();
	}

}
