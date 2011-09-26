package com.shopify.api.handlers;

import java.io.InputStream;
import java.util.Map;

import org.codegist.crest.CRestException;
import org.codegist.crest.ResponseContext;
import org.codegist.crest.handler.ResponseHandler;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;

import com.shopify.api.resources.ShopifyResource;

public class ShopifyResponseHandler implements ResponseHandler {

	private ObjectMapper mapper;

	public ShopifyResponseHandler(Map<String, Object> parameters) {
		mapper = new ObjectMapper();
	}

	public Object handle(ResponseContext context) throws CRestException {
		if (context.getExpectedType() == void.class) {
			return null;
		}
		try {
			InputStream stream = context.getResponse().asStream();
			JsonNode node = mapper.readValue(stream, JsonNode.class);
			Object deserialized = mapper.readValue(node.iterator().next(), context.getExpectedType());
			if(deserialized instanceof ShopifyResource) {
				((ShopifyResource) deserialized).clean();
			}
			return deserialized;
		} catch (Exception e) {
			CRestException newexc = new CRestException(e.getMessage(), e.getCause());
			newexc.setStackTrace(e.getStackTrace());
			throw newexc;
		} finally {
			context.getResponse().close();
		}
	}

}
