package com.shopify.api.credentials;

import java.util.Set;

public interface ShopifyCredentialsStore {
	public Credential loadCredential(String shop) throws Exception;
	public void saveCredential(Credential credential) throws Exception;
	public Set<String> getAvailableShops() throws Exception;
}
