package com.shopify.api.resources;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.ObjectMapper;

public abstract class ShopifyResource {
	@JsonProperty("id")
	private int id = -1;

	@JsonProperty("created_at")
	private String created_at;

	@JsonProperty("updated_at")
	private String updated_at;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@JsonProperty("created_at")
	public String getCreatedAt() {
		return created_at;
	}

	@JsonProperty("created_at")
	public void setCreatedAt(String createdAt) {
		created_at = createdAt;
	}

	@JsonProperty("updated_at")
	public String getUpdatedAt() {
		return updated_at;
	}

	@JsonProperty("updated_at")
	public void setUpdatedAt(String updatedAt) {
		updated_at = updatedAt;
	}

	@JsonIgnore
	public String getFieldName() {
		return this.getClass().getSimpleName().toLowerCase();
	}

	public String toString() {
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.writeValueAsString(this);
		} catch (Exception e) {
			return super.toString();
		}
	}
}
