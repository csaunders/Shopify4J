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

import com.shopify.api.resources.Province;

@EndPoint("")
@ContextPath("/admin/provinces")
@ResponseHandler(ShopifyResponseHandler.class)
public interface ProvincesService extends BaseShopifyService {

    // GET
    @Path(".json")
    List<Province> getProvinces();

    @Path(".json?{0}")
    List<Province> getProvinces(String queryParams);

    @Path("/{0}.json")
    Province getProvince(int id);

    @Path("/{0}.json?{1}")
    Province getProvince(int id, String queryParams);

    @Path("/count.json")
    int getCount();

    @Path("/count.json?{0}")
    int getCount(String queryParams);

    // POST
    @Path(".json")
    @HttpMethod(POST)
    Province createProvince(@Destination(BODY) @Name("province") Province province);

    // PUT
    @Path("/{0}.json")
    @HttpMethod(PUT)
    Province updateProvince(int id, @Destination(BODY) @Name("province") Province province);

    // DELETE
    @Path("/{0}.json")
    @HttpMethod(DELETE)
    void deleteProvince(int id);
}
