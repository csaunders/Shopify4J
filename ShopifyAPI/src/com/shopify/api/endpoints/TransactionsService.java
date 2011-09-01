/**
*
*
**/
// Generated On: 2011-09-01T17:54:50-04:00
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

import com.shopify.api.resources.Transaction;

@EndPoint("")
@ContextPath("/admin/transactions")
@ResponseHandler(ShopifyResponseHandler.class)
public interface TransactionsService extends BaseShopifyService {

    // GET
    @Path(".json")
    List<Transaction> getTransactions();

    @Path(".json?{0}")
    List<Transaction> getTransactions(String queryParams);

    @Path("/{0}.json")
    Transaction getTransaction(int id);

    @Path("/{0}.json?{1}")
    Transaction getTransaction(int id, String queryParams);

    @Path("/count.json")
    int getCount();

    @Path("/count.json?{0}")
    int getCount(String queryParams);

    // POST
    @Path(".json")
    @HttpMethod(POST)
    Transaction createTransaction(@Destination(BODY) @Name("transaction") Transaction transaction);

    // PUT
    @Path("/{0}.json")
    @HttpMethod(PUT)
    Transaction updateTransaction(int id, @Destination(BODY) @Name("transaction") Transaction transaction);

    // DELETE
    @Path("/{0}.json")
    @HttpMethod(DELETE)
    void deleteTransaction(int id);
}
