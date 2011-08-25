package com.shopify.api.test.mocks;

import org.codehaus.jackson.annotate.JsonProperty;

import com.shopify.api.resources.ShopifyResource;

public class MyShopifyResource extends ShopifyResource {
	@JsonProperty("a")
	private String a;
	public String getA() { return a; }
	public void setA(String newA) { a = newA; }
}
