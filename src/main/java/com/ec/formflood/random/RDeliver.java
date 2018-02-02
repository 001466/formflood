package com.ec.formflood.random;

public interface RDeliver {
	public class DeliverEntity {
		String id;
		String name;
		String time;
		String type;
		public DeliverEntity(String name, String time, String type) {
			super();
			this.name = name;
			this.time = time;
			this.type = type;
		}
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getTime() {
			return time;
		}
		public void setTime(String time) {
			this.time = time;
		}
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
	}
	public DeliverEntity random();

}
