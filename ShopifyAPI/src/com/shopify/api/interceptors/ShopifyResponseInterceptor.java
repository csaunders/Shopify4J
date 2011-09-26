package com.shopify.api.interceptors;

import java.io.IOException;

import org.apache.http.HttpException;
import org.apache.http.HttpResponse;
import org.apache.http.HttpResponseInterceptor;
import org.apache.http.protocol.HttpContext;

public class ShopifyResponseInterceptor implements HttpResponseInterceptor {

	public void process(HttpResponse response, HttpContext context)
			throws HttpException, IOException {
		/* CRest 1.0.1 throws an exception is the status code != 200,
		 * even on 201 Created, just translate all 200 responses to error code 200. */
		int code = response.getStatusLine().getStatusCode();
		if (code >= 200 && code < 300) {
			response.setStatusCode(200);
		}
	}

}
