package com.shopify.api.endpoints;

import java.net.URI;

import junit.framework.TestCase;

import com.shopify.api.test.mocks.MockAPIAuthorization;

public class AuthAPITest extends TestCase {
	private AuthAPI authApi;
	
	public void setUp() throws Exception {
		super.setUp();
		authApi = new AuthAPI(new MockAPIAuthorization());
	}
	
	public void testGetAuthRequestURI() {
		URI authURI = authApi.getAuthRequestURI();
		String expected = "http://some-shop.myshopify.com/admin/api/auth?api_key=invoice-api-key";
		assertEquals(expected, authURI.toString());
	}

}
