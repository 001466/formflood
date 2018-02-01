package com.ec.formflood.random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ec.common.model.BaseEntity;
import com.ec.common.model.Response;
import com.ec.formflood.dao.ProxiesFeign;
import com.ec.formflood.model.ProxyType;

@Component("proxy")
public class RProxy {

	public static class ProxyEntity extends BaseEntity{

		String 		id;
		String 		host;
		Integer 	port;
		ProxyType 	protl;
		String 		username;
		String 		password;

		public ProxyEntity() {
		};

		public ProxyEntity(String ip, Integer port, ProxyType type) {
			this.host = ip;
			this.port = port;
			this.protl = type;
		};

		public String getHost() {
			return host;
		}

		public void setHost(String host) {
			this.host = host;
		}

		public ProxyType getProtl() {
			return protl;
		}

		public void setProtl(ProxyType protl) {
			this.protl = protl;
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public Integer getPort() {
			return port;
		}

		public void setPort(Integer port) {
			this.port = port;
		}

	}

	
	@Autowired
	private ProxiesFeign proxiesFeign;
	
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
