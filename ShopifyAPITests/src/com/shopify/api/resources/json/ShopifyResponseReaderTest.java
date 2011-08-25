package com.shopify.api.resources.json;

import java.io.StringReader;
import java.util.List;

import android.test.InstrumentationTestCase;

import com.shopify.api.test.mocks.MyShopifyResource;
import com.shopify.assets.AssetLoader;

public class ShopifyResponseReaderTest extends InstrumentationTestCase {
	private ShopifyResponseReader reader;
	private static String DIR = "fixtures/myshopifyresources/"; 
	
	
	public void setUp() throws Exception {
		super.setUp();
		AssetLoader.instrumentation = getInstrumentation();
		reader = new ShopifyResponseReader();
	}
	
	public void testResponseReaderReadsOne() {
		StringReader data = new StringReader(AssetLoader.loadAsset(DIR, "myShopifyResource.json"));
		List<MyShopifyResource> myResources = reader.read(data, MyShopifyResource.class);
		
		assertEquals(1, myResources.size());
		
		MyShopifyResource res = myResources.get(0);
		{
			assertEquals("foo", res.getA());
		}
	}
	
	public void testResponseReaderReadsAll() {
		StringReader data = new StringReader(AssetLoader.loadAsset(DIR, "severalShopifyResources.json"));
		List<MyShopifyResource> myResources = reader.read(data, MyShopifyResource.class);
		
		assertEquals(3, myResources.size());
		for(MyShopifyResource res : myResources) {
			switch(res.getId()) {
			case 1:
				assertEquals("foo", res.getA());
				break;
			case 2:
				assertEquals("bar", res.getA());
				break;
			case 3:
				assertEquals("baz", res.getA());
				break;
			default:
				fail("Encountered unexpected resource: " + res.getId());
			}
		}
	}
	
	public void testReturnsEmptyArrayOnEmptyInput() {
		List<MyShopifyResource> myResources = reader.read("", MyShopifyResource.class);
		
		assertEquals(0, myResources.size());
	}
	
}
