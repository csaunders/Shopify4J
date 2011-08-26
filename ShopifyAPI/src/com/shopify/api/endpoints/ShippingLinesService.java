/**
*
*
**/
// Generated On: 2011-08-26T15:12:08-04:00
package com.shopify.api.endpoints;

import org.codegist.crest.annotate.ContextPath;
import org.codegist.crest.annotate.Destination;
import org.codegist.crest.annotate.EndPoint;
import org.codegist.crest.annotate.HttpMethod;
import org.codegist.crest.annotate.Path;

import static org.codegist.crest.HttpMethod.POST;
import static org.codegist.crest.HttpMethod.PUT;
import static org.codegist.crest.HttpMethod.DELETE;
import static org.codegist.crest.config.Destination.BODY;
import static org.codegist.crest.config.Destination.HEADER;

import com.shopify.api.resources.ShippingLine;

@EndPoint("")
@ContextPath("/admin/ShippingLines")
//@ResponseHandler(ShopifyResponseHandler.class)
//@Param(name = "Content-type", value = "application/json", dest = HEADER)
public interface ShippingLinesService extends BaseShopifyService {

    // GET
    @Path(".json")
    ShippingLine[] getShippingLines();

    @Path(".json?{0}")
    ShippingLine[] getShippingLines(String queryParams);

    @Path("/{0}.json")
    ShippingLine getShippingLine(int id);

    @Path("/{0}.json?{1}")
    ShippingLine getShippingLine(int id, String queryParams);

    @Path("/count.json")
    int getCount();

    @Path("/count.json?{0}")
    int getCount(String queryParams);

    // POST
    @Path(".json")
    @HttpMethod(POST)
    @Destination(BODY)
    ShippingLine createShippingLine(ShippingLine shippingline);

    // PUT
    @Path("/{0}.json")
    @HttpMethod(PUT)
    @Destination(BODY)
    ShippingLine updateShippingLine(int id, ShippingLine shippingline);

    // DELETE
    @Path("/{0}.json")
    @HttpMethod(DELETE)
    void deleteShippingLine(int id);
}
