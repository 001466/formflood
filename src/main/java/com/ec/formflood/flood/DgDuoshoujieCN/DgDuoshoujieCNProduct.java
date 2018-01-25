package com.ec.formflood.flood.DgDuoshoujieCN;

import org.springframework.stereotype.Component;

import com.ec.formflood.random.RProduct;
import com.ec.formflood.random.RProduct.ProductEntity;

@Component("dgDuoshoujieCNProduct")
public class DgDuoshoujieCNProduct extends RProduct {
	
	public static class MKmdjsmCNProductEntity extends RProduct.ProductEntity{

		public MKmdjsmCNProductEntity(String name,  String type,Double prices) {
			super(name,type,prices);
		}
		
		public String toString(){
			StringBuilder sb=new  StringBuilder();
			sb.append(this.getName()).append(this.getPrices()).append("元");
			return sb.toString();
		}
		
	}

	@Override
	public ProductEntity random() {
		return new MKmdjsmCNProductEntity("天然白玛瑙       本命佛",null,398D);
	}

}
