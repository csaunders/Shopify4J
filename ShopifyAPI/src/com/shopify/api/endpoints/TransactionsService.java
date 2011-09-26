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

import com.shopify.api.handlers.ShopifyResponseHandler;
import com.shopify.api.resources.Transaction;

@EndPoint("")
@ContextPath("/admin/orders/")
@ResponseHandler(ShopifyResponseHandler.class)
public interface TransactionsService extends BaseShopifyService {

    // GET
    @Path("{0}/transactions.json")
    List<Transaction> getTransactions(int orderId);

    @Path("{0}/transactions.json?{1}")
    List<Transaction> getTransactions(int orderId, String queryParams);

    @Path("{0}/transactions/{1}.json")
    Transaction getTransaction(int orderId, int transactionId);

    @Path("{0}/transactions/{1}.json?{2}")
    Transaction getTransaction(int orderId, int transactionId, String queryParams);

    @Path("{0}/transactions/count.json")
    int getCount(int orderId);

    @Path("{0}/transactions/count.json?{1}")
    int getCount(int orderId, String queryParams);

    // POST
    @Path("{0}/transactions.json")
    @HttpMethod(POST)
    Transaction createTransaction(int orderId, @Destination(BODY) @Name("transaction") Transaction transaction);

    /*
     * According to Shopify API Documentation PUT and DELETE aren't supported
     * through the API for transactions.  Going to leave these here, but there
     * is no guarantee it will work
     */
    // PUT
    /**
     * @deprecated
     * This action is currently not supported by the Shopify API 
     */
    @Path("{0}/transactions/{1}.json")
    @HttpMethod(PUT)
    Transaction updateTransaction(int orderId, int transactionId, @Destination(BODY) @Name("transaction") Transaction transaction);

    // DELETE
    /**
     * @deprecated
     * This action is currently not supported by the Shopify API 
     */
    @Path("{0}/transactions/{1}.json")
    @HttpMethod(DELETE)
    void deleteTransaction(int orderId, int transactionId);
}
