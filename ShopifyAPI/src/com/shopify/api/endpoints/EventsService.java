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
import com.shopify.api.resources.Event;

@EndPoint("")
@ContextPath("/admin/orders/")
@ResponseHandler(ShopifyResponseHandler.class)
public interface EventsService extends BaseShopifyService {

    // GET
    @Path("{0}/events.json")
    List<Event> getEvents(int orderId);

    @Path("{0}/events.json?{1}")
    List<Event> getEvents(int orderId, String queryParams);

    @Path("{0}/events/{1}.json")
    Event getEvent(int orderId, int eventId);

    @Path("{0}/events/{1}.json?{2}")
    Event getEvent(int orderId, int eventId, String queryParams);

    @Path("{0}/events/count.json")
    int getCount(int orderId);

    @Path("{0}/events/count.json?{1}")
    int getCount(int orderId, String queryParams);

    // POST
    /**
     * @deprecated
     * Currently not supported by the Shopify API
     */
    @Path(".json")
    @HttpMethod(POST)
    Event createEvent(@Destination(BODY) @Name("event") Event event);

    // PUT
    /**
     * @deprecated
     * Currently not supported by the Shopify API
     */
    @Path("/{0}.json")
    @HttpMethod(PUT)
    Event updateEvent(int id, @Destination(BODY) @Name("event") Event event);

    // DELETE
    /**
     * @deprecated
     * Currently not supported by the Shopify API
     */
    @Path("/{0}.json")
    @HttpMethod(DELETE)
    void deleteEvent(int id);
}
