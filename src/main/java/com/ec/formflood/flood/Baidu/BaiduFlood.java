package com.ec.formflood.flood.Baidu;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.ec.common.ApplicationContext;
import com.ec.formflood.flood.Flood;
@Service
public class BaiduFlood extends Flood<Baidu>{

	
	protected static final Logger LOGGER = LoggerFactory.getLogger(BaiduFlood.class);

	
	public Map<String, Baidu> getSpiders() {
		return ApplicationContext.getAPPLICATION_CONTEXT().getBeansOfType(Baidu.class, false, true);
	}


}
