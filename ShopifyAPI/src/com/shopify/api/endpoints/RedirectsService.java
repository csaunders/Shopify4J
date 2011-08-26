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

import com.shopify.api.resources.Redirect;

@EndPoint("")
@ContextPath("/admin/Redirects")
//@ResponseHandler(ShopifyResponseHandler.class)
//@Param(name = "Content-type", value = "application/json", dest = HEADER)
public interface RedirectsService extends BaseShopifyService {

    // GET
    @Path(".json")
    Redirect[] getRedirects();

    @Path(".json?{0}")
    Redirect[] getRedirects(String queryParams);

    @Path("/{0}.json")
    Redirect getRedirect(int id);

    @Path("/{0}.json?{1}")
    Redirect getRedirect(int id, String queryParams);

    @Path("/count.json")
    int getCount();

    @Path("/count.json?{0}")
    int getCount(String queryParams);

    // POST
    @Path(".json")
    @HttpMethod(POST)
    @Destination(BODY)
    Redirect createRedirect(Redirect redirect);

    // PUT
    @Path("/{0}.json")
    @HttpMethod(PUT)
    @Destination(BODY)
    Redirect updateRedirect(int id, Redirect redirect);

    // DELETE
    @Path("/{0}.json")
    @HttpMethod(DELETE)
    void deleteRedirect(int id);
}
