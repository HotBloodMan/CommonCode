package com.example.host;

import java.lang.reflect.Method;

import com.example.dl_lib.AbsPlugin;
import com.example.dl_lib.IHost;
import com.example.dl_lib.IPlugin;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class DLActivity extends Activity implements IHost {

	private static final String ASSET_NAME = "assetName";
	private static final String CLASS_NAME = "className";

	public static void startPlugin(Context context, String assetName,
			String className) {
		Intent intent = new Intent(context, DLActivity.class);
		intent.putExtra(ASSET_NAME, assetName);
		intent.putExtra(CLASS_NAME, className);
		context.startActivity(intent);
	}
	public static void startPluginForResult(Activity context, String assetName,
			String className,int requestCode) {
		Intent intent = new Intent(context, DLActivity.class);
		intent.putExtra(ASSET_NAME, assetName);
		intent.putExtra(CLASS_NAME, className);
		context.startActivityForResult(intent,requestCode);
	}
	public static void startPlugin(Context context, String assetName) {
		Intent intent = new Intent(context, DLActivity.class);
		intent.putExtra(ASSET_NAME, assetName);
		intent.putExtra(CLASS_NAME, "com.example.dl.MainActivity");
		context.startActivity(intent);
	}

	private IPlugin mPlugin;
	private Theme theme;
	private Resources resources;

	private PluginInfo pluginInfo;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		Intent intent = getIntent();
		Bundle bundle = intent.getExtras();
		String assetName = bundle.getString(ASSET_NAME);
		String className = bundle.getString(CLASS_NAME);
		try {
			pluginInfo = PluginLoader.loadPlugin(this, assetName);
			mPlugin = (AbsPlugin) pluginInfo.loadClass(className).newInstance();
			mPlugin.setHost(this);
			mPlugin.onCreate(savedInstanceState);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}



	@Override
	public void setContentView(int layoutResID) {
		View view = inflate(layoutResID);
		super.setContentView(view);
	}
	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (mPlugin != null) {
			mPlugin.onActivityResult(requestCode, resultCode, data);
		}
	}

	


	class MyLayoutInflater extends LayoutInflater {

		public MyLayoutInflater(LayoutInflater original, Context newContext) {
			super(original, newContext);
			// TODO Auto-generated constructor stub
		}

		protected MyLayoutInflater(Context context) {
			super(context);
			// TODO Auto-generated constructor stub
		}

		@Override
		public LayoutInflater cloneInContext(Context newContext) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public View inflate(int resource, ViewGroup root) {

			return DLActivity.this.inflate(resource);
		}

	}

	public void setOverrideResources(boolean override) {
		if (override) {
			try {
				Resources superRes = super.getResources();
				resources = new Resources(pluginInfo.getAssetManager(),
						superRes.getDisplayMetrics(),
						superRes.getConfiguration());
				theme = resources.newTheme();
				theme.setTo(super.getTheme());
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}

		} else {
			this.theme = null;
			this.resources = null;
			this.theme = null;
		}
	}

	public View inflate(int layoutId) {
		setOverrideResources(true);
		View view = LayoutInflater.from(this).inflate(layoutId, null);
		setOverrideResources(false);
		return view;
	}

	@Override
	public LayoutInflater getLayoutInflater() {
		if (this.resources == null) {
			return getWindow().getLayoutInflater();
		}
		return new MyLayoutInflater(this);
	}

	@Override
	public Resources getResources() {
		return resources == null ? super.getResources() : resources;
	}

	@Override
	public AssetManager getAssets() {
		return resources == null ? super.getAssets() : pluginInfo.getAssetManager();
	}

	@Override
	public ClassLoader getClassLoader() {
		return resources == null ? super.getClassLoader() : pluginInfo.getDexClassLoader();
	}

	@Override
	public Theme getTheme() {
		return theme == null ? super.getTheme() : theme;
	}
	@Override
	public void onStartActivity(Intent intent) {
		ComponentName c = intent.getComponent();
		// 启动plugin的实际class
		Bundle bundle = getIntent().getExtras();
		String assetName = bundle.getString(ASSET_NAME);
		String className = c.getClassName();
		startPlugin(this, assetName,className);
	}
	@Override
	public void onStartActivityForResult(Intent intent, int requestCode) {
		ComponentName c = intent.getComponent();
		// 启动plugin的实际class
		Bundle bundle = getIntent().getExtras();
		String assetName = bundle.getString(ASSET_NAME);
		String className = c.getClassName();
		
		startPluginForResult(this, assetName,className,requestCode);
	}
}
