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
import com.shopify.api.resources.Theme;

@EndPoint("")
@ContextPath("/admin/themes")
@ResponseHandler(ShopifyResponseHandler.class)
public interface ThemesService extends BaseShopifyService {

    // GET
    @Path(".json")
    List<Theme> getThemes();

    @Path(".json?{0}")
    List<Theme> getThemes(String queryParams);

    @Path("/{0}.json")
    Theme getTheme(int id);

    @Path("/{0}.json?{1}")
    Theme getTheme(int id, String queryParams);

    @Path("/count.json")
    int getCount();

    @Path("/count.json?{0}")
    int getCount(String queryParams);

    // POST
    @Path(".json")
    @HttpMethod(POST)
    Theme createTheme(@Destination(BODY) @Name("theme") Theme theme);

    // PUT
    @Path("/{0}.json")
    @HttpMethod(PUT)
    Theme updateTheme(int id, @Destination(BODY) @Name("theme") Theme theme);

    // DELETE
    @Path("/{0}.json")
    @HttpMethod(DELETE)
    void deleteTheme(int id);
}
