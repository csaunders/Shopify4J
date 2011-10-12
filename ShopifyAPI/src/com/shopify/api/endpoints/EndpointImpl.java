package com.shopify.api.endpoints;

import org.apache.http.client.HttpClient;

public interface EndpointImpl extends BaseShopifyService{
	
	public void setEndpoint(String endpoint);
	
	public void setHttpClient(HttpClient client);
	
	public void setServiceInterface(BaseShopifyService service);
	
	public Class<?> getServiceClass();
}
