package com.shopify.api.resources.json;

import com.shopify.api.test.mocks.MyShopifyResource;
import com.shopify.assets.AssetLoader;

import android.test.InstrumentationTestCase;
import android.util.Log;

public class ShopifyRequestWriterTest extends InstrumentationTestCase {
	private static String DIR = "fixtures/myshopifyresources/";
	
	public void setUp() throws Exception {
		super.setUp();
		AssetLoader.instrumentation = getInstrumentation();
	}
	
	public void testRequestWriterOutput() throws Exception{
		MyShopifyResource res = new MyShopifyResource();
		res.setA("gaz");

		String result = res.toString();
		Log.d("RAWR!!!!!", result);

		String expected = AssetLoader.loadAsset(DIR, "expectedMyShopifyRequest.json").replaceAll("\\s+", "");
		assertEquals(expected, result);
	}
}
