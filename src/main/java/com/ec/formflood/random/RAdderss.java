package com.ec.formflood.random;

public interface  RAdderss {
	public class AdderssEntity {
		String province;
		String city;
		String county;
		String adderss;

		public AdderssEntity(String province, String city, String county,String adderss) {
			super();
			this.province = province;
			this.city = city;
			this.county = county;
			this.adderss=adderss;
		}

		public String getProvince() {
			return province;
		}

		public void setProvince(String province) {
			this.province = province;
		}

		public String getCity() {
			return city;
		}

		public void setCity(String city) {
			this.city = city;
		}

		public String getCounty() {
			return county;
		}

		public void setCounty(String county) {
			this.county = county;
		}

		public String getAdderss() {
			return adderss;
		}

		public void setAdderss(String adderss) {
			this.adderss = adderss;
		}
		
		public String toString(){
			StringBuilder sb=new  StringBuilder();
			sb.append(this.getProvince()).append(getCity()).append(this.getCounty()).append(this.adderss);
			return sb.toString();
		}
	}
	
	
	

	public abstract  AdderssEntity random();
	
}
