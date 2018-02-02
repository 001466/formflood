package com.ec.formflood.random.local;

import org.springframework.stereotype.Component;

import com.ec.formflood.random.RTelephone;
@Component("rTelephoneLocalImpl")

public class RTelephoneLocalImpl implements RTelephone{

	@Override
	public Long random() {
		// TODO Auto-generated method stub
		return 13049682423L;
	}

}
