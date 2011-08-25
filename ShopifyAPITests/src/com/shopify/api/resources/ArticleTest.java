package com.shopify.api.resources;

import java.util.List;

import android.test.InstrumentationTestCase;

import com.shopify.api.resources.json.ShopifyRequestWriter;
import com.shopify.api.resources.json.ShopifyResponseReader;
import com.shopify.assets.AssetLoader;

public class ArticleTest extends InstrumentationTestCase {
	private ShopifyResponseReader reader;
	private ShopifyRequestWriter writer;
	
	public void setUp() throws Exception {
		super.setUp();
		AssetLoader.instrumentation = getInstrumentation();
		reader = new ShopifyResponseReader();
		writer = new ShopifyRequestWriter();
		
	}
	
	public void testLoadingSingleAsset() throws Exception {
		String articleJson = AssetLoader.loadAsset("fixtures/Article/article.json");
		
		Article result = reader.read(articleJson, Article.class).get(0);
		{
			assertEquals("2008-07-31T20:00:00-04:00", result.getCreated_at());
			assertEquals("<p>Do <em>you</em> have an <strong>IPod</strong> yet?</p>", result.getBody_html());
			assertEquals("get on the train now", result.getTitle());
			assertEquals("Dennis", result.getAuthor());
			assertEquals("2008-07-31T20:00:00-04:00", result.getUpdated_at());
			assertEquals(null, result.getSummary_html());
			assertEquals(241253187, result.getBlog_id());
			assertEquals("Announcing", result.getTags());
			assertEquals(134645308, result.getId());
			assertEquals(799407056, result.getUser_id());
			assertEquals("2008-07-31T20:00:00-04:00", result.getPublished_at());
		}
	}
	
	public void testLoadingSeveralAssets() throws Exception {
		String articlesJson = AssetLoader.loadAsset("fixtures/Article/articles.json");
		
		List<Article> articles = reader.read(articlesJson, Article.class);
		
		assertEquals(2, articles.size());
		
		for(Article a : articles) {
			switch(a.getId()) {
			case 989034056:
				assertEquals("John", a.getAuthor());
				assertEquals("Some crazy article I'm coming up with", a.getTitle());
				break;
			case 134645308:
				assertEquals("Dennis", a.getAuthor());
				assertEquals("Announcing", a.getTags());
				break;
			default:
				fail("Encountered unexpected article " + a.getId());
			}
		}
	}

}
