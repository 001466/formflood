package com.ec.formflood.random.local;

import org.springframework.stereotype.Component;

import com.ec.formflood.random.RName;
@Component("rNameLocalImpl")

public class RNameLocalImpl implements RName{

	@Override
	public String random() {
		// TODO Auto-generated method stub
		return "李明";
	}

}
