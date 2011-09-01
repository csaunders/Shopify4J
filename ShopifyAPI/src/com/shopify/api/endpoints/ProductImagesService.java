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

import com.shopify.api.resources.ProductImage;

@EndPoint("")
@ContextPath("/admin/productImages")
@ResponseHandler(ShopifyResponseHandler.class)
public interface ProductImagesService extends BaseShopifyService {

    // GET
    @Path(".json")
    List<ProductImage> getProductImages();

    @Path(".json?{0}")
    List<ProductImage> getProductImages(String queryParams);

    @Path("/{0}.json")
    ProductImage getProductImage(int id);

    @Path("/{0}.json?{1}")
    ProductImage getProductImage(int id, String queryParams);

    @Path("/count.json")
    int getCount();

    @Path("/count.json?{0}")
    int getCount(String queryParams);

    // POST
    @Path(".json")
    @HttpMethod(POST)
    ProductImage createProductImage(@Destination(BODY) @Name("product_image") ProductImage productimage);

    // PUT
    @Path("/{0}.json")
    @HttpMethod(PUT)
    ProductImage updateProductImage(int id, @Destination(BODY) @Name("product_image") ProductImage productimage);

    // DELETE
    @Path("/{0}.json")
    @HttpMethod(DELETE)
    void deleteProductImage(int id);
}
