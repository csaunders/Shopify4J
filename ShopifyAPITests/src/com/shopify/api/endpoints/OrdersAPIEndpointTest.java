package com.shopify.api.endpoints;

import java.util.List;

import android.test.InstrumentationTestCase;

import com.shopify.api.client.ShopifyClient;
import com.shopify.api.credentials.Credential;
import com.shopify.api.resources.Customer;
import com.shopify.api.resources.Order;

public class OrdersAPIEndpointTest extends InstrumentationTestCase {
	Credential creds = new Credential("25df4169edc6c05553f086391e89a106", "", "justmops", "0988dfc35e3f317cf749f152d5849395");
	ShopifyClient client;
	OrdersService orderAPI;
	
	public void setUp() throws Exception {
		super.setUp();
		client = new ShopifyClient(creds);
		orderAPI = client.constructService(OrdersService.class);
	}
	
	public void testFetchingAllOrders() throws Exception {
		List<Order> orders = orderAPI.getOrders();
		assertEquals(4, orders.size());
	}
	
	public void testFetchingOneOrder() throws Exception {
		Order o = orderAPI.getOrder(66222702);
		{
			assertEquals("#1002", o.getName());
			assertEquals(null, o.getBrowserIp());
			assertEquals("0.00", o.getTotalDiscounts());
			assertEquals("f0d72ad56ef9ce9ca31c3c6fae5dd6a6", o.getToken());
			assertEquals(1, o.getShippingLines().size());
			assertFalse(o.isDirty());
			
			Customer c = o.getCustomer();
			{
				assertEquals("Christopher", c.getFirstName());
				assertEquals("Saunders", c.getLastName());
				assertEquals("c.saunders322@gmail.com", c.getEmail());
			}
		}
	}
	

}
