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

import com.shopify.api.resources.ProductVariant;

@EndPoint("")
@ContextPath("/admin/productVariants")
@ResponseHandler(ShopifyResponseHandler.class)
public interface ProductVariantsService extends BaseShopifyService {

    // GET
    @Path(".json")
    List<ProductVariant> getProductVariants();

    @Path(".json?{0}")
    List<ProductVariant> getProductVariants(String queryParams);

    @Path("/{0}.json")
    ProductVariant getProductVariant(int id);

    @Path("/{0}.json?{1}")
    ProductVariant getProductVariant(int id, String queryParams);

    @Path("/count.json")
    int getCount();

    @Path("/count.json?{0}")
    int getCount(String queryParams);

    // POST
    @Path(".json")
    @HttpMethod(POST)
    ProductVariant createProductVariant(@Destination(BODY) @Name("product_variant") ProductVariant productvariant);

    // PUT
    @Path("/{0}.json")
    @HttpMethod(PUT)
    ProductVariant updateProductVariant(int id, @Destination(BODY) @Name("product_variant") ProductVariant productvariant);

    // DELETE
    @Path("/{0}.json")
    @HttpMethod(DELETE)
    void deleteProductVariant(int id);
}
