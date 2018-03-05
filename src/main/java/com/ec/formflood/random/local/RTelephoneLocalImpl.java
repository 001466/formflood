package com.ec.formflood.random.local;

import java.util.Random;

import org.springframework.stereotype.Component;

import com.ec.formflood.random.RTelephone;
@Component("rTelephoneLocalImpl")

public class RTelephoneLocalImpl implements RTelephone{

	
	java.util.Random randdom=new Random();
	
	String tel0[]=new String[]{"139","138","137","136","135","134","159","158","157","150","151","152","188","130","131","132","156","155","133","153","189"};
	private static int strategyIndex = 0;

	@Override
	public Long random() {
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<8;i++){
			sb.append(randdom.nextInt(9));
		}
		
		strategyIndex = ++strategyIndex % tel0.length;

		String telStr=tel0[strategyIndex]+sb.toString();
		return Long.parseLong(telStr);
	}


}
