package com.shopify.api.endpoints;

import java.util.HashMap;
import java.util.List;

import com.shopify.api.endpoints.API.APIResponseContent;
import com.shopify.api.resources.ShopifyResource;
import com.shopify.api.test.mocks.MockAPIAuthorization;

import android.test.AndroidTestCase;

public class APITest extends AndroidTestCase {
	private class MockAPI extends API {
		
		public MockAPI() {
			super(new MockAPIAuthorization());
		}
		
		@Override
		public ShopifyResource findById(int id) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public List<ShopifyResource> findByQuery(
				HashMap<String, String> queryParams) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		protected String getAPIEndpoint() {
			// TODO Auto-generated method stub
			return "mock";
		}

		@Override
		public List<ShopifyResource> getAll() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return 0;
		}
	}
	
	private MockAPI api;
	
	public void setUp() throws Exception {
		super.setUp();
		api = new MockAPI();
	}
	
	public void testGetContentTypeExtension() {
		assertEquals(".json", api.getContentTypeExtension());
		
		api.setContentTypeExtension(APIResponseContent.NONE);
		assertEquals("", api.getContentTypeExtension());
		
		api.setContentTypeExtension(APIResponseContent.XML);
		assertEquals(".xml", api.getContentTypeExtension());
		
		api.setContentTypeExtension(APIResponseContent.JSON);
		assertEquals(".json", api.getContentTypeExtension());
	}
	
	public void testConstructApiUri() {
		String expected = "http://some-shop.myshopify.com/admin/mock";
		assertEquals(expected+".json", api.constructURI(null).toString());
		
		assertEquals(expected+"/1.json", api.constructURI(1, null, null).toString());
		
		HashMap<String, String> params = new HashMap<String, String>(){{
			put("foo", "123");
			put("bar", "456");
		}};
		String result = api.constructURI(params).toString();
		assertEquals(expected+".json?bar=456&foo=123", result);
	}
	
	public void testConstructApiUri_argsNeedUrlEncoding() {
		String expected = "http://some-shop.myshopify.com/admin/mock.json?email=email%40isdandy.com&this=is+a+space";
		HashMap<String, String> params = new HashMap<String, String>(){{
			put("this", "is a space");
			put("email", "email@isdandy.com");
		}};
		String result = api.constructURI(params).toString();
		assertEquals(expected, result);
	}

}
