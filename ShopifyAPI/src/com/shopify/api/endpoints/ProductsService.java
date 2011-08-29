package com.shopify.api.endpoints;

import java.util.List;

import com.shopify.api.resources.Product;

import org.codegist.crest.annotate.ContextPath;
import org.codegist.crest.annotate.EndPoint;
import org.codegist.crest.annotate.Path;
import org.codegist.crest.annotate.Destination;
import org.codegist.crest.annotate.HttpMethod;
import org.codegist.crest.annotate.ResponseHandler;

import static org.codegist.crest.config.Destination.BODY;
import static org.codegist.crest.HttpMethod.POST;
import static org.codegist.crest.HttpMethod.PUT;
import static org.codegist.crest.HttpMethod.DELETE;

@EndPoint("")
@ContextPath("/admin")
@ResponseHandler(ShopifyResponseHandler.class)
public interface ProductsService extends BaseShopifyService {

	@Path("/products.json")
	List<Product> getProducts();

	@Path("/products.json?{0}")
	List<Product> getProducts(String queryParams);

	@Path("/products/count.json")
	int getProductCount();

	@Path("/products/count.json?{0}")
	int getProductCount(String queryParams);

	@Path("/products/{0}.json")
	Product getProduct(int id);

	@Path("/products/{0}.json?{1}")
	Product getProduct(int id, String fieldsParams);

	@HttpMethod(POST)
	@Path("/products.json")
	Product createProduct(@Destination(BODY) Product product);

	@HttpMethod(PUT)
	@Path("/products/{0}.json")
	Product updateProduct(int id, @Destination(BODY) Product product);

	@HttpMethod(DELETE)
	@Path("/products/{0}.json")
	void updateProduct(int id);
}
