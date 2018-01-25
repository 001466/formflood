package com.ec.formflood.flood;

import com.ec.formflood.random.RProxy;

public interface Flood {
	public String getUrl();

	public void flooding();

	public void setProxy(RProxy.ProxyEntity proxyEntity);
	
	public RProxy.ProxyEntity getProxy();

}
