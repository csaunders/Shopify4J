package com.shopify.api.test.mocks;

import com.shopify.api.APIAuthorization;
import com.shopify.api.credentials.Credential;

public class MockAPIAuthorization extends APIAuthorization{
	
	public MockAPIAuthorization() {
		super(new Credential("invoice-api-key", "hush", "some-shop", "36b29a08b3113077f14777570c0577ed"));
	}

}
