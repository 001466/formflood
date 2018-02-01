package com.ec.common.spider;

import com.ec.formflood.random.RProxy;

public interface Spider {
	
	public String getUrl();

	public void crawl();

	public void setProxy(RProxy.ProxyEntity proxyEntity);
	
	public RProxy.ProxyEntity getProxy();

}
