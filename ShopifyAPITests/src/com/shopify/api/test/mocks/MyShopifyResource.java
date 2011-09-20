package com.shopify.api.test.mocks;

import org.codehaus.jackson.annotate.JsonProperty;

import com.shopify.api.resources.ShopifyResource;

public class MyShopifyResource extends ShopifyResource {
	@JsonProperty("a")
	public String getA() { return (String)getAttribute("a"); }
	@JsonProperty("a")
	public void setA(String newA) { setAttribute("a", newA); }
}
