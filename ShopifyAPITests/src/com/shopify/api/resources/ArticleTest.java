package com.shopify.api.resources;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.mrbean.MrBeanModule;

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
		String articleJson = AssetLoader.loadAsset("fixtures/articles/article.json");
		
		assertTrue(articleJson.length() > 0);

		Article result = mapper.readValue(articleJson, Article.class);
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

}
