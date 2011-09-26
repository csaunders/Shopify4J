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
import com.shopify.api.resources.Blog;

@EndPoint("")
@ContextPath("/admin/blogs")
@ResponseHandler(ShopifyResponseHandler.class)
public interface BlogsService extends BaseShopifyService {

    // GET
    @Path(".json")
    List<Blog> getBlogs();

    @Path(".json?{0}")
    List<Blog> getBlogs(String queryParams);

    @Path("/{0}.json")
    Blog getBlog(int id);

    @Path("/{0}.json?{1}")
    Blog getBlog(int id, String queryParams);

    @Path("/count.json")
    int getCount();

    @Path("/count.json?{0}")
    int getCount(String queryParams);

    // POST
    @Path(".json")
    @HttpMethod(POST)
    Blog createBlog(@Destination(BODY) @Name("blog") Blog blog);

    // PUT
    @Path("/{0}.json")
    @HttpMethod(PUT)
    Blog updateBlog(int id, @Destination(BODY) @Name("blog") Blog blog);

    // DELETE
    @Path("/{0}.json")
    @HttpMethod(DELETE)
    void deleteBlog(int id);
}
