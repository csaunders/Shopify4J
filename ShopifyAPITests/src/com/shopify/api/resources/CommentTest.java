package com.shopify.api.resources;

import android.test.InstrumentationTestCase;

import com.shopify.api.resources.json.ShopifyRequestWriter;
import com.shopify.api.resources.json.ShopifyResponseReader;
import com.shopify.assets.AssetLoader;

public class CommentTest extends InstrumentationTestCase {
	private ShopifyResponseReader reader;
	private ShopifyRequestWriter writer;
	
	public void setUp() throws Exception {
		super.setUp();
		AssetLoader.instrumentation = getInstrumentation();
		reader = new ShopifyResponseReader();
		writer = new ShopifyRequestWriter();
	}
	
	public void testLoadingSingleComment() throws Exception {
		String commentJson = AssetLoader.loadAsset("fixtures/Comment/singleComment.json");
		
		Comment result = reader.read(commentJson, Comment.class).get(0);
		{
			assertEquals("2011-08-15T13:51:05-04:00", result.getCreatedAt());
			assertEquals("<p>Hi author, I really <em>like</em> what you're doing there.</p>", result.getBodyHtml());
			assertEquals("Hi author, I really _like_ what you're doing there.", result.getBody());
			assertEquals("Soleone", result.getAuthor());
			assertEquals("2011-08-15T13:51:05-04:00", result.getUpdatedAt());
			assertEquals(241253187, result.getBlogId());
			assertEquals(118373535, result.getId());
			assertEquals(134645308, result.getArticleId());
			assertEquals("127.0.0.1", result.getIp());
			assertEquals(
					"Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10_5_4; en-us) AppleWebKit/525.18 (KHTML, like Gecko) Version/3.1.2 Safari/525.20.1",
					result.getUserAgent());
			assertEquals(null, result.getPublishedAt());
			assertEquals("published", result.getStatus());
			assertEquals("sole@one.de", result.getEmail());
		}
	}

}
