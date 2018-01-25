package com.ec.formflood.flood;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.zip.GZIPInputStream;

import org.apache.http.NameValuePair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.ec.formflood.random.RAdderss;
import com.ec.formflood.random.RComment;
import com.ec.formflood.random.RName;
import com.ec.formflood.random.RProduct;
import com.ec.formflood.random.RProxy;
import com.ec.formflood.random.RTelephone;

public abstract class FloodAbstract implements Flood {
	
	@Autowired
	protected RProxy 	randomProxy;
	
	@Autowired
	protected RName name;
	@Autowired
	protected RTelephone telephone;
	@Autowired
	protected RAdderss address;
	@Autowired
	protected RComment comment;
	

	protected RProxy.ProxyEntity proxyEntity;

	@Override
	public RProxy.ProxyEntity getProxy() {
		return proxyEntity;
	}

	public void setProxyEntity(RProxy.ProxyEntity proxyEntity) {
		this.proxyEntity = proxyEntity;
	}

	protected static byte[] decode(byte[] b) throws IOException {

		ByteArrayOutputStream out = new ByteArrayOutputStream();
		ByteArrayInputStream in = new ByteArrayInputStream(b);
		GZIPInputStream gunzip = new GZIPInputStream(in);
		byte[] buffer = new byte[256];
		int n;
		while ((n = gunzip.read(buffer)) >= 0) {
			out.write(buffer, 0, n);
		}
		return out.toByteArray();
	}

	protected static String decode(java.io.InputStream is) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(is,"UTF-8"));
		String data;
		StringBuilder sb = new StringBuilder();
		while ((data = br.readLine()) != null) {
			sb.append(data).append("\r\n");
		}
		return sb.toString();
	}
	
	
	
	
	public String getQuery(List<NameValuePair> params) throws UnsupportedEncodingException
	{
	    StringBuilder result = new StringBuilder();
	    boolean first = true;

	    for (NameValuePair pair : params)
	    {
	        if (first)
	            first = false;
	        else
	            result.append("&");

	        result.append(URLEncoder.encode(pair.getName(), "UTF-8"));
	        result.append("=");
	        result.append(URLEncoder.encode(pair.getValue(), "UTF-8"));
	    }

	    return result.toString();
	}

}
