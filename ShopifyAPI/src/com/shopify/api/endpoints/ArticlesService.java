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

import com.shopify.api.resources.Article;

@EndPoint("")
@ContextPath("/admin/articles")
@ResponseHandler(ShopifyResponseHandler.class)
public interface ArticlesService extends BaseShopifyService {

    // GET
    @Path(".json")
    List<Article> getArticles();

    @Path(".json?{0}")
    List<Article> getArticles(String queryParams);

    @Path("/{0}.json")
    Article getArticle(int id);

    @Path("/{0}.json?{1}")
    Article getArticle(int id, String queryParams);

    @Path("/count.json")
    int getCount();

    @Path("/count.json?{0}")
    int getCount(String queryParams);

    // POST
    @Path(".json")
    @HttpMethod(POST)
    Article createArticle(@Destination(BODY) @Name("article") Article article);

    // PUT
    @Path("/{0}.json")
    @HttpMethod(PUT)
    Article updateArticle(int id, @Destination(BODY) @Name("article") Article article);

    // DELETE
    @Path("/{0}.json")
    @HttpMethod(DELETE)
    void deleteArticle(int id);
}
