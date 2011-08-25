package com.shopify.api.endpoints;

import java.net.URI;
import java.util.HashMap;
import java.util.List;

import com.shopify.api.APIAuthorization;
import com.shopify.api.resources.ShopifyResource;

public class AuthAPI extends API {
	private static final String AUTH_API_ENDPOINT = "api/auth";
	
	public AuthAPI(APIAuthorization auth) {
		super(auth);
		setContentTypeExtension(APIResponseContent.NONE);
	}

	@Override
	public ShopifyResource findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ShopifyResource> findByQuery(HashMap<String, String> queryParams) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ShopifyResource> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public String getAPIEndpoint() {
		return AUTH_API_ENDPOINT;
	}
	
	public URI getAuthRequestURI() {
		HashMap<String, String> params = new HashMap<String, String>(){{
			put("api_key", getApiAuth().getCredential().getApiKey());
		}};
		return constructURI(params);
	}

}
