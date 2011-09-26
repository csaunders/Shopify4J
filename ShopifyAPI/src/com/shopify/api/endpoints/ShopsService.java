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
import com.shopify.api.resources.Shop;

@EndPoint("")
@ContextPath("/admin/shops")
@ResponseHandler(ShopifyResponseHandler.class)
public interface ShopsService extends BaseShopifyService {

    // GET
    @Path(".json")
    List<Shop> getShops();

    @Path(".json?{0}")
    List<Shop> getShops(String queryParams);

    @Path("/{0}.json")
    Shop getShop(int id);

    @Path("/{0}.json?{1}")
    Shop getShop(int id, String queryParams);

    @Path("/count.json")
    int getCount();

    @Path("/count.json?{0}")
    int getCount(String queryParams);

    // POST
    @Path(".json")
    @HttpMethod(POST)
    Shop createShop(@Destination(BODY) @Name("shop") Shop shop);

    // PUT
    @Path("/{0}.json")
    @HttpMethod(PUT)
    Shop updateShop(int id, @Destination(BODY) @Name("shop") Shop shop);

    // DELETE
    @Path("/{0}.json")
    @HttpMethod(DELETE)
    void deleteShop(int id);
}
