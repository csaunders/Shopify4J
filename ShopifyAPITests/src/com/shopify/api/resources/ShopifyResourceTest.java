package com.shopify.api.resources;

import android.test.AndroidTestCase;

public class ShopifyResourceTest extends AndroidTestCase {
	private class SomeShopifyResource extends ShopifyResource {
		public void setAttribute(String name, String value) {
			super.setAttribute(name, value);
		}
	}

	private SomeShopifyResource resource;

	public void setUp() throws Exception {
		super.setUp();
		resource = new SomeShopifyResource();
		resource.setCreatedAt("2011-01-01T00:00:00-04:00");
		resource.clean();
	}

	public void tearDown() throws Exception {
		super.setUp();
	}

	public void testCanCleanAResource() {
		resource.setAttribute("thing", "123");
		assertTrue(resource.isDirty());

		resource.clean();
		assertFalse(resource.isDirty());
	}

	public void testSettingNewAttributes() {
		resource.setAttribute("thing", "123");
		assertTrue(resource.isDirty());
		resource.clean();

		resource.setAttribute("thing", "123");
		assertFalse(resource.isDirty());

		resource.setAttribute("thing", "456");
		assertTrue(resource.isDirty());
	}


	public void testSettingValuesOnNewObjectDoesNotFlagAsDirty() {
		assertEquals("2011-01-01T00:00:00-04:00", resource.getCreatedAt());

		resource.setCreatedAt("2011-01-02T00:00:00-04:00");
		assertTrue(resource.isDirty());
		assertEquals("2011-01-02T00:00:00-04:00", resource.getCreatedAt());
	}

	public void testSettingValueToSameValueDoesNotTriggerFlaggingResourceAsDirty() {
		resource.setCreatedAt("2011-01-01T00:00:00-04:00");
		assertFalse(resource.isDirty());
	}

	public void testCanSetValueToNull() {
		resource.setCreatedAt(null);
		assertTrue(resource.isDirty());
		assertEquals(null, resource.getCreatedAt());
	}

	public void testReplacingANullValueFlagsResourceAsDirty() {
		resource.setAttribute("thing", null);
		resource.clean();

		resource.setAttribute("thing", "123");
		assertTrue(resource.isDirty());
	}

	public void testCanForceAnAttributeToBeDirty() {
		assertFalse(resource.isDirty());
		resource.makeDirty("created_at");

		assertTrue(resource.isDirty());
	}

	public void testConvertingCleanResourceToJSON() {
		String expectedJSON = "{\"created_at\":\"2011-01-01T00:00:00-04:00\"}";
		assertEquals(expectedJSON, resource.toString());
	}

	public void testConvertingDirtyResourceToJSON() {
		String expectedJSON = "{\"foo\":\"bar\"}";
		resource.setAttribute("foo", "bar");
		assertTrue(resource.isDirty());
		assertEquals(expectedJSON, resource.toString());
	}

}
