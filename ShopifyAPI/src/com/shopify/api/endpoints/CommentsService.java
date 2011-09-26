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
import com.shopify.api.resources.Comment;

@EndPoint("")
@ContextPath("/admin/comments")
@ResponseHandler(ShopifyResponseHandler.class)
public interface CommentsService extends BaseShopifyService {

    // GET
    @Path(".json")
    List<Comment> getComments();

    @Path(".json?{0}")
    List<Comment> getComments(String queryParams);

    @Path("/{0}.json")
    Comment getComment(int id);

    @Path("/{0}.json?{1}")
    Comment getComment(int id, String queryParams);

    @Path("/count.json")
    int getCount();

    @Path("/count.json?{0}")
    int getCount(String queryParams);

    // POST
    @Path(".json")
    @HttpMethod(POST)
    Comment createComment(@Destination(BODY) @Name("comment") Comment comment);

    // PUT
    @Path("/{0}.json")
    @HttpMethod(PUT)
    Comment updateComment(int id, @Destination(BODY) @Name("comment") Comment comment);

    // DELETE
    @Path("/{0}.json")
    @HttpMethod(DELETE)
    void deleteComment(int id);
}
