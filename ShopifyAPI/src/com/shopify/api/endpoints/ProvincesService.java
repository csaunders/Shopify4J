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
import com.shopify.api.resources.Province;

@EndPoint("")
@ContextPath("/admin/countries/")
@ResponseHandler(ShopifyResponseHandler.class)
public interface ProvincesService extends BaseShopifyService {

    // GET
    @Path("{0}/provinces.json")
    List<Province> getProvinces(int countryId);

    @Path("{0}/provinces.json?{1}")
    List<Province> getProvinces(int countryId, String queryParams);

    @Path("{0}/provinces/{1}.json")
    Province getProvince(int countryId, int provinceId);

    @Path("{0}/provinces/{1}.json?{2}")
    Province getProvince(int countryId, int provinceId, String queryParams);

    @Path("{0}/provinces/count.json")
    int getCount(int countryId);

    @Path("{0}/count.json?{1}")
    int getCount(int countryId, String queryParams);

    // POST
    /**
     * @deprecated
     * Currently not supported by the Shopify API
     */
    @Path(".json")
    @HttpMethod(POST)
    Province createProvince(@Destination(BODY) @Name("province") Province province);

    // PUT
    @Path("{0}/provinces/{1}.json")
    @HttpMethod(PUT)
    Province updateProvince(int countryId, int provinceId, @Destination(BODY) @Name("province") Province province);

    // DELETE
    /**
     * @deprecated
     * Currently not supported by the Shopify API
     */
    @Path("/{0}.json")
    @HttpMethod(DELETE)
    void deleteProvince(int id);
}
