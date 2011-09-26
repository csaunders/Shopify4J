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
import com.shopify.api.resources.Webhook;

@EndPoint("")
@ContextPath("/admin/webhooks")
@ResponseHandler(ShopifyResponseHandler.class)
public interface WebhooksService extends BaseShopifyService {

    // GET
    @Path(".json")
    List<Webhook> getWebhooks();

    @Path(".json?{0}")
    List<Webhook> getWebhooks(String queryParams);

    @Path("/{0}.json")
    Webhook getWebhook(int id);

    @Path("/{0}.json?{1}")
    Webhook getWebhook(int id, String queryParams);

    @Path("/count.json")
    int getCount();

    @Path("/count.json?{0}")
    int getCount(String queryParams);

    // POST
    @Path(".json")
    @HttpMethod(POST)
    Webhook createWebhook(@Destination(BODY) @Name("webhook") Webhook webhook);

    // PUT
    @Path("/{0}.json")
    @HttpMethod(PUT)
    Webhook updateWebhook(int id, @Destination(BODY) @Name("webhook") Webhook webhook);

    // DELETE
    @Path("/{0}.json")
    @HttpMethod(DELETE)
    void deleteWebhook(int id);
}
