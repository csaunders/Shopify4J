package com.shopify.api.resources;

import java.util.HashMap;
import java.util.Map;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.node.ObjectNode;

public abstract class ShopifyResource {
	protected HashMap<String, Object> attributes = new HashMap<String, Object>();

	@JsonProperty("id")
	public int getId() {
		Integer value = (Integer)attributes.get("id");
		return value != null ? value : 0;
	}

	@JsonProperty("id")
	public void setId(int id) {
		attributes.put("id", id);
	}

	@JsonProperty("created_at")
	public String getCreatedAt() {
		return (String)attributes.get("created_at");
	}

	@JsonProperty("created_at")
	public void setCreatedAt(String createdAt) {
		attributes.put("created_at", createdAt);
	}

	@JsonProperty("updated_at")
	public String getUpdatedAt() {
		return (String)attributes.get("updated_at");
	}

	@JsonProperty("updated_at")
	public void setUpdatedAt(String updatedAt) {
		attributes.put("updated_at", updatedAt);
	}

	@JsonIgnore
	public String getFieldName() {
		return this.getClass().getSimpleName().toLowerCase();
	}

	public String toString() {
		ObjectMapper mapper = new ObjectMapper();
		JsonNode root = mapper.createObjectNode();
		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			((ObjectNode)root).put(entry.getKey(), mapper.valueToTree(entry.getValue()));
		}
		return root.toString();
	}
}
