package com.ec.formflood;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.ec.common.spider.Spider;

public class MKmdjsmCNTest extends FormfloodApplicationTests{

	@Autowired
	@Qualifier("dgDuoshoujieCN_ART")
	Spider flood;
	@Test
	public void contextLoads() {
		System.out.println(flood.getClass().getName());
		System.out.println(flood.getUrl());
		try {
			flood.crawl();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
		
	}
	
}
