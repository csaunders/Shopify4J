package com.shopify.api.resources;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
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
		for (String key : determineKeys()) {
			((ObjectNode)root).put(key, mapper.valueToTree(attributes.get(key)));
		}
		return root.toString();
	}

	protected Set<String> determineKeys(){
		return isDirty() ? dirtyKeys : attributes.keySet();
	}

	protected void setAttribute(String attributeName, Object attributeValue) {
		Object currentValue = attributes.get(attributeName);
		if(currentValue == null || !currentValue.equals(attributeValue)) {
			dirtyKeys.add(attributeName);
		}
		attributes.put(attributeName, attributeValue);
	}

	protected Object getAttribute(String attributeName) {
		return attributes.get(attributeName);
	}

	@JsonIgnore
	public boolean isDirty() {
		return !dirtyKeys.isEmpty();
	}

	@JsonIgnore
	public void makeDirty() {
		dirtyKeys.addAll(attributes.keySet());
	}

	@JsonIgnore
	public void makeDirty(String attribute) {
		if(attributes.keySet().contains(attribute)) {
			dirtyKeys.add(attribute);
		}
	}

	public void clean() {
		dirtyKeys.clear();
	}
}
