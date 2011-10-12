package com.shopify.api;

import java.io.IOException;
import java.net.URI;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import org.apache.http.HttpException;
import org.apache.http.HttpResponse;
import org.apache.http.HttpResponseInterceptor;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.HttpContext;

import com.apache.commons.codec.binary.Hex;
import com.shopify.api.endpoints.AuthAPI;
import com.shopify.api.interceptors.ShopifyRequestInterceptor;
import com.shopify.api.interceptors.ShopifyResponseInterceptor;
import com.shopify.api.credentials.ShopifyCredentialsStore;
import com.shopify.api.credentials.Credential;

public class APIAuthorization {
	private static final String SIGNATURE = "signature";
	private static final String TOKEN = "t";
	
	private Credential credential;
	private ShopifyCredentialsStore credentialsStore = null;
	private HttpClient client;
	
	public APIAuthorization(Credential credential) {
		this.credential = credential;
	}
	
	public APIAuthorization(ShopifyCredentialsStore store, String shop) throws Exception {
		this(store.loadCredential(shop));
		this.credentialsStore = store;
	}
	
	public boolean isValidShopifyResponse(HashMap<String, String> responseParameters) {
		String signature = responseParameters.remove(SIGNATURE);
		
		String preDigest = generatePreDigest(responseParameters);
		return signature.equals(toMD5Hexdigest(preDigest));
	}
	
	String generatePreDigest(HashMap<String, String> responseParameters) {
		ArrayList<String> sortedKeys = new ArrayList<String>(responseParameters.keySet());
		Collections.sort(sortedKeys);
		
		StringBuilder preDigest = new StringBuilder(credential.getSharedSecret());
		for(String key : sortedKeys) {
			preDigest.append(key);
			preDigest.append("=");
			preDigest.append(responseParameters.get(key));
		}
		return preDigest.toString();
	}
	
	public boolean computeAPIPassword(HashMap<String, String> responseParameters) throws Exception {
		if(isValidShopifyResponse(responseParameters)) {
			StringBuilder builder = new StringBuilder();
			builder.append(credential.getSharedSecret());
			builder.append(responseParameters.get(TOKEN));
			credential.setPassword(toMD5Hexdigest(builder.toString()));
			if (credentialsStore != null) {
				credentialsStore.saveCredential(credential);
			}
			return true;
		}
		return false;
	}
	
	public String toMD5Hexdigest(String message) {
		if(message != null) {
			try {
				MessageDigest digest = MessageDigest.getInstance("MD5");
				byte[] digestBytes = digest.digest(message.getBytes());
				
				return Hex.encodeHexString(digestBytes);
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
		}
		return "";
	}
	
	public URI generateAuthRequest() {
		AuthAPI apiAuthRequest = new AuthAPI(this);
		HashMap<String, String> params = new HashMap<String, String>(){{
			put("api_key", credential.getApiKey());
		}};
		URI authEndpoint = apiAuthRequest.constructURI(params);
		return authEndpoint;
	}
	
	public HttpClient getAuthorizedClient() {
		return getAuthorizedClient(credential.getShopName()+".myshopify.com", 443);
	}
	
	public HttpClient getAuthorizedClient(String hostName, int port) {
		if(client == null) {
			DefaultHttpClient client = new DefaultHttpClient();
			client.addRequestInterceptor(new ShopifyRequestInterceptor());
			client.addResponseInterceptor(new ShopifyResponseInterceptor());
			AuthScope scope = new AuthScope(hostName, port);
			UsernamePasswordCredentials creds = new UsernamePasswordCredentials(credential.getApiKey(), credential.getPassword());
			client.getCredentialsProvider().setCredentials(scope, creds);
			this.client = client;
		}
		
		return client;
	}
	
	public boolean isAuthorized() { return credential.getPassword() != null; }

	public Credential getCredential() {
		return credential;
	}
	
	public void setCredential(Credential credential) {
		this.credential = credential;
	}
	
	public ShopifyCredentialsStore getCredentailsStore() {
		return credentialsStore;
	}
	
	public void setCredentialStore(ShopifyCredentialsStore credentialsStore) {
		this.credentialsStore = credentialsStore;
	}
}
