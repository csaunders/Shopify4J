package com.shopify.assets;

import java.io.IOException;
import java.io.InputStreamReader;

import android.app.Instrumentation;

public class AssetLoader {
	public static Instrumentation instrumentation;
	
	public static String loadAsset(String dir, String filename) {
		return loadAsset(dir + filename);
	}
	
	public static String loadAsset(String filename) {
		StringBuilder builder = new StringBuilder();
		char[] buffer = new char[1024];
		int lettersRead = 0;
		try {
			InputStreamReader dataStream = new InputStreamReader(instrumentation.getTargetContext().getAssets().open(filename));
			while( (lettersRead = dataStream.read(buffer)) > 0) {
				builder.append(buffer, 0, lettersRead);
			}
		} catch (IOException e) {
			return "";
		}
		return builder.toString();
	}

}
