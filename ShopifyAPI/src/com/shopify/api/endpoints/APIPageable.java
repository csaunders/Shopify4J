package com.shopify.api.endpoints;

import java.util.ArrayList;
import java.util.HashMap;

import com.shopify.api.APIAuthorization;
import com.shopify.api.resources.ShopifyResource;


public abstract class APIPageable extends API {
	public APIPageable(APIAuthorization auth) { super(auth); }
	private static final String PAGE = "page";
	//private static final String 
	
	private static final int DEFAULT_PAGE_SIZE = 50;
	
	private int pageSize = DEFAULT_PAGE_SIZE;
	
	public int getPageCount() {
		return -1;
	}
	
	public ArrayList<ShopifyResource> resourcesForPage(int page){
		return resourcesForPage(page, new HashMap<String, String>());
	}
	
	public ArrayList<ShopifyResource> resourcesForPage(int page, HashMap<String, String> additionalParams){
		//additionalParams.put(key, value)
		return null;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	
}
