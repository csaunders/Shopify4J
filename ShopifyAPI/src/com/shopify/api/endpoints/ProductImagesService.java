/**
*
*
**/
// Generated On: 2011-09-01T02:13:38-04:00
package com.shopify.api.endpoints;

import static org.codegist.crest.HttpMethod.DELETE;
import static org.codegist.crest.HttpMethod.POST;
import static org.codegist.crest.HttpMethod.PUT;
import static org.codegist.crest.config.Destination.BODY;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.codegist.crest.annotate.ContextPath;
import org.codegist.crest.annotate.Destination;
import org.codegist.crest.annotate.EndPoint;
import org.codegist.crest.annotate.HttpMethod;
import org.codegist.crest.annotate.Name;
import org.codegist.crest.annotate.Path;
import org.codegist.crest.annotate.ResponseHandler;

import com.shopify.api.handlers.ShopifyResponseHandler;
import com.shopify.api.resources.Image;

public class ProductImagesService implements EndpointImpl {
	@EndPoint("")
	@ContextPath(CONTEXT_PATH)
	@ResponseHandler(ShopifyResponseHandler.class)
	public interface ServiceInterface extends BaseShopifyService {
	    // GET
	    @Path("{0}/images.json")
	    Image[] getProductImages(int productId);

	    @Path("{0}/images.json?{1}")
	    Image[] getProductImages(int productId, String queryParams);

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
	private static final String CONTEXT_PATH = "/admin/products/";
	
	private HttpClient client;
	private ServiceInterface service;
	private String endpoint;
	
    Image[] getProductImages(int productId){
    	return service.getProductImages(productId);
    }

    Image[] getProductImages(int productId, String queryParams){
    	return service.getProductImages(productId, queryParams);
    }

    Image getProductImage(int productId, int productImageId) {
    	return service.getProductImage(productId, productImageId);
    }

    Image getProductImage(int productId, int productImageId, String queryParams) {
    	return service.getProductImage(productId, productImageId, queryParams);
    }

    /**
     * @deprecated Operation not supported by Shopify API
     */
    int getCount(int productId) {
    	return service.getCount(productId);
    }

    /**
     * @deprecated Operation not supported by Shopify API
     */
    int getCount(int productId, String queryParams) {
    	return service.getCount(productId, queryParams);
    }

    // POST
    Image createProductImage(int productId, @Destination(BODY) @Name("image") Image productimage) {
    	return createProductImage(productId, productimage.getImage());
    }
	
    // PUT
    Image updateProductImage(int productId, int productImageId, @Destination(BODY) @Name("image") Image productimage) {
    	return service.updateProductImage(productId, productImageId, productimage);
    }

    // DELETE
    void deleteProductImage(int productId, int productImageId) {
    	service.deleteProductImage(productId, productImageId);
    }
    
    public Image createProductImage(int productId, @Destination(BODY) @Name("image") File productImage) {
    	HttpContext ctx = new BasicHttpContext();
    	String url = String.format("%s%s%d/images.json", endpoint, CONTEXT_PATH, productId);
    	HttpPost post = new HttpPost(url);
    	post.addHeader("Accept", "text/json");
    	
    	try {
    		MultipartEntity entity = new MultipartEntity(HttpMultipartMode.BROWSER_COMPATIBLE);
    		entity.addPart("image[attachment]", new FileBody(productImage));
    		
    		post.setEntity(entity);
    		HttpResponse response = client.execute(post, ctx);
    		
    		return new Image();
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    	
    	
    	return null;
    }
    
    public void setHttpClient(HttpClient client) {
    	this.client = client;
    }
    
    public void setEndpoint(String endpoint) {
    	this.endpoint = endpoint;
    }
    
	public void setServiceInterface(BaseShopifyService service) {
		this.service = (ServiceInterface) service;
	}
	
	public Class<ServiceInterface> getServiceClass(){
		return ServiceInterface.class;
	}
}
