package com.shopify.android.productlistdemo;

import java.net.URI;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.shopify.api.APIAuthorization;
import com.shopify.api.credentials.Credential;
import com.shopify.api.credentials.JsonDirectoryCredentialsStore;

public class ShopifyAddShopActivity extends Activity implements OnClickListener{

	private Button authorizeButton;
	private EditText shopNameField;

	public void onCreate(Bundle instance) {
		super.onCreate(instance);
		setContentView(R.layout.add_shop_screen);

		authorizeButton = (Button) findViewById(R.id.addShopAuthorizeButton);
		authorizeButton.setOnClickListener(this);
		shopNameField = (EditText) findViewById(R.id.addShopShopname);
	}

	@Override
	public void onClick(View arg0) {
		if(shopNameField.getText().toString().length() < 0) {
			Toast.makeText(this, getString(R.string.missingShopName), Toast.LENGTH_SHORT);
		} else {
			constructShopAuthRequest();
		}
	}

	public void constructShopAuthRequest() {
		String shopname = shopNameField.getText().toString();
		try {
			JsonDirectoryCredentialsStore store = new JsonDirectoryCredentialsStore(getFilesDir());
			Credential emptyCredential = makeEmptyCredential(shopname);
			store.saveCredential(emptyCredential);

			APIAuthorization auth = new APIAuthorization(emptyCredential);
			URI authRequest = auth.generateAuthRequest();
			Intent launchBrowserIntent = new Intent(Intent.ACTION_VIEW);
			launchBrowserIntent.setData(Uri.parse(authRequest.toString()));
			startActivity(launchBrowserIntent);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected Credential makeEmptyCredential(String shopname) {
		String apiKey = getString(R.string.shopify_api_key);
		String sekret = getString(R.string.shopify_shared_secret);
		return new Credential(apiKey, sekret, shopname);
	}
}
