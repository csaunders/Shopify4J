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
import com.shopify.api.resources.SmartCollection;

@EndPoint("")
@ContextPath("/admin/smartCollections")
@ResponseHandler(ShopifyResponseHandler.class)
public interface SmartCollectionsService extends BaseShopifyService {

    // GET
    @Path(".json")
    List<SmartCollection> getSmartCollections();

    @Path(".json?{0}")
    List<SmartCollection> getSmartCollections(String queryParams);

    @Path("/{0}.json")
    SmartCollection getSmartCollection(int id);

    @Path("/{0}.json?{1}")
    SmartCollection getSmartCollection(int id, String queryParams);

    @Path("/count.json")
    int getCount();

    @Path("/count.json?{0}")
    int getCount(String queryParams);

    // POST
    @Path(".json")
    @HttpMethod(POST)
    SmartCollection createSmartCollection(@Destination(BODY) @Name("smart_collection") SmartCollection smartcollection);

    // PUT
    @Path("/{0}.json")
    @HttpMethod(PUT)
    SmartCollection updateSmartCollection(int id, @Destination(BODY) @Name("smart_collection") SmartCollection smartcollection);

    // DELETE
    @Path("/{0}.json")
    @HttpMethod(DELETE)
    void deleteSmartCollection(int id);
}
