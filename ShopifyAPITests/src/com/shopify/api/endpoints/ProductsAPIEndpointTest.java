package com.shopify.api.endpoints;

import java.util.ArrayList;
import java.util.List;

import android.test.InstrumentationTestCase;

import com.shopify.api.client.ShopifyClient;
import com.shopify.api.credentials.Credential;
import com.shopify.api.resources.Option;
import com.shopify.api.resources.Product;
import com.shopify.api.resources.Variant;

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
		int count = productAPI.getCount();

		Product newProduct = new Product();
		newProduct.setProductType("Snowboard");
		newProduct.setBodyHtml("<strong>Good snowboard!</strong>");
		newProduct.setTitle("Burton Custom Free");
		newProduct.setVariants(new ArrayList<Variant>());
		newProduct.setVendor("appl");
		newProduct.setOptions(new ArrayList<Option>());

		Product createdProduct = productAPI.createProduct(newProduct);
		assertEquals("Snowboard", createdProduct.getProductType());
		assertEquals("Burton Custom Free", createdProduct.getTitle());
		
		int product_id = createdProduct.getId();
		Product foundProduct = productAPI.getProduct(product_id);
		assertEquals("Snowboard", foundProduct.getProductType());

		assertEquals(count + 1, productAPI.getCount());

		List<Product> response = new ArrayList<Product>() {{
			for(Product p : productAPI.getProducts()) {
				add(p);
			}
		}};
		assertEquals(count + 1, response.size());

		Product productUpdate1 = new Product();
		productUpdate1.setId(product_id);
		String newTitle = "Title from Update 1";
		productUpdate1.setTitle(newTitle);
		productAPI.updateProduct(product_id, productUpdate1);

		Product productUpdate2 = new Product();
		productUpdate2.setId(product_id);
		String newVendor = "Vendor from Update 2";
		productUpdate2.setVendor(newVendor);
		productAPI.updateProduct(product_id, productUpdate2);

		foundProduct = productAPI.getProduct(product_id);
		assertEquals(productUpdate1.getTitle(), foundProduct.getTitle());
		assertEquals(productUpdate2.getVendor(), foundProduct.getVendor());
		assertEquals(newProduct.getProductType(), foundProduct.getProductType());

		productAPI.deleteProduct(product_id);

		assertEquals(count, productAPI.getCount());
	}
	

}
