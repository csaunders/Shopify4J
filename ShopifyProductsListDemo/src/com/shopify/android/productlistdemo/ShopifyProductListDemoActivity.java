package com.shopify.android.productlistdemo;

import java.util.List;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.shopify.api.client.ShopifyClient;
import com.shopify.api.credentials.Credential;
import com.shopify.api.credentials.JsonDirectoryCredentialsStore;
import com.shopify.api.endpoints.ProductsService;
import com.shopify.api.resources.Product;

public class ShopifyProductListDemoActivity extends Activity {
    /** Called when the activity is first created. */
	ProductsCallerTask processor;
	TextView text;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        text = (TextView) findViewById(R.id.showProductsCountView);
        Bundle bundle = getIntent().getExtras();
        String shopname = bundle.getString("shop");
        setupShopifyClient(shopname);

        if(processor == null) {
		Toast.makeText(this, "Something went wrong!!", Toast.LENGTH_SHORT);
        } else {
		processor.execute(new Void[] {null});
        }
    }

    public void setupShopifyClient(String shopname) {
	try {
		JsonDirectoryCredentialsStore store = new JsonDirectoryCredentialsStore(getFilesDir());
		Credential creds = store.loadCredential(shopname);
		processor = new ProductsCallerTask(creds);
	} catch (Exception e) {
		e.printStackTrace();
	}
    }

    class ProductsCallerTask extends AsyncTask<Void, Integer, Product[]>{
	private ShopifyClient client;

	public ProductsCallerTask(Credential creds) {
		client = new ShopifyClient(creds);
	}

		@Override
		protected Product[] doInBackground(Void... params) {
			Log.e("********************** service", "Initializing products service");
			ProductsService service = client.constructService(ProductsService.class);
			Log.e("********************** before call", "Making the call to the Shopify API");
			Product[] products = service.getProducts();
			Log.e("********************** after call", "API response has been received and data has been parsed");
			return products;
		}

		protected void onPostExecute(Product[] result) {
			text.setText(String.format("You have %d products in your store", result.length));
		}
    }
}