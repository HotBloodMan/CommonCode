package com.example.host;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import dalvik.system.DexClassLoader;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;

public class PluginLoader {
	
	
	public static PluginInfo loadPlugin(Context context,String assertName) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException, NoSuchMethodException{
		/**
		 * 将资源中的文件拷贝出来
		 */
		InputStream in = context.getClass().getResourceAsStream("/assets/"+assertName+".apk");
		File file = new File(context.getFilesDir(), assertName + ".apk");
		try {
			OutputStream out = new FileOutputStream(file);
			byte[] buffer = new byte[1024];
			int n = 0;
			while ((n = in.read(buffer)) > 0) {
				out.write(buffer, 0, n);
			}
			out.flush();
			out.close();
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		/**
		 * 创建dexClassLoader
		 */
		File dexOutputDir = context.getDir("dex" ,Context.MODE_PRIVATE);
		String dexOutputPath = dexOutputDir.getAbsolutePath();
		DexClassLoader dexClassLoader = new DexClassLoader(
				file.getAbsolutePath(), dexOutputPath, context.getDir("so",
						Context.MODE_PRIVATE).getAbsolutePath(),
						context.getClassLoader());
		AssetManager assetManager = AssetManager.class.newInstance();
		Method addAssetPath = assetManager.getClass().getMethod(
				"addAssetPath", String.class);
		addAssetPath.invoke(assetManager, file.getAbsolutePath());
		
		PluginInfo pluginInfo =  new PluginInfo();
		pluginInfo.setAssetManager(assetManager);
		pluginInfo.setDexClassLoader(dexClassLoader);
		pluginInfo.setFile(file);
		return pluginInfo;
	}
}
