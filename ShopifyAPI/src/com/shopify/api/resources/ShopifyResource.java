package com.shopify.api.resources;

import java.io.IOException;
import java.io.StringWriter;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;

import com.shopify.api.resources.json.ShopifyRequestWriter;

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
	
	@JsonIgnore
	public String getFieldName() {
		return this.getClass().getSimpleName().toLowerCase();
	}
	
	public String toString() {
		StringWriter w = new StringWriter();
		ShopifyRequestWriter writer = new ShopifyRequestWriter();
		try {
			writer.write(w, this);
		} catch (IOException e) {
			return super.toString();
		}
		return w.toString();
	}
}
