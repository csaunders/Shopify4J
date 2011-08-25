package com.shopify.api.endpoints;

import java.util.ArrayList;

import com.shopify.api.APIAuthorization;
import com.shopify.api.resources.ShopifyResource;


public abstract class APIPageable extends API {
	public APIPageable(APIAuthorization auth) { super(auth); }
	
	private static final int DEFAULT_PAGE_SIZE = 50;
	
	private int pageSize = DEFAULT_PAGE_SIZE;
	
	public int getPageCount() {
		return -1;
	}
	
	public ArrayList<ShopifyResource> resourcesForPage(int page){
		return null;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	
}
