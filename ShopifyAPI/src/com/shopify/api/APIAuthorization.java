package com.shopify.api;

import java.net.URI;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.DefaultHttpClient;

import com.apache.commons.codec.binary.Hex;
import com.shopify.api.endpoints.AuthAPI;

public class APIAuthorization {
	private static final String SIGNATURE = "signature";
	private static final String TOKEN = "t";
	
	
	private String apiKey, sharedSecret, shopName, password;
	
	public APIAuthorization(String apiKey, String sharedSecret, String shopName) {
		this(apiKey, sharedSecret, shopName, null);
	}
	
	public APIAuthorization(String apiKey, String sharedSecret, String shopName, String password) {
		this.apiKey = apiKey;
		this.sharedSecret = sharedSecret;
		this.shopName = shopName;
		this.password = password;
	}
	
	public boolean isValidShopifyResponse(HashMap<String, String> responseParameters) {
		String signature = responseParameters.remove(SIGNATURE);
		
		String preDigest = generatePreDigest(responseParameters);
		return signature.equals(toMD5Hexdigest(preDigest));
	}
	
	String generatePreDigest(HashMap<String, String> responseParameters) {
		ArrayList<String> sortedKeys = new ArrayList<String>(responseParameters.keySet());
		Collections.sort(sortedKeys);
		
		StringBuilder preDigest = new StringBuilder(this.sharedSecret);
		for(String key : sortedKeys) {
			preDigest.append(key);
			preDigest.append("=");
			preDigest.append(responseParameters.get(key));
		}
		return preDigest.toString();
	}
	
	public boolean getAPIPassword(HashMap<String, String> responseParameters) {
		if(isValidShopifyResponse(responseParameters)) {
			StringBuilder builder = new StringBuilder();
			builder.append(sharedSecret);
			builder.append(responseParameters.get(TOKEN));
			this.password = toMD5Hexdigest(builder.toString());
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
			put("api_key", getApiKey());
		}};
		URI authEndpoint = apiAuthRequest.constructURI(params);
		return authEndpoint;
	}
	
	public HttpClient getAuthorizedClient(String hostName, int port) {
		DefaultHttpClient client = new DefaultHttpClient();
		
		AuthScope scope = new AuthScope(hostName, port);
		UsernamePasswordCredentials creds = new UsernamePasswordCredentials(this.apiKey, this.password);
		client.getCredentialsProvider().setCredentials(scope, creds);
		
		return client;
	}
	
	public boolean isAuthorized() { return this.password != null; }

	public String getShopName() {
		return shopName;
	}

	public String getPassword() {
		return password;
	}
	
	public String getApiKey() {
		return apiKey;
	}
	

}
