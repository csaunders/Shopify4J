package com.shopify.api.resources;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;

import android.test.InstrumentationTestCase;

import com.shopify.assets.AssetLoader;

public class ArticleTest extends InstrumentationTestCase {
	private ObjectMapper mapper;
	
	public void setUp() throws Exception {
		super.setUp();
		AssetLoader.instrumentation = getInstrumentation();
		mapper = new ObjectMapper();
	}
	
	public void testLoadingSingleAsset() throws Exception {
		String articleJson = AssetLoader.loadAsset("fixtures/Article/article.json");

		JsonNode node = mapper.readValue(articleJson, JsonNode.class);
		Article result = mapper.readValue(node.iterator().next(), Article.class);
		{
			assertEquals("2008-07-31T20:00:00-04:00", result.getCreatedAt());
			assertEquals("<p>Do <em>you</em> have an <strong>IPod</strong> yet?</p>", result.getBodyHtml());
			assertEquals("get on the train now", result.getTitle());
			assertEquals("Dennis", result.getAuthor());
			assertEquals("2008-07-31T20:00:00-04:00", result.getUpdatedAt());
			assertEquals(null, result.getSummaryHtml());
			assertEquals(241253187, result.getBlogId());
			assertEquals("Announcing", result.getTags());
			assertEquals(134645308, result.getId());
			assertEquals(799407056, result.getUserId());
			assertEquals("2008-07-31T20:00:00-04:00", result.getPublishedAt());
		}
	}
	
	public void testLoadingSeveralAssets() throws Exception {
		String articlesJson = AssetLoader.loadAsset("fixtures/Article/articles.json");
		
		JsonNode node = mapper.readValue(articlesJson, JsonNode.class);
		Article[] articles = mapper.readValue(node.iterator().next(), Article[].class);
		
		assertEquals(2, articles.length);
		
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
