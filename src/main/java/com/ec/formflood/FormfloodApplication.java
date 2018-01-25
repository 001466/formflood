package com.ec.formflood;

import org.apache.http.impl.nio.client.CloseableHttpAsyncClient;
import org.apache.http.impl.nio.client.HttpAsyncClientBuilder;
import org.apache.http.impl.nio.conn.PoolingNHttpClientConnectionManager;
import org.apache.http.impl.nio.reactor.DefaultConnectingIOReactor;
import org.apache.http.impl.nio.reactor.IOReactorConfig;
import org.apache.http.nio.reactor.ConnectingIOReactor;
import org.apache.http.nio.reactor.IOReactorException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.client.HttpComponentsAsyncClientHttpRequestFactory;
import org.springframework.web.client.AsyncRestTemplate;

@SpringBootApplication
@ComponentScan(basePackages={"com.ec"})
public class FormfloodApplication {
	
	private  static final Logger  LOGGER = LoggerFactory.getLogger(FormfloodApplication.class);

	

	@Value("${httpclient.timeout:500}")
	private int httpclientTimeout;

	@Value("${httpclient.pooling.max-total:16}")
	private int httpclientPoolingMaxTotal;

	@Value("${httpclient.pooling.max-per-route:16}")
	private int httpclientPoolingMaxPerRoute;
	
	
	@Bean("poolingNHttpClientConnectionManager")
	PoolingNHttpClientConnectionManager poolingNHttpClientConnectionManager() throws IOReactorException{
		ConnectingIOReactor ioReactor = new DefaultConnectingIOReactor();
        PoolingNHttpClientConnectionManager poolingHttpClientConnectionManager = new PoolingNHttpClientConnectionManager(ioReactor);
		poolingHttpClientConnectionManager.setMaxTotal(httpclientPoolingMaxTotal); 
		poolingHttpClientConnectionManager.setDefaultMaxPerRoute(httpclientPoolingMaxPerRoute);  
		if(LOGGER.isInfoEnabled())LOGGER.info("Initializing PoolingHttpClientConnectionManager:"+poolingHttpClientConnectionManager.getTotalStats());
		return poolingHttpClientConnectionManager;
	}
	

	@Bean("asyncRestTemplate")
	public AsyncRestTemplate asyncRestTemplate() throws IOReactorException {
		
		
	    IOReactorConfig ioReactorConfig = IOReactorConfig.custom()
	    		//.setIoThreadCount(httpclientPoolingMaxPerRoute)
	    		.setConnectTimeout(httpclientTimeout)
	    		.setSoTimeout(httpclientTimeout)
	    		.setSoKeepAlive(true)
	    		.setSoReuseAddress(true)
	    		. build();

	    CloseableHttpAsyncClient httpClient = HttpAsyncClientBuilder
			        .create()
			        .setConnectionManager(poolingNHttpClientConnectionManager())
			        .setMaxConnPerRoute(httpclientPoolingMaxPerRoute)
					.setMaxConnTotal(httpclientPoolingMaxTotal)
					.setDefaultIOReactorConfig(ioReactorConfig)
			        .build();
		HttpComponentsAsyncClientHttpRequestFactory clientHttpRequestFactory = new HttpComponentsAsyncClientHttpRequestFactory(httpClient);
		//clientHttpRequestFactory.setConnectionRequestTimeout(5);
		clientHttpRequestFactory.setConnectTimeout(httpclientTimeout);
		clientHttpRequestFactory.setReadTimeout(httpclientTimeout);
		if(LOGGER.isInfoEnabled())LOGGER.info("Initializing Test HttpRequestFactory:"+clientHttpRequestFactory);
		return new AsyncRestTemplate(clientHttpRequestFactory);
	}
	

	public static void main(String[] args) {
		SpringApplication.run(FormfloodApplication.class, args);
	}
}
