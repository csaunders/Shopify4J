package com.shopify.api.credentials;

public interface ShopifyCredentialsStore {
	public Credential loadCredential(String shop) throws Exception;
	public void saveCredential(Credential credential) throws Exception;
}
