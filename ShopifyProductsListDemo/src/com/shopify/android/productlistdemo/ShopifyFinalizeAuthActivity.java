package com.shopify.android.productlistdemo;

import java.io.IOException;
import java.util.HashMap;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.shopify.api.APIAuthorization;
import com.shopify.api.android.GenericShopifyCallbackActivity;
import com.shopify.api.credentials.JsonDirectoryCredentialsStore;

public class ShopifyFinalizeAuthActivity extends GenericShopifyCallbackActivity {
	
	@Override
	public Class<?> getOnSuccessActivity(){
		return ShopifyProductListDemoActivity.class;
	}

}
