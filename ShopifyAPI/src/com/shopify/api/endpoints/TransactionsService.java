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

import com.shopify.api.resources.Transactions;

@EndPoint("")
@ContextPath("/admin/transactions")
@ResponseHandler(ShopifyResponseHandler.class)
public interface TransactionsService extends BaseShopifyService {

    // GET
    @Path(".json")
    List<Transactions> getTransactions();

    @Path(".json?{0}")
    List<Transactions> getTransactions(String queryParams);

    @Path("/{0}.json")
    Transactions getTransactions(int id);

    @Path("/{0}.json?{1}")
    Transactions getTransactions(int id, String queryParams);

    @Path("/count.json")
    int getCount();

    @Path("/count.json?{0}")
    int getCount(String queryParams);

    // POST
    @Path(".json")
    @HttpMethod(POST)
    Transactions createTransactions(@Destination(BODY) @Name("transactions") Transactions transactions);

    // PUT
    @Path("/{0}.json")
    @HttpMethod(PUT)
    Transactions updateTransactions(int id, @Destination(BODY) @Name("transactions") Transactions transactions);

    // DELETE
    @Path("/{0}.json")
    @HttpMethod(DELETE)
    void deleteTransactions(int id);
}
