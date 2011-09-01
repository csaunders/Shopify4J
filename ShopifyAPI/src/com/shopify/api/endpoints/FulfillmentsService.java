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

import com.shopify.api.resources.Fulfillment;

@EndPoint("")
@ContextPath("/admin/fulfillments")
@ResponseHandler(ShopifyResponseHandler.class)
public interface FulfillmentsService extends BaseShopifyService {

    // GET
    @Path(".json")
    List<Fulfillment> getFulfillments();

    @Path(".json?{0}")
    List<Fulfillment> getFulfillments(String queryParams);

    @Path("/{0}.json")
    Fulfillment getFulfillment(int id);

    @Path("/{0}.json?{1}")
    Fulfillment getFulfillment(int id, String queryParams);

    @Path("/count.json")
    int getCount();

    @Path("/count.json?{0}")
    int getCount(String queryParams);

    // POST
    @Path(".json")
    @HttpMethod(POST)
    Fulfillment createFulfillment(@Destination(BODY) @Name("fulfillment") Fulfillment fulfillment);

    // PUT
    @Path("/{0}.json")
    @HttpMethod(PUT)
    Fulfillment updateFulfillment(int id, @Destination(BODY) @Name("fulfillment") Fulfillment fulfillment);

    // DELETE
    @Path("/{0}.json")
    @HttpMethod(DELETE)
    void deleteFulfillment(int id);
}
