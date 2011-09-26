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
import com.shopify.api.resources.ProductSearchEngine;

@EndPoint("")
@ContextPath("/admin/productSearchEngines")
@ResponseHandler(ShopifyResponseHandler.class)
public interface ProductSearchEnginesService extends BaseShopifyService {

    // GET
    @Path(".json")
    List<ProductSearchEngine> getProductSearchEngines();

    @Path(".json?{0}")
    List<ProductSearchEngine> getProductSearchEngines(String queryParams);

    @Path("/{0}.json")
    ProductSearchEngine getProductSearchEngine(int id);

    @Path("/{0}.json?{1}")
    ProductSearchEngine getProductSearchEngine(int id, String queryParams);

    @Path("/count.json")
    int getCount();

    @Path("/count.json?{0}")
    int getCount(String queryParams);

    // POST
    @Path(".json")
    @HttpMethod(POST)
    ProductSearchEngine createProductSearchEngine(@Destination(BODY) @Name("product_search_engine") ProductSearchEngine productsearchengine);

    // PUT
    @Path("/{0}.json")
    @HttpMethod(PUT)
    ProductSearchEngine updateProductSearchEngine(int id, @Destination(BODY) @Name("product_search_engine") ProductSearchEngine productsearchengine);

    // DELETE
    @Path("/{0}.json")
    @HttpMethod(DELETE)
    void deleteProductSearchEngine(int id);
}
