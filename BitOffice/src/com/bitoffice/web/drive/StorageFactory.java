package com.bitoffice.web.drive;


import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.storage.Storage;
import com.google.api.services.storage.StorageScopes;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Collection;


public class StorageFactory {
	private static Storage instance = null;

	public static synchronized Storage getService() throws IOException, GeneralSecurityException {
		if (instance == null) {
			instance = buildService();
		}
		return instance;
	}

	private static Storage buildService() throws IOException, GeneralSecurityException {
		HttpTransport transport = GoogleNetHttpTransport.newTrustedTransport();
		JsonFactory jsonFactory = new JacksonFactory();
		GoogleCredential credential = GoogleCredential.getApplicationDefault(transport, jsonFactory);
		
		if (credential.createScopedRequired()) {
			Collection<String> scopes = StorageScopes.all();
			credential = credential.createScoped(scopes);
		}
		
		HttpRequestInitializer httpRequestInitializer = new RetryHttpInitializerWrapper(credential);
		return new Storage.Builder(transport, jsonFactory, httpRequestInitializer)
		.setApplicationName("woojootestcloud")
		.build();
		

	}
}

