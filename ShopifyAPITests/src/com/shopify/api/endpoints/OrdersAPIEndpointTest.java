package com.shopify.api.endpoints;

import java.util.HashMap;
import java.util.List;

import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.impl.client.DefaultHttpClient;
import org.codegist.crest.HttpClientRestService;

import android.test.InstrumentationTestCase;

import com.shopify.api.client.ShopifyClient;
import com.shopify.api.credentials.Credential;
import com.shopify.api.resources.Customer;
import com.shopify.api.resources.Order;

public class OrdersAPIEndpointTest extends InstrumentationTestCase {
	Credential creds = new Credential("25df4169edc6c05553f086391e89a106", "", "justmops", "0988dfc35e3f317cf749f152d5849395");
	ShopifyClient client;
	OrdersService orderAPI;
	
	public HttpClientRestService generateHttpClient() {
		DefaultHttpClient c = new DefaultHttpClient();
		AuthScope auth = new AuthScope("justmops.myshopify.com", 443);
		UsernamePasswordCredentials creds = new UsernamePasswordCredentials("25df4169edc6c05553f086391e89a106", "0988dfc35e3f317cf749f152d5849395");
		c.getCredentialsProvider().setCredentials(auth, creds);
		return new HttpClientRestService(c);
	}
	
	public HashMap<String, String> generateConfig(){
		HashMap<String, String> conf = new HashMap<String, String>();
		conf.put("service.end-point", "https://justmops.myshopify.com:443");
		return conf;
	}
	
	public void setUp() throws Exception {
		super.setUp();
		client = new ShopifyClient(creds);
		orderAPI = client.constructService(OrdersService.class);
	}
	
	public void testFetchingAllOrders() throws Exception {
		List<Order> orders = client.handleResponse(orderAPI.getOrders(), Order.class);
		assertEquals(1, orders.size());
	}
	
	public void testFetchingOneOrder() throws Exception {
		List<Order> orders = client.handleResponse(orderAPI.getOrder(66222702), Order.class);
		assertEquals(1, orders.size());
		
		Order o = orders.get(0);
		{
			assertEquals("#1002", o.getName());
			assertEquals(null, o.getBrowserIp());
			assertEquals("0.00", o.getTotalDiscounts());
			assertEquals("f0d72ad56ef9ce9ca31c3c6fae5dd6a6", o.getToken());
			assertEquals(1, o.getShippingLines().size());
			
			Customer c = o.getCustomer();
			{
				assertEquals("Christopher", c.getFirstName());
				assertEquals("Saunders", c.getLastName());
				assertEquals("c.saunders322@gmail.com", c.getEmail());
			}
		}
	}
	

}
