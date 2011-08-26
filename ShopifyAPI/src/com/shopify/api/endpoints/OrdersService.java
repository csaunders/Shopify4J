package com.shopify.api.endpoints;

import java.io.InputStream;

import org.codegist.crest.annotate.ContextPath;
import org.codegist.crest.annotate.EndPoint;
import org.codegist.crest.annotate.Path;

@EndPoint("")
@ContextPath("/admin")
public interface OrdersService {
	
	@Path("/orders.json")
	InputStream getOrders();
	
	@Path("/orders.json?{0}")
	InputStream getOrders(String queryParams);
	
	@Path("/orders/{0}.json")
	InputStream getOrder(int id);
	
	@Path("/orders/{0}.json?{1}")
	InputStream getOrder(int id, String fieldsParams);
}
