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
import com.shopify.api.resources.Customer;

@EndPoint("")
@ContextPath("/admin/customers")
@ResponseHandler(ShopifyResponseHandler.class)
public interface CustomersService extends BaseShopifyService {

    // GET
    @Path(".json")
    List<Customer> getCustomers();

    @Path(".json?{0}")
    List<Customer> getCustomers(String queryParams);

    @Path("/{0}.json")
    Customer getCustomer(int id);

    @Path("/{0}.json?{1}")
    Customer getCustomer(int id, String queryParams);

    @Path("/count.json")
    int getCount();

    @Path("/count.json?{0}")
    int getCount(String queryParams);

    // POST
    @Path(".json")
    @HttpMethod(POST)
    Customer createCustomer(@Destination(BODY) @Name("customer") Customer customer);

    // PUT
    @Path("/{0}.json")
    @HttpMethod(PUT)
    Customer updateCustomer(int id, @Destination(BODY) @Name("customer") Customer customer);

    // DELETE
    @Path("/{0}.json")
    @HttpMethod(DELETE)
    void deleteCustomer(int id);
}
