package com.ec.formflood.random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ec.common.spider.dao.ProxyFeign;
import com.ec.common.spider.model.ProxyEntity;
import com.ec.common.spider.model.ProxyType;

@Component("proxy")
public class RProxy {


	
	@Autowired
	private ProxyFeign proxyFeign;
	
	public ProxyEntity random() {

		 ProxyEntity p = new ProxyEntity("163.125.99.84",9797,ProxyType.http);
		// ProxyEntity p = new
		// ProxyEntity("123.207.25.143",3128,ProxyType.HTTPS);
		//ProxyEntity p = new ProxyEntity("139.199.230.242", 1080, ProxyType.socks);
		//Response<ProxyEntity> res=proxiesFeign.get("http");
		//return res.getData();
		return p;
	}

	public ProxyEntity random(ProxyType type) {
		//Response<ProxyEntity> res=proxiesFeign.get(type.name());
		//return res.getData();
		
		 ProxyEntity p = new ProxyEntity("163.125.99.84",9797,ProxyType.http);
		 return p;
	}

}
