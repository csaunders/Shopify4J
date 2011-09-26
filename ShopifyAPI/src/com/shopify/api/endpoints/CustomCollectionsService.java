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
import com.shopify.api.resources.CustomCollection;

@EndPoint("")
@ContextPath("/admin/customCollections")
@ResponseHandler(ShopifyResponseHandler.class)
public interface CustomCollectionsService extends BaseShopifyService {

    // GET
    @Path(".json")
    List<CustomCollection> getCustomCollections();

    @Path(".json?{0}")
    List<CustomCollection> getCustomCollections(String queryParams);

    @Path("/{0}.json")
    CustomCollection getCustomCollection(int id);

    @Path("/{0}.json?{1}")
    CustomCollection getCustomCollection(int id, String queryParams);

    @Path("/count.json")
    int getCount();

    @Path("/count.json?{0}")
    int getCount(String queryParams);

    // POST
    @Path(".json")
    @HttpMethod(POST)
    CustomCollection createCustomCollection(@Destination(BODY) @Name("custom_collection") CustomCollection customcollection);

    // PUT
    @Path("/{0}.json")
    @HttpMethod(PUT)
    CustomCollection updateCustomCollection(int id, @Destination(BODY) @Name("custom_collection") CustomCollection customcollection);

    // DELETE
    @Path("/{0}.json")
    @HttpMethod(DELETE)
    void deleteCustomCollection(int id);
}
