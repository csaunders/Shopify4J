package com.shopify.api.endpoints;

import java.io.InputStream;

import org.codegist.crest.annotate.ContextPath;
import org.codegist.crest.annotate.Destination;
import org.codegist.crest.annotate.EndPoint;
import org.codegist.crest.annotate.HttpMethod;
import org.codegist.crest.annotate.Path;

import static org.codegist.crest.HttpMethod.POST;
import static org.codegist.crest.HttpMethod.PUT;
import static org.codegist.crest.HttpMethod.DELETE;
import static org.codegist.crest.config.Destination.BODY;

@EndPoint("")
@ContextPath("/admin/orders")
public interface OrdersService extends BaseShopifyService{
	
	@Path(".json")
	InputStream getOrders();
	
	@Path(".json?{0}")
	InputStream getOrders(String queryParams);
	
	@Path("/{0}.json")
	InputStream getOrder(int id);
	
	@Path("/{0}.json?{1}")
	InputStream getOrder(int id, String fieldsParams);
	
	@Path ("/count.json")
	InputStream getCount();
	
	@Path("/count.json?{0}")
	InputStream getCount(String queryParams);
	
	@Path("/{0}/close.json")
	@HttpMethod(POST)
	InputStream closeOrder(int id);
	
	@Path("/{0}/open.json")
	@HttpMethod(POST)
	InputStream openOrder(int id);
	
	@Path("/{0}/cancel.json")
	@HttpMethod(POST)
	InputStream cancelOrder(int id);
	
	@Path("/{0}/cancel.json?{1}")
	@HttpMethod(POST)
	InputStream cancelOrder(int id, String queryParams);
	
	@Path("/{0}.json")
	@HttpMethod(PUT)
	@Destination(BODY)
	InputStream updateOrder(int id, String orderJson);
	
	@Path("/{0}.json")
	@HttpMethod(DELETE)
	void deleteOrder(int id);
}
