package com.shopify.api.endpoints;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;

import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.impl.client.DefaultHttpClient;
import org.codegist.crest.CRest;
import org.codegist.crest.CRestBuilder;
import org.codegist.crest.HttpClientRestService;

import android.test.InstrumentationTestCase;

import com.shopify.api.resources.Order;
import com.shopify.api.resources.json.ShopifyResponseReader;

public class OrdersAPIEndpointTest extends InstrumentationTestCase {
	CRest crest;
	OrdersService orderAPI;
	ShopifyResponseReader reader;
	
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
		crest = new CRestBuilder().setRestService(generateHttpClient()).returnRawResults().overrideDefaultConfigWith(generateConfig()).build();
		orderAPI = crest.build(OrdersService.class);
		reader = new ShopifyResponseReader();
	}
	
	public void testMakingAPICalls() throws Exception {
		InputStream response = orderAPI.getOrders();
		InputStreamReader rdr = new InputStreamReader(response);
		List<Order> orders = reader.read(rdr, Order.class);
		assertTrue(orders.size() > 0);
	}
	

}
