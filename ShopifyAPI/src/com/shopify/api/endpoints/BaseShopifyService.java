package com.shopify.api.endpoints;

import java.io.InputStream;

import org.codegist.crest.annotate.ContextPath;
import org.codegist.crest.annotate.EndPoint;
import org.codegist.crest.annotate.Path;

@EndPoint("")
@ContextPath("/admin")
public interface BaseShopifyService {
	
	@Path("/{0}.json")
	InputStream getShopifyResources(String resourceName);
	
	@Path("/{0}.json?{1}")
	InputStream getShopifyResourcesWithArgs(String resourceName, String params);
	
	@Path("/{0}/{1}.json")
	InputStream getShopifyResource(String resourceName, int id);
	
	
}
