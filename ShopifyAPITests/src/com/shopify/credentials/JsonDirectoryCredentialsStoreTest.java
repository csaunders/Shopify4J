package com.shopify.credentials;

import java.io.File;
import java.util.Set;

import android.content.Context;
import android.test.InstrumentationTestCase;

import com.shopify.api.credentials.Credential;
import com.shopify.api.credentials.JsonDirectoryCredentialsStore;

public class JsonDirectoryCredentialsStoreTest extends InstrumentationTestCase {

	Credential cred;
	JsonDirectoryCredentialsStore store;
	Context ctx;
	
	String[] filesToDelete;

	public void setUp() throws Exception {
		filesToDelete = new String[] { "snowdevil.json" };
		cred = new Credential("abcdef1234567890", "0987654321fedcba", "snowdevil");
		store = new JsonDirectoryCredentialsStore(getInstrumentation().getContext().getFilesDir());
		ctx = getInstrumentation().getContext();
	}

	public void tearDown() throws Exception {
		ctx.deleteFile("snowdevil.json");
	}

	public void testJSONCredentialsStoreCreation() throws Exception {
		store.saveCredential(cred);

		File expectedSavedFile = new File(ctx.getFilesDir(), "snowdevil.json");
		assertTrue(expectedSavedFile.exists());
	}

	public void testJSONCredentialsStoreLoading() throws Exception {
		store.saveCredential(cred);

		Credential fromDisk = store.loadCredential("snowdevil");
		assertEquals("abcdef1234567890", fromDisk.getApiKey());
		assertEquals("0987654321fedcba", fromDisk.getSharedSecret());
		assertEquals(null, fromDisk.getPassword());
		assertEquals("snowdevil", fromDisk.getShopName());
	}
	
	public void testGetCredentialsSet() throws Exception {
		filesToDelete = new String[] {"snowdevil.json", "shopify.json", "thiswillnotwork"};
		
		for(String f : filesToDelete) {
			new File(ctx.getFilesDir(), f).createNewFile();
		}
		
		Set<String> credFiles = store.getAvailableShops();
		assertEquals(2, credFiles.size());
		assertTrue(credFiles.contains("snowdevil"));
		assertTrue(credFiles.contains("shopify"));
		assertFalse(credFiles.contains("thiswillnotwork"));
	}

}
