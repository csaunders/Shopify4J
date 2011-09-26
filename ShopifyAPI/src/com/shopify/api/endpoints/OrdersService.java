package com.shopify.api.endpoints;

import java.util.List;

import org.codegist.crest.annotate.ContextPath;
import org.codegist.crest.annotate.Destination;
import org.codegist.crest.annotate.EndPoint;
import org.codegist.crest.annotate.HttpMethod;
import org.codegist.crest.annotate.Name;
import org.codegist.crest.annotate.Path;
import org.codegist.crest.annotate.ResponseHandler;

import com.shopify.api.handlers.ShopifyResponseHandler;
import com.shopify.api.resources.Order;

import static org.codegist.crest.HttpMethod.POST;
import static org.codegist.crest.HttpMethod.PUT;
import static org.codegist.crest.HttpMethod.DELETE;
import static org.codegist.crest.config.Destination.BODY;

@EndPoint("")
@ContextPath("/admin/orders")
@ResponseHandler(ShopifyResponseHandler.class)
public interface OrdersService extends BaseShopifyService{
	
	@Path(".json")
	List<Order> getOrders();
	
	@Path(".json?{0}")
	List<Order> getOrders(String queryParams);
	
	@Path("/{0}.json")
	Order getOrder(int id);
	
	@Path("/{0}.json?{1}")
	Order getOrder(int id, String fieldsParams);
	
	@Path ("/count.json")
	int getCount();
	
	@Path("/count.json?{0}")
	int getCount(String queryParams);
	
	@Path("/{0}/close.json")
	@HttpMethod(POST)
	Order closeOrder(int id);
	
	@Path("/{0}/open.json")
	@HttpMethod(POST)
	Order openOrder(int id);
	
	@Path("/{0}/cancel.json")
	@HttpMethod(POST)
	Order cancelOrder(int id);
	
	@Path("/{0}/cancel.json?{1}")
	@HttpMethod(POST)
	Order cancelOrder(int id, String queryParams);
	
	@Path("/{0}.json")
	@HttpMethod(PUT)
	Order updateOrder(int id, @Destination(BODY) @Name("order") String orderJson);
	
	@Path("/{0}.json")
	@HttpMethod(DELETE)
	void deleteOrder(int id);
}
