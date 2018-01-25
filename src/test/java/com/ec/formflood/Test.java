package com.ec.formflood;

import java.util.concurrent.Future;

import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.nio.client.CloseableHttpAsyncClient;
import org.apache.http.impl.nio.client.HttpAsyncClients;

public class Test {
	 public static void main(String[] args)throws Exception {
	        CredentialsProvider credsProvider = new BasicCredentialsProvider();
	        credsProvider.setCredentials(
	                new AuthScope("localhost", 8889),
	                new UsernamePasswordCredentials("squid", "nopassword"));
	        
	        CloseableHttpAsyncClient httpclient = HttpAsyncClients.custom()
	                .setDefaultCredentialsProvider(credsProvider)
	                .build();
	        try {
	            httpclient.start();
	            HttpHost proxy = new HttpHost("localhost", 8889);
	            RequestConfig config = RequestConfig.custom()
	                    .setProxy(proxy)
	                    .build();
	            HttpGet httpget = new HttpGet("https://httpbin.org/");
	            httpget.setConfig(config);
	            Future<HttpResponse> future = httpclient.execute(httpget, null);
	            HttpResponse response = future.get();
	            System.out.println("Response: " + response.getStatusLine());
	            System.out.println("Shutting down");
	        } finally {
	            httpclient.close();
	        }
	    }
}
