package com.ec.formflood.random;

public interface  RProduct {
	public static  class ProductEntity {

		String id;
		String name;
		String type;
		Double prices;

		public ProductEntity(String name,  String type,Double prices) {
			super();
			this.name = name;
			this.prices = prices;
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

		public Double getPrices() {
			return prices;
		}

		public void setPrices(Double prices) {
			this.prices = prices;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}
	}

	public abstract ProductEntity random();
}
