package com.shopify.api.resources;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.node.ObjectNode;

public abstract class ShopifyResource {
	private HashMap<String, Object> attributes = new HashMap<String, Object>();
	private HashSet<String> dirtyKeys = new HashSet<String>();

	@JsonProperty("id")
	public int getId() {
		Integer value = (Integer)getAttribute("id");
		return value != null ? value : 0;
	}

	@JsonProperty("id")
	public void setId(int id) {
		setAttribute("id", id);
	}

	@JsonProperty("created_at")
	public String getCreatedAt() {
		return (String)getAttribute("created_at");
	}

	@JsonProperty("created_at")
	public void setCreatedAt(String createdAt) {
		setAttribute("created_at", createdAt);
	}

	@JsonProperty("updated_at")
	public String getUpdatedAt() {
		return (String) getAttribute("updated_at");
	}

	@JsonProperty("updated_at")
	public void setUpdatedAt(String updatedAt) {
		setAttribute("updated_at", updatedAt);
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

	protected void setAttribute(String attributeName, Object attributeValue) {
		if(attributeValue == null) return;

		if(attributes.containsKey(attributeName) && !attributes.get(attributeName).equals(attributeValue)) {
				dirtyKeys.add(attributeName);
		}
		attributes.put(attributeName, attributeValue);
	}

	protected Object getAttribute(String attributeName) {
		return attributes.get(attributeName);
	}

	public boolean isDirty() {
		return !dirtyKeys.isEmpty();
	}
}
