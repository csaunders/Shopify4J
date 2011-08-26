package com.shopify.api.resources.json;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;

import org.codegist.crest.serializer.Serializer;
import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.map.ObjectMapper;

import com.shopify.api.resources.ShopifyResource;

public class ShopifyRequestWriter implements Serializer<ShopifyResource>{
	ObjectMapper mapper;
	JsonFactory factory;
		
	public ShopifyRequestWriter() {
		this(new ObjectMapper());
	}
	
	public ShopifyRequestWriter(ObjectMapper mapper) {
		this.mapper = mapper;
		this.factory = mapper.getJsonFactory();
	}
	
	public void write(Writer output, ShopifyResource resource) throws IOException{
		JsonGenerator generator = factory.createJsonGenerator(output);
		
		generator.writeStartObject();
		generator.writeObjectField(resource.getClass().getSimpleName().toLowerCase(), resource);
		generator.writeEndObject();
		
		generator.close();
		output.flush();
	}
	
	public String serialize(ShopifyResource value) {
		StringWriter w = new StringWriter();
		try {
			write(w, value);
		} catch (IOException e) {
			return "COULD NOT SERIALIZE!";
		}
		return w.toString();
	}

}
