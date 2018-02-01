package com.ec.formflood;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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
		System.err.println(rProxy.random());
	}

}
