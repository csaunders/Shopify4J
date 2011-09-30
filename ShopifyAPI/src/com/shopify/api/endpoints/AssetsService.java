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
import com.shopify.api.resources.Asset;

@EndPoint("")
@ContextPath("/admin/themes/")
@ResponseHandler(ShopifyResponseHandler.class)
public interface AssetsService extends BaseShopifyService {

    // GET
    @Path("{0}/assets.json")
    List<Asset> getAssets(int themeId);

    @Path("{{0}/assets.json?asset[key]={1}")
    Asset getAsset(int themeId, String assetKey);

    /**
     * @deprecated Not supported by the Shopify API
     */
    @Path("{0}/assets/count.json")
    int getCount(int themeId);

    /**
     * @deprecated Not supported by the Shopify API
     */
    @Path("{0}/assets/count.json?{1}")
    int getCount(int themeId, String queryParams);

    /**
     * @deprecated Not supported by the Shopify API
     */
    // POST
    @Path("{0}/assets.json")
    @HttpMethod(POST)
    Asset createAsset(int themeId, @Destination(BODY) @Name("asset") Asset asset);

    // PUT
    @Path("{0}/assets.json")
    @HttpMethod(PUT)
    Asset updateAsset(int themeId, @Destination(BODY) @Name("asset") Asset asset);

    // DELETE
    @Path("{0}/assets.json?asset[key]={1}")
    @HttpMethod(DELETE)
    void deleteAsset(int themeId, String assetKey);
}
