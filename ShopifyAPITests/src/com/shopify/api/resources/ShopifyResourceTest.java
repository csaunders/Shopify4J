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
	}

	public void tearDown() throws Exception {
		super.setUp();
	}

	public void testSettingNewAttributes() {
		resource.setAttribute("thing", "123");
		assertFalse(resource.isDirty());

		resource.setAttribute("thing", "123");
		assertFalse(resource.isDirty());

		resource.setAttribute("thing", "456");
		assertTrue(resource.isDirty());
	}


	public void testSettingValuesOnNewObjectDoesNotFlagAsDirty() {
		resource.setCreatedAt("2011-01-01T00:00:00-04:00");
		assertFalse(resource.isDirty());
		assertEquals("2011-01-01T00:00:00-04:00", resource.getCreatedAt());

		resource.setCreatedAt("2011-01-02T00:00:00-04:00");
		assertTrue(resource.isDirty());
		assertEquals("2011-01-02T00:00:00-04:00", resource.getCreatedAt());
	}

	public void testSettingValueToSameValueDoesNotTriggerFlaggingResourceAsDirty() {
		resource.setCreatedAt("2011-01-01T00:00:00-04:00");
		assertFalse(resource.isDirty());

		resource.setCreatedAt("2011-01-01T00:00:00-04:00");
		assertFalse(resource.isDirty());
	}

	public void testCannotSetValueToNull() {
		resource.setCreatedAt("2011-01-01T00:00:00-04:00");
		resource.setCreatedAt(null);
		assertFalse(resource.isDirty());
		assertEquals("2011-01-01T00:00:00-04:00", resource.getCreatedAt());
	}

}
