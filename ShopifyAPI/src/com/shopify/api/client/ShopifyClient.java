package com.shopify.api.client;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.List;

import org.codegist.crest.CRest;
import org.codegist.crest.CRestBuilder;
import org.codegist.crest.HttpClientRestService;

import com.shopify.api.APIAuthorization;
import com.shopify.api.credentials.Credential;
import com.shopify.api.endpoints.BaseShopifyService;
import com.shopify.api.resources.ShopifyResource;
import com.shopify.api.resources.json.ShopifyRequestWriter;
import com.shopify.api.resources.json.ShopifyResponseReader;


public class ShopifyClient {
	private CRest crestClient;
	private APIAuthorization auth;
	private Credential creds;
	private ShopifyResponseReader reader = new ShopifyResponseReader();
	private ShopifyRequestWriter writer = new ShopifyRequestWriter();
	
	public ShopifyClient(Credential creds) {
		this.creds = creds;
		this.auth = new APIAuthorization(this.creds);
		crestClient = new CRestBuilder()
						.expectsJson()
						.setRestService(constructClientRestService())
						.overrideDefaultConfigWith(constructConfiguration())
						.build();
	}

	private HashMap<String, String> constructConfiguration(){
		return new HashMap<String, String>(){{
			put("service.end-point", "https://"+creds.getShopName()+".myshopify.com");
		}};
	}
	
	private HttpClientRestService constructClientRestService() {
		return new HttpClientRestService(auth.getAuthorizedClient());
	}
	
	public <T extends BaseShopifyService> T constructService(Class<T> interfaze){
		return crestClient.build(interfaze);
	}
	
	public <T extends ShopifyResource> List<T> handleResponse(InputStream in, Class<T> resource){
		return reader.read(new InputStreamReader(in), resource);
	}
	
	public <T extends ShopifyResource> String convertToJson(T object) throws IOException {
		StringWriter w = new StringWriter();
		writer.write(w, object);
		return w.toString();
	}
}
