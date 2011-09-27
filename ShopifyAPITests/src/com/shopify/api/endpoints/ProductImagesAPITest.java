package com.shopify.api.endpoints;

import java.io.File;
import java.io.FileOutputStream;

import android.content.Context;
import android.os.Environment;
import android.test.InstrumentationTestCase;

import com.shopify.api.client.ShopifyClient;
import com.shopify.api.credentials.Credential;
import com.shopify.api.resources.Image;

public class ProductImagesAPITest extends InstrumentationTestCase {
	Credential creds = new Credential("25df4169edc6c05553f086391e89a106", "", "justmops", "0988dfc35e3f317cf749f152d5849395");
	ShopifyClient client;
	ProductImagesService imagesAPI;
	
	public void setUp() throws Exception {
		super.setUp();
		client = new ShopifyClient(creds);
		imagesAPI = client.constructService(ProductImagesService.class);
	}
	
	public void testAddingAProudctImage() throws Exception {
		Context ctx = getInstrumentation().getContext();
		Image i = new Image();
		i.setPosition(1);
		i.setFilename("fantastic.jpg");
		i.setImage(ctx.getAssets().open("images/shopify.jpg"));
		
		imagesAPI.createProductImage(30193172, i);
	}
}
