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
@ContextPath("/admin/products/")
@ResponseHandler(ShopifyResponseHandler.class)
public interface ProductVariantsService extends BaseShopifyService {

    // GET
    @Path("{0}/variants.json")
    List<ProductVariant> getProductVariants(int productId);

    @Path("{0}/variants.json?{1}")
    List<ProductVariant> getProductVariants(int productId, String queryParams);

    @Path("{0}/variants/{1}.json")
    ProductVariant getProductVariant(int productId, int variantId);

    @Path("{0}/variants/{1}.json?{2}")
    ProductVariant getProductVariant(int productId, int variantId, String queryParams);

    @Path("{0}/variants/count.json")
    int getCount(int productId);

    @Path("{0}/count.json?{1}")
    int getCount(int productId, String queryParams);

    // POST
    @Path("{0}/variants.json")
    @HttpMethod(POST)
    ProductVariant createProductVariant(int productId, @Destination(BODY) @Name("product_variant") ProductVariant productvariant);

    // PUT
    @Path("{0}/variants/{1}.json")
    @HttpMethod(PUT)
    ProductVariant updateProductVariant(int productId, int variantIdd, @Destination(BODY) @Name("product_variant") ProductVariant productvariant);

    // DELETE
    @Path("{0}/variants/{1}.json")
    @HttpMethod(DELETE)
    void deleteProductVariant(int productId, int variantId);
}
