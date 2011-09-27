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
import com.shopify.api.resources.Image;

@EndPoint("")
@ContextPath("/admin/products/")
@ResponseHandler(ShopifyResponseHandler.class)
public interface ProductImagesService extends BaseShopifyService {

    // GET
    @Path("{0}/images.json")
    List<Image> getProductImages(int productId);

    @Path("{0}/images.json?{1}")
    List<Image> getProductImages(int productId, String queryParams);

    @Path("{0}/images/{1}.json")
    Image getProductImage(int productId, int productImageId);

    @Path("{0}/images/{1}.json{2}")
    Image getProductImage(int productId, int productImageId, String queryParams);

    /**
     * @deprecated Operation not supported by Shopify API
     */
    @Path("{0}/images/count.json")
    int getCount(int productId);

    /**
     * @deprecated Operation not supported by Shopify API
     */
    @Path("{0}/images/count.json?{1}")
    int getCount(int productId, String queryParams);

    // POST
    @Path("{0}/images.json")
    @HttpMethod(POST)
    Image createProductImage(int productId, @Destination(BODY) @Name("image") Image productimage);

    // PUT
    @Path("{0}/images/{1}.json")
    @HttpMethod(PUT)
    Image updateProductImage(int productId, int productImageId, @Destination(BODY) @Name("image") Image productimage);

    // DELETE
    @Path("{0}/images/{1}.json")
    @HttpMethod(DELETE)
    void deleteProductImage(int productId, int productImageId);
}
