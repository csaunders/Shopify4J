package com.shopify.api.endpoints;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

import android.content.Context;
import android.test.InstrumentationTestCase;

import com.shopify.api.client.ShopifyClient;
import com.shopify.api.credentials.Credential;
import com.shopify.api.resources.Image;

public class ProductImagesAPITest extends InstrumentationTestCase {
	Credential creds = new Credential("25df4169edc6c05553f086391e89a106", "", "justmops", "0988dfc35e3f317cf749f152d5849395");
	ShopifyClient client;
	ProductImagesService imagesAPI;
	File output;
	
	public void setUp() throws Exception {
		super.setUp();
		client = new ShopifyClient(creds);
		imagesAPI = client.constructService(ProductImagesService.class);
		output = new File(getInstrumentation().getContext().getFilesDir(), "output.jpg");
	}
	
	public void tearDown() throws Exception {
		if( output.exists() ) output.delete();
		super.tearDown();
	}
	
	public void testAddingAProudctImage() throws Exception {
		Context ctx = getInstrumentation().getContext();
		Image i = new Image();
		i.setPosition(1);
		i.setFilename("fantastic.jpg");
		
		InputStream is = ctx.getAssets().open("images/shopify.jpg");
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		
		byte[] buff= new byte[0x4000];
		int readCount = 0;
		FileOutputStream fos = new FileOutputStream(output);
		while( (readCount = is.read(buff)) > 0) {
			fos.write(buff, 0, readCount);
		}
		
		is.close();
		fos.close();
		i.setImage(output);
		
		imagesAPI.createProductImage(30193172, i);
	}
}
