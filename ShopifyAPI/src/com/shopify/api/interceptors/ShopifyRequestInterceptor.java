package com.shopify.api.interceptors;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpException;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.entity.StringEntity;
import org.apache.http.protocol.HttpContext;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.node.ObjectNode;

public class ShopifyRequestInterceptor implements HttpRequestInterceptor
{
	private ObjectMapper mapper;

	public ShopifyRequestInterceptor()
	{
		mapper = new ObjectMapper();
	}

	public void process(HttpRequest request, HttpContext context)
			throws HttpException, IOException
	{
		if (request instanceof HttpEntityEnclosingRequest) {
			HttpEntityEnclosingRequest entity_request = (HttpEntityEnclosingRequest)request;
			HttpEntity entity = entity_request.getEntity();
			if (URLEncodedUtils.isEncoded(entity)) {
				JsonNode rootNode = mapper.createObjectNode();
				for (NameValuePair field: URLEncodedUtils.parse(entity)) {
					((ObjectNode) rootNode).put(field.getName(), mapper.readTree(field.getValue()));
				}
				entity = new StringEntity(rootNode.toString());
				((StringEntity) entity).setContentType("application/json");
				entity_request.setEntity(entity);
				entity_request.setHeader(entity.getContentType());
				entity_request.setHeader("Content-Length", Long.toString(entity.getContentLength()));
			}
		}
	}

}
