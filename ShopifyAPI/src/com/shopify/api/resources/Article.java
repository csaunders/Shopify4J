package com.shopify.api.resources;

import org.codehaus.jackson.annotate.JsonProperty;

public class Article extends ShopifyResource{
	
	@JsonProperty("body_html")
	private String body_html;
	
	@JsonProperty("title")
	private String title;
	
	@JsonProperty("author")
	private String author;
	
	@JsonProperty("summary_html")
	private String summary_html;
	
	@JsonProperty("blog_id")
	private int blog_id;
	
	@JsonProperty("tags")
	private String tags;
	
	@JsonProperty("user_id")
	private int user_id;
	
	@JsonProperty("published_at")
	private String published_at;

	public String getBody_html() {
		return body_html;
	}

	public void setBody_html(String bodyHtml) {
		body_html = bodyHtml;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getSummary_html() {
		return summary_html;
	}

	public void setSummary_html(String summaryHtml) {
		summary_html = summaryHtml;
	}

	public int getBlog_id() {
		return blog_id;
	}

	public void setBlog_id(int blogId) {
		blog_id = blogId;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int userId) {
		user_id = userId;
	}

	public String getPublished_at() {
		return published_at;
	}

	public void setPublished_at(String publishedAt) {
		published_at = publishedAt;
	}
	
	

}
