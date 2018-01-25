package com.ec.formflood.random;

import org.springframework.stereotype.Component;

@Component("proxy")
public class RProxy {

	public static enum ProxyType {
		/**
		 * Represents a direct connection, or the absence of a proxy.
		 */
		DIRECT,
		/**
		 * Represents proxy for high level protocols such as HTTP or FTP.
		 */
		HTTP,

		HTTPS,
		/**
		 * Represents a SOCKS (V4 or V5) proxy.
		 */
		SOCKS

	};

	public class ProxyEntity {

		String id;
		String ip;
		Integer port;
		ProxyType protocol;
		String username;
		String password;

		public ProxyEntity() {};
		public ProxyEntity(String ip,Integer port,ProxyType type) {
			this.ip=ip;
			this.port=port;
			this.protocol=type;
		};
		 

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getIp() {
			return ip;
		}

		public void setIp(String ip) {
			this.ip = ip;
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

		public ProxyType getProtocol() {
			return protocol;
		}

		public void setProtocol(ProxyType protocol) {
			this.protocol = protocol;
		}
	}

	public ProxyEntity random() {

		//ProxyEntity p = new ProxyEntity("163.125.99.84",9797,ProxyType.HTTP);
		//ProxyEntity p = new ProxyEntity("123.207.25.143",3128,ProxyType.HTTPS);
		ProxyEntity p = new ProxyEntity("139.199.230.242",1080,ProxyType.SOCKS);
		
		return p;
	}
	
	public ProxyEntity random(ProxyType type) {
		 ProxyEntity p = new ProxyEntity("139.199.230.242",1080,type);
		 return p;
	}

}
