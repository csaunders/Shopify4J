package com.shopify.api.endpoints;

import static org.codegist.crest.HttpMethod.DELETE;
import static org.codegist.crest.HttpMethod.POST;
import static org.codegist.crest.HttpMethod.PUT;
import static org.codegist.crest.config.Destination.BODY;

import java.io.InputStream;

import org.codegist.crest.annotate.ContextPath;
import org.codegist.crest.annotate.Destination;
import org.codegist.crest.annotate.EndPoint;
import org.codegist.crest.annotate.HttpMethod;
import org.codegist.crest.annotate.Path;

@EndPoint("")
@ContextPath("/admin/")
public interface JsonPipeService extends BaseShopifyService{
	
	@Path("{0}.json")
	InputStream read(String endpoint);
	
	@Path("{0}.json")
	@HttpMethod(POST)
	InputStream create(String endpoint, @Destination(BODY) String data);
	
	@Path("{0}.json")
	@HttpMethod(PUT)
	InputStream update(String endpoint, @Destination(BODY) String data);
	
	@Path("{0}.json")
	@HttpMethod(DELETE)
	InputStream destroy(String endpoint);

}
