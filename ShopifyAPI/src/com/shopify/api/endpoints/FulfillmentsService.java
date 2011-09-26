/**
*
*
**/
// Generated On: 2011-09-01T02:13:38-04:00
package com.shopify.api.endpoints;

import java.util.List;

import org.codegist.crest.annotate.ContextPath;
import org.codegist.crest.annotate.Destination;
import org.codegist.crest.annotate.EndPoint;
import org.codegist.crest.annotate.HttpMethod;
import org.codegist.crest.annotate.Name;
import org.codegist.crest.annotate.ResponseHandler;
import org.codegist.crest.annotate.Path;

import static org.codegist.crest.HttpMethod.POST;
import static org.codegist.crest.HttpMethod.PUT;
import static org.codegist.crest.HttpMethod.DELETE;
import static org.codegist.crest.config.Destination.BODY;

import com.shopify.api.handlers.ShopifyResponseHandler;
import com.shopify.api.resources.Fulfillment;

@EndPoint("")
@ContextPath("/admin/orders/")
@ResponseHandler(ShopifyResponseHandler.class)
public interface FulfillmentsService extends BaseShopifyService {

    // GET
    @Path("{0}/fulfillments.json")
    List<Fulfillment> getFulfillments(int orderId);

    @Path("{0}/fulfillments.json?{1}")
    List<Fulfillment> getFulfillments(int orderId, String queryParams);

    @Path("{0}/fulfillments/{1}.json")
    Fulfillment getFulfillment(int orderId, int fulfillmentId);

    @Path("{0}/fulfillments/{1}.json?{2}")
    Fulfillment getFulfillment(int orderId, int fulfillmentId, String queryParams);

    @Path("{0}/fulfillments/count.json")
    int getCount(int orderId);

    @Path("{0}/fulfillments/count.json?{1}")
    int getCount(int orderId, String queryParams);

    // POST
    @Path("{0}/fulfillments.json")
    @HttpMethod(POST)
    Fulfillment createFulfillment(int orderId, @Destination(BODY) @Name("fulfillment") Fulfillment fulfillment);

    // PUT
    @Path("{0}/fulfillments/{1}.json")
    @HttpMethod(PUT)
    Fulfillment updateFulfillment(int orderId, int fulfillmentId, @Destination(BODY) @Name("fulfillment") Fulfillment fulfillment);

    // DELETE
    @Path("{0}/fulfillments/{1}.json")
    @HttpMethod(DELETE)
    void deleteFulfillment(int orderId, int fulfillmentId);
}
