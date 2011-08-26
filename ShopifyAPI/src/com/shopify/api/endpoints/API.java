package com.shopify.api.endpoints;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import com.shopify.api.APIAuthorization;
import com.shopify.api.resources.ShopifyResource;

public abstract class API {
	private static final String MY_SHOPIFY_COM_ADMIN = ".myshopify.com/admin/";
	private static final String URI_SCHEME = "http://";
	private static final int SHOPIFY_PORT = 80;
	
	public enum APIResponseContent {XML, JSON, NONE}
	
	private APIResponseContent content = APIResponseContent.JSON;
	private APIAuthorization auth;
	
	public API(APIAuthorization auth) {
		this.auth = auth;
	}
	
	protected APIAuthorization getApiAuth() {
		return this.auth;
	}
	
	public HashMap<String, String> apiQueryParams(){
		// TODO: Implement this
		return null;
	}
	
	public URI constructURI(HashMap<String, String> queryParameters) {
		return constructURI(-1, null, queryParameters);
	}
	
	public URI constructURI(String additionalPath, HashMap<String, String> queryParameters) {
		return constructURI(-1, additionalPath, queryParameters);
	}
	
	public URI constructURI(int id, String additionalPath, HashMap<String, String> queryParameters) {
		StringBuilder builder = new StringBuilder();
		builder.append(URI_SCHEME);
		builder.append(auth.getCredential().getShopName());
		builder.append(MY_SHOPIFY_COM_ADMIN);
		builder.append(getAPIEndpoint());
		if(id > 0) {
			builder.append("/");
			builder.append(id);
		}
		builder.append(getContentTypeExtension());
		
		if(queryParameters != null && queryParameters.size() > 0) {
			builder.append("?");
			int keyLength = queryParameters.keySet().size();
			ArrayList<String> sortedKeys = new ArrayList<String>(queryParameters.keySet());
			Collections.sort(sortedKeys);
			for(String key : sortedKeys) {
				--keyLength;
				String value = queryParameters.get(key);
				if(value != null) {
					builder.append(URLEncoder.encode(key));
					builder.append("=");
					builder.append(URLEncoder.encode(value));
					if(keyLength > 0) {
						builder.append("&");
					}
				}
			}
		}
		try {
			return new URI(builder.toString());
		} catch (URISyntaxException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public String getContentTypeExtension() {
		switch(content) {
		case NONE:
			return "";
		case XML:
			return ".xml";
		case JSON:
		default:
			return ".json";
		}
	}
	
	public void setContentTypeExtension(APIResponseContent type) {
		this.content = type;
	}
	
	public abstract int getCount();
	public abstract List<ShopifyResource> getAll();
	public abstract ShopifyResource findById(int id);
	public abstract List<ShopifyResource> findByQuery(HashMap<String, String> queryParams);
	
	protected abstract String getAPIEndpoint();

}
