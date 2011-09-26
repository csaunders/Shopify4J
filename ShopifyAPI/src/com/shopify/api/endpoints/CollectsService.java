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
import com.shopify.api.resources.Collect;

@EndPoint("")
@ContextPath("/admin/collects")
@ResponseHandler(ShopifyResponseHandler.class)
public interface CollectsService extends BaseShopifyService {

    // GET
    @Path(".json")
    List<Collect> getCollects();

    @Path(".json?{0}")
    List<Collect> getCollects(String queryParams);

    @Path("/{0}.json")
    Collect getCollect(int id);

    @Path("/{0}.json?{1}")
    Collect getCollect(int id, String queryParams);

    @Path("/count.json")
    int getCount();

    @Path("/count.json?{0}")
    int getCount(String queryParams);

    // POST
    @Path(".json")
    @HttpMethod(POST)
    Collect createCollect(@Destination(BODY) @Name("collect") Collect collect);

    // PUT
    @Path("/{0}.json")
    @HttpMethod(PUT)
    Collect updateCollect(int id, @Destination(BODY) @Name("collect") Collect collect);

    // DELETE
    @Path("/{0}.json")
    @HttpMethod(DELETE)
    void deleteCollect(int id);
}
