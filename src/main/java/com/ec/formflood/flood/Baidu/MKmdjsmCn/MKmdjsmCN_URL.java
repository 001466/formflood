package com.ec.formflood.flood.Baidu.MKmdjsmCn;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.ec.common.spider.generic.URLSpider;

@Component("mKmdjsmCN_URL")
public class MKmdjsmCN_URL extends URLSpider implements InitializingBean{

	protected static final Logger LOGGER = LoggerFactory.getLogger(MKmdjsmCN_URL.class);

	static final String url="http://m.kmdjsm.cn/fopai/sub.asp";
	
	
	 

	@Override
	public void crawl()  {

        List<NameValuePair> params = new ArrayList<NameValuePair>();



		try{
			
			//setProxy(randomProxy.random(RProxy.ProxyType.HTTP));
		
	        connection.setDoOutput(true);
	        connection.setDoInput(true);
	        
	        connection.setRequestMethod("POST");
	        connection.setRequestProperty("Accept", "*/*");
	        connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
	        connection.setRequestProperty("Accept-Encoding", "gzip, deflate");
	        connection.setRequestProperty("Accept-Language", "zh-CN,zh;q=0.8");
	        connection.setRequestProperty("Host", URL.getHost());
	        connection.setRequestProperty("Origin", "http://m.kmdjsm.cn");
	        connection.setRequestProperty("Proxy-Connection", "keep-alive");
	        connection.setRequestProperty("Referer", "http://m.kmdjsm.cn/");
	        connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.113 Safari/537.36");
	        connection.setRequestProperty("X-Requested-With", "XMLHttpRequest");
	        connection.setRequestProperty("Cookie", "safedog-flow-item=; enterdate=Wed%20Jan%2024%202018%2013%3A56%3A28%20GMT+0800%20%28%u4E2D%u56FD%u6807%u51C6%u65F6%u95F4%29; enddate=Wed%20Jan%2024%202018%2014%3A32%3A40%20GMT+0800%20%28%u4E2D%u56FD%u6807%u51C6%u65F6%u95F4%29; UM_distinctid=16126bd3120129-0e5afc8d134226-3a3e5f04-1fa400-16126bd31214b; CNZZDATA3200938=cnzz_eid%3D841815938-1516773965-%26ntime%3D1516773965; a5303_pages=1; a5303_times=1; __tins__19175303=%7B%22sid%22%3A%201516773388740%2C%20%22vd%22%3A%201%2C%20%22expires%22%3A%201516775188740%7D; __51cke__=; __51laig__=1; LiveWSLVT40898426=1516773388831420089072; LiveWSLVT40898426sessionid=1516773388831420089072; NLVT40898426fistvisitetime=1516773388851; NLVT40898426lastvisitetime=1516773388851; NLVT40898426visitecounts=1; NLVT40898426visitepages=1");
	        connection.setRequestProperty("Content-Length", "397");
	        connection.setRequestProperty("Connection", "Keep-Alive");
	       
	       
	        params.add(new BasicNameValuePair("fname", "李四"));
	        params.add(new BasicNameValuePair("ftel", "13049682450"));
	        params.add(new BasicNameValuePair("faddress", "广东省怀从县准墒针镇受三村"));
	        params.add(new BasicNameValuePair("fchanpin", "天然白玛瑙 本命佛398元"));
	        params.add(new BasicNameValuePair("remark", "xxxxxxxxxx"));
	        
	        

	        OutputStream os = connection.getOutputStream();
	        BufferedWriter writer = new BufferedWriter(
	                new OutputStreamWriter(os, "UTF-8"));
	        writer.write(getQuery(params));
	        writer.flush();
	        
	        onSuccess(connection, params);

	        
		}catch(Exception ex){
			try {
				onFailure(connection, params,ex);
			} catch (IOException e) {
				LOGGER.error(e.getMessage(),e);
			}
		}finally{
			params.clear();
		}
        
	
	
	
	}
	
	
	


	@Override
	public String getUrl() {
		return url;
	}






}
