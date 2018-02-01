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
import com.ec.common.spider.generic.AsyncRestTemplateSpider;
import com.ec.formflood.random.RProxy;

@RunWith(SpringRunner.class)
@SpringBootTest//(webEnvironment=SpringBootTest.WebEnvironment.RANDOM_PORT)
public class FormfloodApplicationTests {

	protected static final Logger LOGGER = LoggerFactory.getLogger(FormfloodApplicationTests.class);

	@Autowired
	RProxy rProxy;

	@Test
	public void contextLoads() {
		LOGGER.error("FormfloodApplicationTests");
		System.err.println("FormfloodApplicationTests");
		//System.err.println(rProxy.random());
		
		Map<String, AsyncRestTemplateSpider> spiderMap=ApplicationContext.getAPPLICATION_CONTEXT().getBeansOfType(AsyncRestTemplateSpider.class, false, true);
		System.err.println("Size:"+spiderMap.size());
		
		for(AsyncRestTemplateSpider spider:spiderMap.values()){
			spider.crawl();
		}  
		
		
	}

}
