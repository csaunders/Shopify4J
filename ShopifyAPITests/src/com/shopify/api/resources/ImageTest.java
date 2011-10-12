package com.shopify.api.resources;

import java.io.File;

import android.content.Context;
import android.util.Log;

import com.shopify.assets.AssetLoader;

public class ImageTest extends FixturesTestCase {	
	Context ctx;
	
	public void setUp() throws Exception {
		super.setUp();
		ctx = AssetLoader.instrumentation.getTargetContext();
	}
	
	public void tearDown() throws Exception {
		super.tearDown();
	}
	
	public void testCreateAnImageFromFile() throws Exception{
		Image image = new Image();
		image.setPosition(1);
		image.setImage(new File("/dev/null"));
		image.setFilename("shopify.png");
		String result = image.toString();

		assertTrue(result.contains("position"));
		assertTrue(result.contains("filename"));
		assertTrue(result.contains("attachment"));
	}

}
