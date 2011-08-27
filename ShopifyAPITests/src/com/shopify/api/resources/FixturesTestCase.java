package com.shopify.api.resources;

import com.shopify.api.resources.json.ShopifyRequestWriter;
import com.shopify.api.resources.json.ShopifyResponseReader;
import com.shopify.assets.AssetLoader;

import android.test.InstrumentationTestCase;

public class FixturesTestCase extends InstrumentationTestCase {
	protected String fixturesDir = "fixtures/";
	protected ShopifyResponseReader reader;
	protected ShopifyRequestWriter  writer;
	
	public void setUp() throws Exception {
		super.setUp();
		AssetLoader.instrumentation = getInstrumentation();
		reader = new ShopifyResponseReader();
		writer = new ShopifyRequestWriter();
	}

}
