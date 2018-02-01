package com.ec.formflood.flood.Baidu.DgDuoshoujieCN;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.ec.common.spider.generic.URLSpider;
import com.ec.formflood.random.RProduct;

@Component("dgDuoshoujieCN_URL")
public class DgDuoshoujieCN_URL extends URLSpider implements InitializingBean{

	protected static final Logger LOGGER = LoggerFactory.getLogger(DgDuoshoujieCN_URL.class);
	
	static final String url="http://dg.duoshoujie.cn/fopai/submit.asp";
	
	@Autowired
	@Qualifier("dgDuoshoujieCNProduct")
	RProduct product;


	
	@Override
	public void crawl()  {
		
		
		 List<NameValuePair> params = new ArrayList<NameValuePair>();
		  params.add(new BasicNameValuePair("fname", name.random()));
	        params.add(new BasicNameValuePair("ftel", telephone.random().toString()));
	        params.add(new BasicNameValuePair("faddress", address.random().toString()));
	        params.add(new BasicNameValuePair("fchanpin", product.random().toString()));
	        params.add(new BasicNameValuePair("remark", comment.random().toString()));
		
		try{
			
			
			//setProxy(randomProxy.random(RProxy.ProxyType.HTTP));
			
	        connection.setDoOutput(true);
	        connection.setDoInput(true);
	        
	        connection.setRequestMethod("POST");
	        
	    	connection.setRequestProperty("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8");
			connection.setRequestProperty("Accept-Encoding", "gzip, deflate");
			connection.setRequestProperty("Accept-Language", "zh-CN,zh;q=0.8");
			
			
			connection.setRequestProperty("Cache-Control", "no-cache");
			connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			connection.setRequestProperty("Pragma", "no-cache");
			connection.setRequestProperty("Upgrade-Insecure-Requests", "1");
			
			
			
			connection.setRequestProperty("Content-Length", "461");
			connection.setRequestProperty("Host", "dg.duoshoujie.cn");
			connection.setRequestProperty("Origin", "http://m.kmdjsm.cn");
			connection.setRequestProperty("Proxy-Connection", "keep-alive");
			connection.setRequestProperty("Referer", "http://m.kmdjsm.cn/");
			connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.113 Safari/537.36");
			connection.setRequestProperty("X-Requested-With", "XMLHttpRequest");
			
			//不用Cookie也可以发送成功
			//connection.setRequestProperty("Cookie", "ASPSESSIONIDACAARSRR=NIJLCBCALDLMMLFKCOMIDOHG; path=/");
			//connection.setRequestProperty("Cookie", "UM_distinctid=16068af1d46757-02285eeaf4e554-3a3e5f04-1fa400-16068af1d4745a; LiveWSLVT40898426=1513584795236546288077; NLVT40898426fistvisitetime=1513584795242; ASPSESSIONIDSSDTADSB=JHHDKJPDPECKNNDIOKKDIDJK; NLVT40898426IP=%7C210.21.98.123%7C198.13.51.96%7C; ASPSESSIONIDQSCQCDSA=DIBFDEKAILANIGNGILKNGEAN; ASPSESSIONIDQSDSBAQD=IPFLKFAAMPGEGLHFDFMGENBO; safedog-flow-item=; enddate=Wed%20Jan%2024%202018%2013%3A00%3A37%20GMT+0800%20%28%u4E2D%u56FD%u6807%u51C6%u65F6%u95F4%29; LiveWSLVT40898426sessionid=1516767865999392467111; NLVT40898426visitecounts=8; CNZZDATA3200938=cnzz_eid%3D1371927669-1513584242-https%253A%252F%252Fwww.baidu.com%252F%26ntime%3D1516768463; a5303_pages=2; a5303_times=10; __tins__19175303=%7B%22sid%22%3A%201516767865989%2C%20%22vd%22%3A%202%2C%20%22expires%22%3A%201516769710094%7D; __51cke__=; __51laig__=16; NLVT40898426lastvisitetime=1516767910241; NLVT40898426visitepages=24");
	        

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
	
	
	
	


	public String getUrl() {
		return url;
	}




}
