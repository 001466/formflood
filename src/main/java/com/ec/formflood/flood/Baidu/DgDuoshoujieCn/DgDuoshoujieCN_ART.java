package com.ec.formflood.flood.Baidu.DgDuoshoujieCn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

import com.ec.common.model.BaseEntity;
import com.ec.common.spider.generic.AsyncRestTemplateSpider;
import com.ec.formflood.flood.Baidu.Baidu;
import com.ec.formflood.random.RProduct;

@Component("dgDuoshoujieCN_ART")
public class DgDuoshoujieCN_ART extends AsyncRestTemplateSpider implements Baidu {
	
	protected static final Logger LOGGER = LoggerFactory.getLogger(DgDuoshoujieCN_ART.class);
	
	@Autowired
	@Qualifier("dgDuoshoujieCNProduct")
	RProduct product;
	
	static final String url="http://dg.duoshoujie.cn/fopai/submit.asp";

	@Override
	public void crawl() {
		
		
		//setProxy(randomProxy.random(RProxy.ProxyType.HTTP));
		
		FloodEntity pro=new FloodEntity();
		pro.setFname(name.random());
		pro.setFtel(telephone.random());
		pro.setFaddress(address.random().toString());
		pro.setFchanpin(product.random().toString());
		pro.setRemark(comment.random());
		
		try {
			
			
			HttpHeaders httpHeaders=genFormHeader();

			
			
					
			httpHeaders.add("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8");
			httpHeaders.add("Accept-Encoding", "gzip, deflate");
			httpHeaders.add("Accept-Language", "zh-CN,zh;q=0.8");
			
			
			httpHeaders.add("Cache-Control", "no-cache");
			httpHeaders.add("Content-Type", "application/x-www-form-urlencoded");
			httpHeaders.add("Pragma", "no-cache");
			httpHeaders.add("Upgrade-Insecure-Requests", "1");
			
			
			
			httpHeaders.add("Content-Length", "461");
			httpHeaders.add("Host", "dg.duoshoujie.cn");
			httpHeaders.add("Origin", "http://m.kmdjsm.cn");
			httpHeaders.add("Proxy-Connection", "keep-alive");
			httpHeaders.add("Referer", "http://m.kmdjsm.cn/");
			httpHeaders.add("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.113 Safari/537.36");
			httpHeaders.add("X-Requested-With", "XMLHttpRequest");
			//httpHeaders.add("Cookie", "ASPSESSIONIDACAARSRR=NIJLCBCALDLMMLFKCOMIDOHG; path=/");
			
			
			postXForm(pro, url,httpHeaders);
			
		} catch (Exception e) {
			 LOGGER.error(e.getMessage(),e);
		}

	}
	
	
	
	
	
	
	@Override
	public String getUrl() {
		return url;
	}
	
	
	
	private class FloodEntity extends BaseEntity{
		String fname;
		Long ftel;
		String faddress;
		String fchanpin;
		String remark;
		public String getFname() {
			return fname;
		}
		public void setFname(String fname) {
			this.fname = fname;
		}
		public Long getFtel() {
			return ftel;
		}
		public void setFtel(Long ftel) {
			this.ftel = ftel;
		}
		public String getFaddress() {
			return faddress;
		}
		public void setFaddress(String faddress) {
			this.faddress = faddress;
		}
		public String getFchanpin() {
			return fchanpin;
		}
		public void setFchanpin(String fchanpin) {
			this.fchanpin = fchanpin;
		}
		public String getRemark() {
			return remark;
		}
		public void setRemark(String remark) {
			this.remark = remark;
		}
	}










	



	 
}
