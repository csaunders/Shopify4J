package com.shopify.api.android;

import java.net.URI;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import com.shopify.api.APIAuthorization;
import com.shopify.api.credentials.Credential;
import com.shopify.api.credentials.ShopifyCredentialsStore;

public class AuthorizationHelper {
	ShopifyCredentialsStore store;
	String apiKey, sharedSecret;
	
	public AuthorizationHelper(Context ctx, ShopifyCredentialsStore store, int apiKeyId, int apiSecretId) {
		this(ctx, store, ctx.getString(apiKeyId), ctx.getString(apiSecretId));
	}
	
	public AuthorizationHelper(Context ctx, ShopifyCredentialsStore store, String apiKey, String apiSecret) {
		this.apiKey = apiKey;
		this.sharedSecret = apiSecret;
		this.store = store;
	}
	
	public void sendAuthRequest(Context ctx, String shopname) throws Exception{
		Credential cred = new Credential(apiKey, sharedSecret, shopname);
		store.saveCredential(cred);
		
		APIAuthorization auth = new APIAuthorization(cred);
		URI authRequest = auth.generateAuthRequest();
		Intent launchBrowser = new Intent(Intent.ACTION_VIEW);
		launchBrowser.setData(Uri.parse(authRequest.toString()));
		ctx.startActivity(launchBrowser);
	}
}
