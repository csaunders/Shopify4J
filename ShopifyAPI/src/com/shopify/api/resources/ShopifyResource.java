package com.shopify.api.resources;

import org.codehaus.jackson.annotate.JsonProperty;

public abstract class ShopifyResource {
	@JsonProperty("id")
	private int id;
	
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

	public String getCreated_at() {
		return created_at;
	}

	public void setCreated_at(String createdAt) {
		created_at = createdAt;
	}

	public String getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(String updatedAt) {
		updated_at = updatedAt;
	}
	
}
