package com.shopify.api.resources.json;

import java.io.StringWriter;

import com.shopify.api.test.mocks.MyShopifyResource;
import com.shopify.assets.AssetLoader;

import android.test.InstrumentationTestCase;
import android.util.Log;

public class ShopifyRequestWriterTest extends InstrumentationTestCase {
	private ShopifyRequestWriter writer;
	private static String DIR = "fixtures/myshopifyresources/";
	
	public void setUp() throws Exception {
		super.setUp();
		AssetLoader.instrumentation = getInstrumentation();
		writer = new ShopifyRequestWriter();
	}
	
	public void testRequestWriterOutput() throws Exception{
		MyShopifyResource res = new MyShopifyResource();
		res.setA("gaz");
		
		StringWriter output = new StringWriter();
		writer.write(output, res);
		
		String result = output.toString();
		Log.d("RAWR!!!!!", result);
		
		String expected = AssetLoader.loadAsset(DIR, "expectedMyShopifyRequest.json").replaceAll("\\s+", "");
		assertEquals(expected, result);
	}
}
