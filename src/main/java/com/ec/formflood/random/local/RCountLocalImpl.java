package com.ec.formflood.random.local;

import org.springframework.stereotype.Component;

import com.ec.formflood.random.RCount;


@Component("rCountLocalImpl")

public class RCountLocalImpl implements RCount{

	@Override
	public Integer random() {
		return 1;
	}

}
