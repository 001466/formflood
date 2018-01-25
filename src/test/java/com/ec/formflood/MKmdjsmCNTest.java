package com.ec.formflood;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.ec.formflood.flood.Flood;

public class MKmdjsmCNTest extends FormfloodApplicationTests{

	@Autowired
	@Qualifier("lvtZoosnetNET_ART")
	Flood flood;
	@Test
	public void contextLoads() {
		System.out.println(flood.getClass().getName());
		System.out.println(flood.getUrl());
		try {
			flood.flooding();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
		
	}
	
}
