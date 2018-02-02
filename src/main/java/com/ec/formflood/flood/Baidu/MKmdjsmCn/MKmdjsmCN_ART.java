package com.ec.formflood.flood.Baidu.MKmdjsmCn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.ec.common.model.BaseEntity;
import com.ec.common.spider.generic.AsyncRestTemplateSpider;
import com.ec.formflood.random.RProduct;
import com.ec.formflood.util.RandomUtil;

@Component("mKmdjsmCN_ART")
public class MKmdjsmCN_ART extends AsyncRestTemplateSpider {
	
	protected static final Logger LOGGER = LoggerFactory.getLogger(MKmdjsmCN_ART.class);

	@Autowired
	@Qualifier("mKmdjsmCNProduct")
	RProduct product;
	@Autowired
	RandomUtil randomUtil;
	
	static final String url="http://m.kmdjsm.cn/fopai/sub.asp";


	@Override
	public void crawl() {
		
		//setProxy(randomProxy.random(RProxy.ProxyType.HTTP));
		
		FloodEntity pro=new FloodEntity();
		pro.setFname(randomUtil.getName().random());
		pro.setFtel(randomUtil.getTelephone().random());
		pro.setFaddress(randomUtil.getAddress().random().toString());
		pro.setFchanpin(product.random().toString());
		pro.setRemark(randomUtil.getComment().random());
		
		try {
			HttpHeaders httpHeaders=genFormHeader();

			httpHeaders.add("Accept", "*/*");
			//httpHeaders.add("Accept-Encoding", "gzip, deflate");
			httpHeaders.add("Accept-Language", "zh-CN,zh;q=0.8");
			httpHeaders.add("Content-Length", "300");
			httpHeaders.add("Host", "m.kmdjsm.cn");
			httpHeaders.add("Origin", "http://m.kmdjsm.cn");
			httpHeaders.add("Proxy-Connection", "keep-alive");
			httpHeaders.add("Referer", "http://m.kmdjsm.cn/");
			httpHeaders.add("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.113 Safari/537.36");
			httpHeaders.add("X-Requested-With", "XMLHttpRequest");
			httpHeaders.add("Cookie", "safedog-flow-item=; enterdate=Wed%20Jan%2024%202018%2013%3A56%3A28%20GMT+0800%20%28%u4E2D%u56FD%u6807%u51C6%u65F6%u95F4%29; enddate=Wed%20Jan%2024%202018%2014%3A32%3A40%20GMT+0800%20%28%u4E2D%u56FD%u6807%u51C6%u65F6%u95F4%29; UM_distinctid=16126bd3120129-0e5afc8d134226-3a3e5f04-1fa400-16126bd31214b; CNZZDATA3200938=cnzz_eid%3D841815938-1516773965-%26ntime%3D1516773965; a5303_pages=1; a5303_times=1; __tins__19175303=%7B%22sid%22%3A%201516773388740%2C%20%22vd%22%3A%201%2C%20%22expires%22%3A%201516775188740%7D; __51cke__=; __51laig__=1; LiveWSLVT40898426=1516773388831420089072; LiveWSLVT40898426sessionid=1516773388831420089072; NLVT40898426fistvisitetime=1516773388851; NLVT40898426lastvisitetime=1516773388851; NLVT40898426visitecounts=1; NLVT40898426visitepages=1");
			
			
			
			
			
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
