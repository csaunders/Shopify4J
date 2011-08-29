package com.shopify.api.endpoints;

import java.util.ArrayList;
import java.util.List;

import android.test.InstrumentationTestCase;

import com.shopify.api.client.ShopifyClient;
import com.shopify.api.credentials.Credential;
import com.shopify.api.resources.Product;

public class ProductsAPIEndpointTest extends InstrumentationTestCase {
	Credential creds = new Credential("25df4169edc6c05553f086391e89a106", "", "justmops", "0988dfc35e3f317cf749f152d5849395");
	ShopifyClient client;
	ProductsService productAPI;
	
	public void setUp() throws Exception {
		super.setUp();
		client = new ShopifyClient(creds);
		productAPI = client.constructService(ProductsService.class);
	}
	
	public void testMakingAPICalls() throws Exception {
		int count = productAPI.getProductCount();
		assertEquals(3, count);

		List<Product> response = productAPI.getProducts();
		assertEquals(3, response.size());

//		Product newProduct = new Product();
//		newProduct.setProductType("Snowboard");
//		newProduct.setBodyHtml("<strong>Good snowboard!</strong>");
//		newProduct.setTitle("Burton Custom FreeArrayList<E>");
//		newProduct.setVariants(new ArrayList<Variant>());
//		newProduct.setVendor("appl");
//		newProduct.setOptions(new ArrayList<Option>());
//
//		Product createdProduct = productAPI.createProduct(newProduct.toString());
	}
	

}
