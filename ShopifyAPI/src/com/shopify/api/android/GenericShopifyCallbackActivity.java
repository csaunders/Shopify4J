package com.shopify.api.android;

import java.io.IOException;
import java.util.HashMap;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.shopify.api.APIAuthorization;
import com.shopify.api.credentials.JsonDirectoryCredentialsStore;

public abstract class GenericShopifyCallbackActivity extends Activity {
	protected static final String SHOP = "shop", TOKEN = "t", TIMESTAMP = "timestamp", SIGNATURE = "signature";
	JsonDirectoryCredentialsStore store;
	
	public void onResume() {
		super.onResume();
		HashMap<String, String> params = extractCallbackParams(this.getIntent().getData());
		String shop = extractShopName(params.get(SHOP));
		try {
			setupCredentialsStore();
			APIAuthorization auth = new APIAuthorization(store, shop);
			auth.computeAPIPassword(params);
			
			Intent i = new Intent(this, getOnSuccessActivity());
			Bundle extras = new Bundle();
			extras.putString("shop", shop);
			i.putExtras(extras);
			
			startActivity(i);
			finish();
		} catch (IOException e) {
			
		} catch (Exception e) {
			
		}
		
	}
	
	private HashMap<String, String> extractCallbackParams(final Uri callbackResponse){
		return new HashMap<String, String>(){{
			put(SHOP, callbackResponse.getQueryParameter(SHOP));
			put(TOKEN, callbackResponse.getQueryParameter(TOKEN));
			put(TIMESTAMP, callbackResponse.getQueryParameter(TIMESTAMP));
			put(SIGNATURE, callbackResponse.getQueryParameter(SIGNATURE));
		}};
	}
	
	protected String extractShopName(String shopEndpoint) {
		return shopEndpoint.substring(0, shopEndpoint.indexOf('.'));
	}
	
	protected void setupCredentialsStore() throws IOException{
		if (store == null)
			store = new JsonDirectoryCredentialsStore(getFilesDir());
	}
	
	/**
	 * 
	 * @return the Activity class to launch after successful
	 * authentication with the API.
	 */
	public abstract Class<?> getOnSuccessActivity();
}
