package com.shopify.api.resources;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;

import android.test.InstrumentationTestCase;

import com.shopify.assets.AssetLoader;

public class OrderTest extends InstrumentationTestCase {
	private ObjectMapper mapper;

	public void setUp() throws Exception {
		super.setUp();
		AssetLoader.instrumentation = getInstrumentation();
		mapper = new ObjectMapper();
	}

	public void testLoadingSingleAsset() throws Exception {
		String articleJson = AssetLoader.loadAsset("fixtures/Order/singleOrder.json");

		JsonNode node = mapper.readValue(articleJson, JsonNode.class);
		Order result = mapper.readValue(node.iterator().next(), Order.class);
		{
			assertEquals(1, result.getNumber());
			assertEquals("#1001", result.getName());

			assertEquals("11.94", result.getTaxLines().get(0).getPrice());
			assertEquals("State Tax", result.getTaxLines().get(0).getTitle());
			assertTrue(Math.abs(0.06 - result.getTaxLines().get(0).getRate()) < 0.0000001);

			assertNull(result.getBrowserIp());
			assertEquals("0.00", result.getTotalDiscounts());
			assertEquals("2008-01-10T11:00:00-05:00", result.getCreatedAt());

			assertEquals("IPod Nano - 8gb - green", result.getLineItems().get(0).getName());
			assertEquals("199.00", result.getLineItems().get(0).getPrice());
			assertEquals(632910392, result.getLineItems().get(0).getProductId());
			assertEquals(1, result.getLineItems().get(0).getQuantity());
			assertEquals(true, result.getLineItems().get(0).getRequiresShipping());
			assertEquals("IPod Nano - 8gb", result.getLineItems().get(0).getTitle());
			assertEquals(466157049, result.getLineItems().get(0).getId());
			assertEquals(200, result.getLineItems().get(0).getGrams());
			assertEquals("IPOD2008GREEN", result.getLineItems().get(0).getSku());
			assertNull(result.getLineItems().get(0).getFulfillmentStatus());
			assertEquals("green", result.getLineItems().get(0).getVariantTitle());
			assertNull(result.getLineItems().get(0).getVendor());
			assertEquals("manual", result.getLineItems().get(0).getFulfillmentService());
			assertEquals(39072856, result.getLineItems().get(0).getVariantId());

			assertEquals("IPod Nano - 8gb - black", result.getLineItems().get(1).getName());
			assertEquals("199.00", result.getLineItems().get(1).getPrice());
			assertEquals(632910392, result.getLineItems().get(1).getProductId());
			assertEquals(1, result.getLineItems().get(1).getQuantity());
			assertEquals(true, result.getLineItems().get(1).getRequiresShipping());
			assertEquals("IPod Nano - 8gb", result.getLineItems().get(1).getTitle());
			assertEquals(703073504, result.getLineItems().get(1).getId());
			assertEquals(200, result.getLineItems().get(1).getGrams());
			assertEquals("IPOD2008BLACK", result.getLineItems().get(1).getSku());
			assertNull(result.getLineItems().get(1).getFulfillmentStatus());
			assertEquals("black", result.getLineItems().get(1).getVariantTitle());
			assertNull(result.getLineItems().get(1).getVendor());
			assertEquals("manual", result.getLineItems().get(1).getFulfillmentService());
			assertEquals(457924702, result.getLineItems().get(1).getVariantId());

			assertNull(result.getCancelReason());
			assertEquals("XXXX-XXXX-XXXX-4242", result.getPaymentDetails().getCreditCardNumber());
			assertEquals("Visa", result.getPaymentDetails().getCreditCardCompany());
			assertEquals("2008-01-10T11:00:00-05:00", result.getUpdatedAt());
			assertEquals("210.94", result.getTotalPrice());
			assertEquals("b1946ac92492d2347c6235b4d2611184", result.getToken());
			assertEquals("abc", result.getLandingSiteRef());
			assertEquals(false, result.getTaxesIncluded());
			assertEquals("http://www.example.com?source=abc", result.getLandingSite());

			assertEquals("Bob Norman", result.getShippingAddress().getName());
			assertEquals("Chestnut Street 92", result.getShippingAddress().getAddress1());
			assertEquals("Louisville", result.getShippingAddress().getCity());
			assertNull(result.getShippingAddress().getCompany());
			assertEquals("", result.getShippingAddress().getAddress2());
			assertEquals("45.41634", result.getShippingAddress().getLatitude());

			assertEquals("40202", result.getShippingAddress().getZip());
			assertEquals("US", result.getShippingAddress().getCountryCode());
			assertEquals("United States", result.getShippingAddress().getCountry());
			assertEquals("KY", result.getShippingAddress().getProvinceCode());
			assertEquals("Norman", result.getShippingAddress().getLastName());
			assertEquals("555-625-1199", result.getShippingAddress().getPhone());
			assertEquals("-75.6868", result.getShippingAddress().getLongitude());
			assertEquals("Kentucky", result.getShippingAddress().getProvince());
			assertEquals("Bob", result.getShippingAddress().getFirstName());

			assertEquals(450789469, result.getId());
			assertNull(result.getCancelledAt());

			assertEquals("0.00", result.getShippingLines().get(0).getPrice());
			assertEquals("Free Shipping", result.getShippingLines().get(0).getCode());
			assertEquals("Free Shipping", result.getShippingLines().get(0).getTitle());

			assertEquals(1001, result.getOrderNumber());
			assertEquals("199.00", result.getTotalLineItemsPrice());
			assertEquals("http://www.otherexample.com", result.getReferringSite());
/*
 * TODO:
    "billing_address": {
      "name": "Bob Norman",
      "address1": "Chestnut Street 92",
      "city": "Louisville",
      "company": null,
      "address2": "",
      "latitude": "45.41634",
      "zip": "40202",
      "country_code": "US",
      "country": "United States",
      "province_code": "KY",
      "last_name": "Norman",
      "phone": "555-625-1199",
      "longitude": "-75.6868",
      "province": "Kentucky",
      "first_name": "Bob"
    },
    "subtotal_price": "199.00",
    "note": null,
    "customer": {
      "accepts_marketing": false,
      "orders_count": 0,
      "id": 207119551,
      "tags": "",
      "last_name": "Norman",
      "note": null,
      "email": "bob.norman@hostmail.com",
      "first_name": "Bob",
      "total_spent": "0.00"
    },
    "gateway": "authorize_net",
    "fulfillment_status": null,
    "financial_status": "authorized",
    "currency": "USD",
    "closed_at": null,
    "buyer_accepts_marketing": false,
    "note_attributes": [
      {
        "name": "colour",
        "value": "green"
      },
      {
        "name": "custom engraving",
        "value": "Happy Birthday"
      }
    ],
    "total_tax": "11.94",
    "total_weight": 0,
    "email": "bob.norman@hostmail.com"
  }
}
 */
		}
	}
}
