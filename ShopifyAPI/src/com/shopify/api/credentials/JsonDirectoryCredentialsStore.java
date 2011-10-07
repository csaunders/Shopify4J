package com.shopify.api.credentials;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.codehaus.jackson.map.ObjectMapper;

public class JsonDirectoryCredentialsStore implements ShopifyCredentialsStore {
	private ObjectMapper mapper;
	private File directory;
	
	public JsonDirectoryCredentialsStore(String dirname) throws IOException {
		this(new File(dirname));
	}
	
	public JsonDirectoryCredentialsStore(File directory) throws IOException {
		if (!directory.isDirectory())
			throw new IOException("Expected a directory");
		this.directory = directory;
		this.mapper = new ObjectMapper();
	}
	
	public Credential loadCredential(String shop) throws Exception {
		File file = new File(directory, shop + ".json");
		return mapper.readValue(file, Credential.class);
	}
	
	public void saveCredential(Credential credential) throws Exception {
		String store = credential.getShopName();
		File file = new File(directory, store + ".json");
		mapper.writeValue(file, credential);
	}
	
	public Set<String> getAvailableShops() throws Exception{
		HashSet<String> credFiles = new HashSet<String>();
		
		File[] files = directory.listFiles(new FileFilter() {
			
			@Override
			public boolean accept(File pathname) {
				return pathname.getName().endsWith(".json");
			}
		});
		for(File f : files){
			String filename = f.getName();
			credFiles.add(filename.substring(0, filename.indexOf(".json")));
		}
		
		return credFiles;
	}
}
