package com.ec.formflood;

import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ec.common.ApplicationContext;
import com.ec.common.spider.dao.ProxyFeign;
import com.ec.common.spider.generic.AsyncRestTemplateSpider;

@RunWith(SpringRunner.class)
@SpringBootTest//(webEnvironment=SpringBootTest.WebEnvironment.RANDOM_PORT)
public class FormfloodApplicationTests {

	protected static final Logger LOGGER = LoggerFactory.getLogger(FormfloodApplicationTests.class);

	
	@Autowired
	protected ProxyFeign 	proxyFeign;
	
	@Test
	public void contextLoads() {
		System.err.println(proxyFeign.del("18020220981"));
		System.err.println(proxyFeign.del("18020220981").getErrorCode());
		System.err.println(proxyFeign.del("18020220981").getMessage());
		System.err.println(proxyFeign.del("18020220981").getData());
		
		
	}

}
