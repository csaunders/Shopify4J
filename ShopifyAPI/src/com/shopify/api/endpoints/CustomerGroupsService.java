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
import com.shopify.api.resources.CustomerGroup;

@EndPoint("")
@ContextPath("/admin/customerGroups")
@ResponseHandler(ShopifyResponseHandler.class)
public interface CustomerGroupsService extends BaseShopifyService {

    // GET
    @Path(".json")
    List<CustomerGroup> getCustomerGroups();

    @Path(".json?{0}")
    List<CustomerGroup> getCustomerGroups(String queryParams);

    @Path("/{0}.json")
    CustomerGroup getCustomerGroup(int id);

    @Path("/{0}.json?{1}")
    CustomerGroup getCustomerGroup(int id, String queryParams);

    @Path("/count.json")
    int getCount();

    @Path("/count.json?{0}")
    int getCount(String queryParams);

    // POST
    @Path(".json")
    @HttpMethod(POST)
    CustomerGroup createCustomerGroup(@Destination(BODY) @Name("customer_group") CustomerGroup customergroup);

    // PUT
    @Path("/{0}.json")
    @HttpMethod(PUT)
    CustomerGroup updateCustomerGroup(int id, @Destination(BODY) @Name("customer_group") CustomerGroup customergroup);

    // DELETE
    @Path("/{0}.json")
    @HttpMethod(DELETE)
    void deleteCustomerGroup(int id);
}
