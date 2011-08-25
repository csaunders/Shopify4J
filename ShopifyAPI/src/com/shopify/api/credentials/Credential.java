package com.shopify.api.credentials;

import org.codehaus.jackson.annotate.JsonProperty;

public class Credential {
	
	@JsonProperty("shop_name")
	private String shopName;
	
	@JsonProperty("api_key")
	private String apiKey;
	
	@JsonProperty("password")
	private String password;
	
	@JsonProperty("secret")
	private String sharedSecret;
	
	public Credential(String apiKey, String sharedSecret, String shopName) {
		this(apiKey, sharedSecret, shopName, null);
	}

	public Credential(String apiKey, String sharedSecret, String shopName, String password) {
		this.apiKey = apiKey;
		this.sharedSecret = sharedSecret;
		this.shopName = shopName;
		this.password = password;
	}
	
	public String getApiKey() {
		return apiKey;
	}

	public void setApi_key(String apiKey) {
		this.apiKey = apiKey;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSharedSecret() {
		return sharedSecret;
	}

	public void setSharedSecret(String sharedSecret) {
		this.sharedSecret = sharedSecret;
	}
}
