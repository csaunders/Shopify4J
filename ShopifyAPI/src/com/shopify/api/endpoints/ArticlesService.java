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
import com.shopify.api.resources.Article;

@EndPoint("")
@ContextPath("/admin/blogs/")
@ResponseHandler(ShopifyResponseHandler.class)
public interface ArticlesService extends BaseShopifyService {

    // GET
    @Path("{0}/articles.json")
    List<Article> getArticles(int blogId);

    @Path("{0}/articles.json?{1}")
    List<Article> getArticles(int blogId, String queryParams);

    @Path("{0}/articles/{1}.json")
    Article getArticle(int blogId, int articleId);

    @Path("{0}/articles/{1}.json?{2}")
    Article getArticle(int blogId, int articleId, String queryParams);

    @Path("{0}/articles/count.json")
    int getCount(int blogId);

    @Path("{0}/articles/count.json?{1}")
    int getCount(int blogId, String queryParams);

    // POST
    @Path("{0}/articles.json")
    @HttpMethod(POST)
    Article createArticle(int blogId, @Destination(BODY) @Name("article") Article article);

    // PUT
    @Path("{0}/articles/{1}.json")
    @HttpMethod(PUT)
    Article updateArticle(int blogId, int articleId, @Destination(BODY) @Name("article") Article article);

    // DELETE
    @Path("{0}/articles/{1}.json")
    @HttpMethod(DELETE)
    void deleteArticle(int blogId, int id);
}
