package com.shopify.api.credentials;

public class Credential {
	
	private String shopName;
	private String apiKey;
	private String password;
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
	
	// Beans nead null constructors
	public Credential() {}

	public String getApiKey() {
		return apiKey;
	}

	public void setApiKey(String apiKey) {
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
