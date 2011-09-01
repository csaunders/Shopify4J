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

import com.shopify.api.resources.Event;

@EndPoint("")
@ContextPath("/admin/events")
@ResponseHandler(ShopifyResponseHandler.class)
public interface EventsService extends BaseShopifyService {

    // GET
    @Path(".json")
    List<Event> getEvents();

    @Path(".json?{0}")
    List<Event> getEvents(String queryParams);

    @Path("/{0}.json")
    Event getEvent(int id);

    @Path("/{0}.json?{1}")
    Event getEvent(int id, String queryParams);

    @Path("/count.json")
    int getCount();

    @Path("/count.json?{0}")
    int getCount(String queryParams);

    // POST
    @Path(".json")
    @HttpMethod(POST)
    Event createEvent(@Destination(BODY) @Name("event") Event event);

    // PUT
    @Path("/{0}.json")
    @HttpMethod(PUT)
    Event updateEvent(int id, @Destination(BODY) @Name("event") Event event);

    // DELETE
    @Path("/{0}.json")
    @HttpMethod(DELETE)
    void deleteEvent(int id);
}
