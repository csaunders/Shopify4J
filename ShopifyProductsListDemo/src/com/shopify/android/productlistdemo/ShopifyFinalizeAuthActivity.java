package com.shopify.android.productlistdemo;

import java.io.IOException;
import java.util.HashMap;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.shopify.api.APIAuthorization;
import com.shopify.api.credentials.JsonDirectoryCredentialsStore;

public class ShopifyFinalizeAuthActivity extends Activity{

	public void onResume() {
		super.onResume();
		final Uri uri = this.getIntent().getData();
		HashMap<String, String> params = new HashMap<String, String>(){{
			put("shop", uri.getQueryParameter("shop"));
			put("t", uri.getQueryParameter("t"));
			put("timestamp", uri.getQueryParameter("timestamp"));
			put("signature", uri.getQueryParameter("signature"));
		}};
		try {
			JsonDirectoryCredentialsStore store = new JsonDirectoryCredentialsStore(this.getFilesDir());
			String endpoint = params.get("shop");
			String shopname = endpoint.substring(0, endpoint.indexOf('.'));
			APIAuthorization auth = new APIAuthorization(store, shopname);
			auth.getAPIPassword(params);

			Intent i = new Intent(this, ShopifyProductListDemoActivity.class);
			Bundle extras = new Bundle();
			extras.putString("shop", shopname);
			i.putExtras(extras);

			startActivity(i);
			finish();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
