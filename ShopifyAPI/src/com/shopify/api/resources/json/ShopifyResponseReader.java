package com.shopify.api.resources.json;

import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONTokener;

import com.shopify.api.resources.ShopifyResource;

public class ShopifyResponseReader {
	
	private ObjectMapper mapper;
	private JsonFactory factory;
	
	public ShopifyResponseReader() {
		this(new ObjectMapper());
	}
	
	public ShopifyResponseReader(ObjectMapper mapper) {
		this.mapper = mapper;
		this.factory = mapper.getJsonFactory();
	}
	
	public <T extends ShopifyResource> List<T> read(String response, Class<T> type){
		return read(new StringReader(response), type);
	}
	
	public <T extends ShopifyResource> List<T> read(Reader response, Class<T> type){
		ArrayList<T> resources = new ArrayList<T>();
		
		try {
			JsonParser parser = factory.createJsonParser(response);
			JsonToken token = parser.nextToken();
			assert(token == JsonToken.START_OBJECT);
			while((token = parser.nextToken()) != null) {
				if(token == JsonToken.END_OBJECT) break;
				token = parser.nextToken();
				if(token == JsonToken.START_ARRAY) {
					while((token = parser.nextToken()) != JsonToken.END_ARRAY) {
						resources.add(mapper.readValue(parser, type));
					}
					break;
				} else if(token == JsonToken.START_OBJECT) {
					resources.add(mapper.readValue(parser, type));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return resources;
	}

}
